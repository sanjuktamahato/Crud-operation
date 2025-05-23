import java.sql.*;
public class SQLExceptionError {
public static void main(String[] args) {
String url = "jdbc:mysql://localhost:3306/rsdb";
String user = "root";
String password = "sanju@mysql00";
try (Connection conn = DriverManager.getConnection(url, user, password);
Statement stmt = conn.createStatement()) {
String sql = "SELECT * FROM employees"; 
ResultSet rs = stmt.executeQuery(sql);
} catch (SQLException e) {
System.out.println("Error: " + e.getMessage());
System.out.println("SQL State: " + e.getSQLState());
System.out.println("Error Code: " + e.getErrorCode());
e.printStackTrace(); 
}
}
}
