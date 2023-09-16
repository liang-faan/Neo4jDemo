package com.lfa.neo4j.harness;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.log4j.Log4j2;
import org.neo4j.configuration.GraphDatabaseSettings;
import org.neo4j.configuration.connectors.BoltConnector;
import org.neo4j.harness.Neo4j;
import org.neo4j.harness.Neo4jBuilders;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.List;

@SpringBootApplication
@Log4j2
public class Neo4jHarnessApplication {

    private Neo4j neo4j;

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Neo4jHarnessApplication.class);
        builder.web(WebApplicationType.REACTIVE);
        builder.run(args);
    }

    @PostConstruct
    public void startNeo4jHarness() {
        log.info("Starting Neo4j Harness Server");
        neo4j = Neo4jBuilders.newInProcessBuilder()
                .withDisabledServer()
                .withConfig(GraphDatabaseSettings.procedure_unrestricted, List.of("apoc.*"))
                .withConfig(BoltConnector.listen_address, BoltConnector.listen_address.defaultValue())
                .withConfig(BoltConnector.advertised_address, BoltConnector.advertised_address.defaultValue())
                .build();
        log.info("Neo4j Harness Server Initialization Completed {}", neo4j.boltURI().toString());
    }

    @PreDestroy
    public void closedHarnessServer() {
        log.info("Shutting down Neo4j Harness Server.");
        if (neo4j != null) neo4j.close();
    }

}
