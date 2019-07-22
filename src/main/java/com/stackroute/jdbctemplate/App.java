package com.stackroute.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main(String args[])
    {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(ConfigurationBean.class);
        EmployeeService EmployeeService=applicationContext.getBean("EmployeeService", EmployeeService.class);
        Employee Employee=new Employee();
        // EmployeeService.createTable();
      List<Employee> employeeList=  EmployeeService.getAllEmployeesRowMapper();
        for (Employee e:employeeList
             ) {
            System.out.println(e.getId()+","+e.getName()+","+e.getAge()+","+e.getGender());
        }
        EmployeeService.insertData();
        EmployeeService.updateDetails();
        EmployeeService.deleteDetails();

    }
}
