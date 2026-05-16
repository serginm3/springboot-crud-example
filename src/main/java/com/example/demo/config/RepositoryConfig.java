package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class RepositoryConfig {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource repositoryManager = new DriverManagerDataSource();
        repositoryManager.setDriverClassName("org.sqlite.JDBC");
        repositoryManager.setUrl("jdbc:sqlite:springDemo.db");
        return repositoryManager;
    }
}
