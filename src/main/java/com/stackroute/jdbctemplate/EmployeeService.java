package com.stackroute.jdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class EmployeeService {
  // Declaration
  private JdbcTemplate jdbcTemplate;
  private DataSource dataSource;

  /*public void createTable()
  {
      String query="create table Employee(Id int,Name varchar(20),age int,gender char)";
      jdbcTemplate.update(query);
  }
  */
  public void insertData()
  {
      String query="insert into Employee values(7,'Divya',24,'F')";
      jdbcTemplate.execute(query);


  }

  public List<Employee> getAllEmployeesRowMapper(){
    return jdbcTemplate.query("select * from Employee",new RowMapper<Employee>(){
      @Override
      public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {
        Employee e=new Employee();
        e.setId(rs.getInt(1));
        e.setName(rs.getString(2));
        e.setAge(rs.getInt(3));
        e.setGender(rs.getString(4));
        return e;
      }
    });
  }

  public void updateDetails()
  {
    String query="update Employee set name='Cherry' where Id=2";
    jdbcTemplate.execute(query);
  }

  public void deleteDetails()
  {
    String query="delete from Employee where Id=2";
    jdbcTemplate.update(query);
  }

  public JdbcTemplate getJdbcTemplate() {
    return jdbcTemplate;
  }

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public DataSource getDataSource() {
    return dataSource;
  }
  @Autowired
  public void setDataSource(DataSource dataSource) {
    jdbcTemplate=new JdbcTemplate(dataSource);
  }
}
