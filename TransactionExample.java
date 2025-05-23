import java.sql.*;
public class TransactionExample {
public static void main(String[] args) {
String url = "jdbc:mysql://localhost:3306/rsdb";
String user = "root";
String password = "sanju@mysql000";
Connection conn = null;
try {
conn = DriverManager.getConnection(url, user, password);
conn.setAutoCommit(false); 
Statement stmt = conn.createStatement();
stmt.executeUpdate("UPDATE employees SET salary = salary - 5000 WHERE emp_id = 101");
stmt.executeUpdate("UPDATE employees SET salary = salary + 5000 WHERE emp_id = 102");
conn.commit();
System.out.println("Transaction Successful!");
} catch (SQLException e) {
try {
if (conn != null) {
conn.rollback(); 
System.out.println("Transaction Rolled Back!");
}
} catch (SQLException rollbackEx) {
rollbackEx.printStackTrace();
}
e.printStackTrace();
} finally {
try {
if (conn != null) conn.close(); 
} catch (SQLException ex) {
ex.printStackTrace();
}
}
}
}
