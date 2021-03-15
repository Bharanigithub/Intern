package day21;
import java.util.*;
import java.sql.*;

class JDBCProgram9 {
	public static void main(String st1[]) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "1234");
		Enumeration e = DriverManager.getDrivers();
		System.out.println(" " + DriverManager.getLoginTimeout());
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
	}
}