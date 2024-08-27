package org.example.platzi;

import org.example.platzi.model.Employee;
import org.example.platzi.repository.EmployeeRepository;
import org.example.platzi.repository.Repository;
import org.example.platzi.util.DatabaseConnection;
//import org.example.platzi.view.SwingApp;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
//        System.out.println("----------- DELETING an employee -----------");
//        Employee employee;
//        employee = new Employee();
//        employee.setId(13);
//        employee.setFirst_name("John");
//        employee.setPa_surname("Doe");
//        employee.setMa_surname("Edited");
//        employee.setEmail("jdoe@email.com");
//        employee.setSalary(5566.65F);
//        save(employee);
//        int employeeToDelete = 13;
//        delete(employeeToDelete);
//        SwingApp app = new SwingApp();
//        app.setVisible(true);
//        try(Connection connection = DatabaseConnection.getInstance()){
//            if(connection.getAutoCommit()){
//                connection.setAutoCommit(false);
//            }
//
//            try{
//                Repository<Employee> repository = new EmployeeRepository(connection);
//                Employee employee;
//                employee = new Employee();
//                //employee.setId(13);
//                employee.setFirst_name("John");
//                employee.setPa_surname("Doe");
//                employee.setMa_surname("Edited");
//                employee.setEmail("jdoe@email.com");
//                employee.setSalary(5566.65F);
//                employee.setCurp("ABCDEFGH123456789");
//                repository.save(employee);
//                connection.commit();
//            } catch (SQLException e){
//                connection.rollback();
//                e.printStackTrace();
//
//            }
//        }


        System.out.println("Showing employees");
        Repository<Employee> repository = new EmployeeRepository();
        repository.findAll().forEach(System.out::println);

        System.out.println("------ Loading by ID ------");
        System.out.println(repository.getById(2));
        System.out.println(repository.getById(3));
        System.out.println(repository.getById(4));

    }

    /*
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
        System.out.println(employee.toString());
        try (Connection connection = DatabaseConnection.getInstance()){
            Repository<Employee> repository = new EmployeeRepository();
            repository.save(employee);
            System.out.println("Employee saved");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("There is something bad, connection NOT completed");
        }
    }

    public static void delete(int id){
        try (Connection connection = DatabaseConnection.getInstance()) {
            Repository<Employee> repository = new EmployeeRepository();
            repository.delete(id);
            System.out.println("Employee deleted");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("There is something bad, connection NOT completed");
        }
    }*/
}