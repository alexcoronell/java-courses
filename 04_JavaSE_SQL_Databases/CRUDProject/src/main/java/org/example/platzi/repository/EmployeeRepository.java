package org.example.platzi.repository;

import org.example.platzi.model.Employee;
import org.example.platzi.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements Repository<Employee> {

    private Connection connection;

    public EmployeeRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employees";
        List<Employee> employees = new ArrayList<>();
        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {

            while (resultSet.next()) {
                Employee employee = createEmployee(resultSet);
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
        e.setCurp(resultSet.getString("curp"));
        return e;
    }

    @Override
    public Employee getById(Integer id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        Employee employee = null;
        try(
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
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
        String sql;
        if(employee.getId() != 0 && employee.getId() > 0) {
            sql = "UPDATE employees SET first_name = ?, pa_surname = ?, ma_surname = ?, email = ?, salary = ?, curp = ? WHERE id = ?";
        } else {
            sql = "INSERT INTO employees (first_name, pa_surname, ma_surname, email, salary, curp) VALUES (?,?,?,?,?,?)";
        }
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, employee.getFirst_name());
            preparedStatement.setString(2, employee.getPa_surname());
            preparedStatement.setString(3, employee.getMa_surname());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setFloat(5, employee.getSalary());
            preparedStatement.setString(6, employee.getCurp());
            if(employee.getId() != 0 && employee.getId() > 0) {
                preparedStatement.setInt(8, employee.getId());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("There is something bad, query save NOT completed");
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("There is something bad, query delete NOT completed");
        }
    }
}
