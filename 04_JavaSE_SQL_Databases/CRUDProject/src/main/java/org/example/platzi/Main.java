package org.example.platzi;

import org.example.platzi.model.Employee;
import org.example.platzi.repository.EmployeeRepository;
import org.example.platzi.repository.Repository;
import org.example.platzi.util.DatabaseConnection;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("----------- INSERT an employee -----------");
        Employee employee;
        employee = new Employee();
        employee.setFirst_name("John");
        employee.setPa_surname("Doe");
        employee.setMa_surname("");
        employee.setEmail("jdoe@email.com");
        employee.setSalary(5566.65F);
        save(employee);
    }

    public static void getAll(){
        String sql = "SELECT * FROM employees";
        try (
                Connection connection = DatabaseConnection.getInstance();
        ) {
            Repository<Employee> repository = new EmployeeRepository();
            repository.findAll().forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("There is something bad, connection NOT completed");
        }
    }

    public static void getById(int id){
        try (Connection connection = DatabaseConnection.getInstance()) {
            Repository<Employee> repository = new EmployeeRepository();
            Employee employee = repository.getById(id);
            System.out.println(employee);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("There is something bad, connection NOT completed");
        }
    }

    public  static void  save(Employee employee){
        try (Connection connection = DatabaseConnection.getInstance()){
            Repository<Employee> repository = new EmployeeRepository();
            repository.save(employee);
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("There is something bad, connection NOT completed");
        }
    }
}