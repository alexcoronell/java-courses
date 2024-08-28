package org.example.platzi.views;

import org.example.platzi.model.Employee;
import org.example.platzi.repository.EmployeeRepository;
import org.example.platzi.repository.Repository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;
public class SwingApp extends JFrame {

    private final Repository<Employee> employeeRepository;
    private final JTable employeeTable;

    public SwingApp() {

        // Configure Window
        setTitle("Employee management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 230);

        // Create a table to show the employees
        employeeTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        add(scrollPane, BorderLayout.CENTER);

        // Create Action Buttons
        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        // Configure button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set Button Styles
        addButton.setBackground(new Color(46, 204, 113));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        updateButton.setBackground(new Color(52, 152, 219));
        updateButton.setForeground(Color.WHITE);
        updateButton.setFocusPainted(false);
        deleteButton.setBackground(new Color(231, 76, 60));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusPainted(false);

        // CreateRepository object to access database
        employeeRepository = new EmployeeRepository();

        // Load initial employees to table
        refreshEmployeeTable();

        // Add ActionListener to buttons
        addButton.addActionListener(e -> {
            try {
                addEmployee();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        updateButton.addActionListener(e -> updateEmployee());

        deleteButton.addActionListener(e -> deleteEmployee());
    }

    private void refreshEmployeeTable() {
        // Get Updated employees list from database
        List<Employee> employees = employeeRepository.findAll();

        // Create a table model to set employee data
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Paternal surname");
        model.addColumn("Maternal surname");
        model.addColumn("Email");
        model.addColumn("Salary");

        for (Employee employee : employees) {
            Object[] rowData = {
                    employee.getId(),
                    employee.getFirst_name(),
                    employee.getPa_surname(),
                    employee.getMa_surname(),
                    employee.getEmail(),
                    employee.getSalary()
            };
            model.addRow(rowData);
        }

        // Set updated table model
        employeeTable.setModel(model);
    }

    private void addEmployee() throws SQLException {
        // Crear un formulario para agregar un empleado
        JTextField nameField = new JTextField();
        JTextField paSurnameField = new JTextField();
        JTextField maSurnameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField salaryField = new JTextField();

        Object[] fields = {
                "Name:", nameField,
                "Paternal Surname:", paSurnameField,
                "Maternal Surname:", maSurnameField,
                "Email:", emailField,
                "Salary:", salaryField
        };

        int result = JOptionPane.showConfirmDialog(this, fields, "Add Employee", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            // Create a new Employee object with new data
            Employee employee = new Employee();
            employee.setFirst_name(nameField.getText());
            employee.setPa_surname(paSurnameField.getText());
            employee.setMa_surname(maSurnameField.getText());
            employee.setEmail(emailField.getText());
            employee.setSalary(Float.parseFloat(salaryField.getText()));

            // Save the new employee in database
            employeeRepository.save(employee);

            // Update the table with update employees
            refreshEmployeeTable();

            JOptionPane.showMessageDialog(this, "Employee added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void updateEmployee() {
        // Get employee id to update
        String employeeIdStr = JOptionPane.showInputDialog(this, "Write the employee id to update:", "Update Employee", JOptionPane.QUESTION_MESSAGE);
        if (employeeIdStr != null) {
            try {
                int employeeId = Integer.parseInt(employeeIdStr);

                // Get employee from database
                Employee employee = employeeRepository.getById(employeeId);

                if (employee != null) {
                    // Create a form with employee data
                    JTextField nameField = new JTextField(employee.getFirst_name());
                    JTextField paSurnameField = new JTextField(employee.getPa_surname());
                    JTextField maSurnameField = new JTextField(employee.getMa_surname());
                    JTextField emailField = new JTextField(employee.getEmail());
                    JTextField salaryField = new JTextField(String.valueOf(employee.getSalary()));

                    Object[] fields = {
                            "Name:", nameField,
                            "Paternal Surname:", paSurnameField,
                            "Maternal Surname:", maSurnameField,
                            "Email:", emailField,
                            "Salary:", salaryField
                    };

                    int confirmResult = JOptionPane.showConfirmDialog(this, fields, "Update Employee", JOptionPane.OK_CANCEL_OPTION);
                    if (confirmResult == JOptionPane.OK_OPTION) {
                        // Update data from Employee
                        employee.setFirst_name(nameField.getText());
                        employee.setPa_surname(paSurnameField.getText());
                        employee.setMa_surname(maSurnameField.getText());
                        employee.setEmail(emailField.getText());
                        employee.setSalary(Float.parseFloat(salaryField.getText()));

                        // Save changes in database
                        employeeRepository.save(employee);

                        // Update employees table
                        refreshEmployeeTable();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Employee not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Write a valid number ID", "Error", JOptionPane.ERROR_MESSAGE);
            } /*catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error to get employee data from database", "Error", JOptionPane.ERROR_MESSAGE);
            }*/
        }
    }

    private void deleteEmployee() {
        // Get Employee ID
        String employeeIdStr = JOptionPane.showInputDialog(this, "Write the employee id:", "Delete Employee", JOptionPane.QUESTION_MESSAGE);
        if (employeeIdStr != null) {
            try {
                int employeeId = Integer.parseInt(employeeIdStr);

                // Confirm delete action
                int confirmResult = JOptionPane.showConfirmDialog(this, "Are you sure delete the employee?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirmResult == JOptionPane.YES_OPTION) {
                    // Delete employee in database
                    employeeRepository.delete(employeeId);

                    // Refresh employee table
                    refreshEmployeeTable();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Write a valid number ID", "Error", JOptionPane.ERROR_MESSAGE);
            } /*catch (SQLException e) {
                throw new RuntimeException(e);
            }*/
        }
    }
}