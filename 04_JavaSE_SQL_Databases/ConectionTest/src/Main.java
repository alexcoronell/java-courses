import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        //Class cl = Class.forName("com.mysql.jdbc.Driver")
        var database = "java_sql_database";
        var url = "jdbc:mysql://localhost:3306/" + database;
        var user = "root";
        var password = "root";

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection completed");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("There is something bad, connection NOT completed");
        }
    }
}