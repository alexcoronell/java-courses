package org.example.platzi.repository;

import org.example.platzi.model.Employee;
import org.example.platzi.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements Repository<Employee> {

    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getInstance();
    }

    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employees";
        List<Employee> employees = new ArrayList<>();
        try (
                Statement statement = getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {

            while (resultSet.next()) {
                Employee employee = createEmployee(resultSet)
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("There is something bad, query findAll NOT completed");
        }
        return employees;
    }

    private static Employee createEmployee(ResultSet resultSet) throws SQLException {
        Employee e = new Employee();
        e.setId(resultSet.getInt("id"));
        e.setFirst_name(resultSet.getString("first_name"));
        e.setPa_surname(resultSet.getString("pa_surname"));
        e.setMa_surname(resultSet.getString("ma_surname"));
        e.setEmail(resultSet.getString("email"));
        e.setSalary(resultSet.getFloat("salary"));
        return e;
    }

    @Override
    public Employee getById(Integer id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        Employee employee = null;
        try(
                PreparedStatement preparedStatement = getConnection().prepareStatement(sql)
                ) {
            preparedStatement.setInt(1,id);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()) {
                    employee = createEmployee(resultSet);
                }
            } catch (SQLException e){
                e.printStackTrace();
                throw new RuntimeException("There is something bad, query getById NOT completed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("There is something bad, query getById NOT completed");
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public void delete(Integer id) {

    }
}
