package day21;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;


public class JDBCProgram1 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/ey","root","1234");
		System.out.println(con);
		DatabaseMetaData dbmt=con.getMetaData();
		System.out.println(dbmt.getDatabaseProductName());
		System.out.println(dbmt.getDriverName());
		System.out.println(dbmt.getURL());
	}
}
