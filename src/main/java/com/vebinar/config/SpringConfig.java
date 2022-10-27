package com.vebinar.config;

import com.vebinar.dao.UserDao;
import com.vebinar.dao.UserDaoImpl;
import com.vebinar.service.UserService;
import com.vebinar.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.vebinar.service", "com.vebinar.dao"})
public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDateSource());
    }

    @Bean
    public DataSource getDateSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("password");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }
}
