package com.lfa.neo4j.data.demo.config;

import com.zaxxer.hikari.util.DriverDataSource;
import liquibase.ext.neo4j.database.jdbc.Neo4jDriver;
import liquibase.integration.spring.SpringLiquibase;
import org.neo4j.cypherdsl.core.renderer.Dialect;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jAuditing;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableNeo4jAuditing(dateTimeProviderRef = "offsetDatetimeProvider", auditorAwareRef = "springSecurityAuditorAware")
public class AppConfig {

    @Bean
    public synchronized SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(getLiquibaseDatasource());
        liquibase.setChangeLog(liquibaseProperties().getChangeLog());
        liquibase.setClearCheckSums(liquibaseProperties().isClearChecksums());
        liquibase.setContexts(liquibaseProperties().getContexts());
        liquibase.setDefaultSchema(liquibaseProperties().getDefaultSchema());
        liquibase.setLiquibaseSchema(liquibaseProperties().getLiquibaseSchema());
        liquibase.setLiquibaseTablespace(liquibaseProperties().getLiquibaseTablespace());
        liquibase.setDatabaseChangeLogTable(liquibaseProperties().getDatabaseChangeLogTable());
        liquibase.setDatabaseChangeLogLockTable(liquibaseProperties().getDatabaseChangeLogLockTable());
        liquibase.setDropFirst(liquibaseProperties().isDropFirst());
        liquibase.setShouldRun(liquibaseProperties().isEnabled());
        liquibase.setLabelFilter(liquibaseProperties().getLabelFilter());
        liquibase.setChangeLogParameters(liquibaseProperties().getParameters());
        liquibase.setRollbackFile(liquibaseProperties().getRollbackFile());
        liquibase.setTestRollbackOnUpdate(liquibaseProperties().isTestRollbackOnUpdate());
        liquibase.setTag(liquibaseProperties().getTag());
        return liquibase;
    }

    private synchronized DataSource getLiquibaseDatasource() {
        return new DriverDataSource(
                liquibaseProperties().getUrl(),
                Neo4jDriver.class.getName(),
                new Properties(),
                liquibaseProperties().getUser(),
                liquibaseProperties().getPassword());
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.liquibase")
    public LiquibaseProperties liquibaseProperties() {
        return new LiquibaseProperties();
    }

    @Bean
    public org.neo4j.cypherdsl.core.renderer.Configuration cypherDslConfiguration() {
        return org.neo4j.cypherdsl.core.renderer.Configuration.newConfig()
                .withDialect(Dialect.NEO4J_5)
                .build();
    }

    @Bean("offsetDatetimeProvider")
    public OffsetDatetimeProvider offsetDatetimeProvider() {
        return new OffsetDatetimeProvider();
    }

    @Bean
    public SpringSecurityAuditorAware springSecurityAuditorAware() {
        return new SpringSecurityAuditorAware();
    }
}
