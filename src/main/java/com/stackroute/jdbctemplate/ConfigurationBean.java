package com.stackroute.jdbctemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.stackroute.jdbctemplate")
public class ConfigurationBean
{
  // Creating object for DriverManager and registering
  @Bean(name="dataSource")
  public DataSource dataSource()
  {
    DriverManagerDataSource dataSource=new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/Demo");
    dataSource.setUsername("root");
    dataSource.setPassword("Root@123");
    return dataSource;
  }

  // EmployeeService class object creation
  @Bean(name="EmployeeService")
  public EmployeeService EmployeeDAO()
  {
    return new EmployeeService();
  }
}
