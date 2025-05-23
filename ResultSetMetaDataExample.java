import java.sql.*;
public class ResultSetMetaDataExample {
public static void main(String[] args) {
String url = "jdbc:mysql://localhost:3306/rsdb";
String user = "root";
String password = "sanju@mysql000";
try (Connection conn = DriverManager.getConnection(url, user, password);
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT emp_id, name, salary FROM employees")) {
ResultSetMetaData metaData = rs.getMetaData();
int columnCount = metaData.getColumnCount();
System.out.println("Total Columns: " + columnCount);
for (int i = 1; i <= columnCount; i++) {
System.out.println("Column " + i + ": " + metaData.getColumnName(i) +

" (" + metaData.getColumnTypeName(i) + ")");
}
} catch (SQLException e) {
e.printStackTrace();
}
}
}