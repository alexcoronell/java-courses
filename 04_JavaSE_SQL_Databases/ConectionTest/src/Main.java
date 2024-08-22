import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql//localhost/project", "root", "root");
            System.out.println("Connection completed");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("There is something bad, connection NOT completed");
        }
    }
}