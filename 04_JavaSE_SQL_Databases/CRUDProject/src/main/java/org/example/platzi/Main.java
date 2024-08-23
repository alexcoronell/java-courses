package org.example.platzi;

import org.example.platzi.model.Employee;
import org.example.platzi.repository.EmployeeRepository;
import org.example.platzi.repository.Repository;
import org.example.platzi.util.DatabaseConnection;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

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
}