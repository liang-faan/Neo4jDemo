package com.lfa.neo4j.data.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.util.DriverDataSource;
import liquibase.ext.neo4j.database.jdbc.Neo4jDriver;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Driver;
import java.util.Properties;

@Configuration
public class AppConfig {
    @Bean
    public synchronized SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource());
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

//    @Bean
    private synchronized DataSource dataSource() {
//        DataSourceBuilder<DriverDataSource> hikariDataSource = DataSourceBuilder.create().type(DriverDataSource.class);
//        hikariDataSource.driverClassName(Neo4jDriver.class.getName());
//        hikariDataSource.url(liquibaseProperties().getUrl());
//        hikariDataSource.username(liquibaseProperties().getUser());
//        hikariDataSource.password(liquibaseProperties().getPassword());
        return new DriverDataSource(
                liquibaseProperties().getUrl(),
                Neo4jDriver.class.getName(),
                new Properties(),
                liquibaseProperties().getUser(),
                liquibaseProperties().getPassword());
    }

    private LiquibaseProperties liquibaseProperties(){
        LiquibaseProperties properties = new LiquibaseProperties();
        properties.setChangeLog("classpath:/liquibase/changelog/changelog-master.xml");
        properties.setUrl("jdbc:neo4j:bolt://localhost:7687");
        properties.setUser("neo4j");
        properties.setPassword("zqYQiKqAQ8JzVdJ");
        return properties;
    }
}
