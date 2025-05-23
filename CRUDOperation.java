import java.sql.*;

public class CRUDOperation{
    public static void main(String[] args) {
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rsdb","root","sanju@mysql000");
           Statement stmt = con.createStatement();
           String insQ = "Insert into employees values(99,'john',50000)";
           int insresult = stmt.executeUpdate(insQ);
           System.out.println("insert operation"+insresult+"row updated");

           stmt.close();
           con.close();
        } catch (Exception e) {
        }
    }
}
