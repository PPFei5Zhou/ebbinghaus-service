package com.easy.ebbinghausservice.core;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import javax.sql.DataSource;

public class DatabaseTestConfiguration {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public MySQLContainer<?> mySqlContainer() {
        return new MySQLContainer<>("mysql:8.0.28-debian").waitingFor(Wait.forListeningPort());
    }

    @Bean
    @FlywayDataSource
    public DataSource dataSource(MySQLContainer<?> mySqlContainer) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(mySqlContainer.getJdbcUrl());
        hikariConfig.setUsername(mySqlContainer.getUsername());
        hikariConfig.setPassword(mySqlContainer.getPassword());
        return new HikariDataSource(hikariConfig);
    }
}
