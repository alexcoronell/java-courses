import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null; // Select
        PreparedStatement preparedStatement = null; // Create
        ResultSet resultSet = null;

        var database = "java_sql_database";
        var url = "jdbc:mysql://localhost:3306/" + database;
        var user = "root";
        var password = "root";

        String sql;

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection completed");

            // SELECT
//            statement = connection.createStatement();
//            sql = "SELECT * FROM employees";
//            resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("first_name"));
//            }

            // CREATE
//            sql = "INSERT INTO employees (first_name, pa_surname) VALUES (?, ?)";
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, "John");
//            preparedStatement.setString(2, "Johns");
//            int rowsAffected = preparedStatement.executeUpdate();
//            if (rowsAffected > 0){
//                System.out.println("Employee created");
//            }

            // UPDATE
//            statement = connection.createStatement();
//            sql = "UPDATE employees SET email='johnjohns@example.com' WHERE id = 12";
//            int rowsAffected = statement.executeUpdate(sql);
//            sql = "SELECT * FROM employees ORDER BY pa_surname";
//            resultSet = statement.executeQuery(sql);
//            if (rowsAffected > 0){
//                System.out.println("Employee Updated");
//                while (resultSet.next()){
//                    System.out.println(resultSet.getString("first_name") + ", " + resultSet.getString("pa_surname") + ", " + resultSet.getString("email"));
//                }
//            }

            // DELETE
            statement = connection.createStatement();
            sql = "DELETE FROM employees WHERE id=12";
            int rowsAffected = statement.executeUpdate(sql);
            if(rowsAffected > 0) {
                System.out.println("Emmployee deleted");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("There is something bad, connection NOT completed");
        }
    }
}