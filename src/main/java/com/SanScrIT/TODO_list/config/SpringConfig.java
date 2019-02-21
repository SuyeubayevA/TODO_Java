package com.SanScrIT.TODO_list.config;

import java.sql.Connection;
import com.SanScrIT.TODO_list.dao.TaskDao;
import com.SanScrIT.TODO_list.dao.TaskDaoImpl;
import com.SanScrIT.TODO_list.service.TaskService;
import com.SanScrIT.TODO_list.service.TaskServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/TODO_list_aidar?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUsername("Aidar");
        dataSource.setPassword("friday");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public TaskDao getTaskDao(){
        return new TaskDaoImpl(getJdbcTemplate());
    }

    @Primary
    @Bean
    public TaskService getTaskService(){
        return new TaskServiceImpl();
    }
}
