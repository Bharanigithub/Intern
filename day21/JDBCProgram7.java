package day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCProgram7 {
	public static void main(String str[]) throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "1234");
			Statement st = con.createStatement();
			st.execute("insert into users values('5','Vinoth','password',1)");
			st.execute("delete from users where uid=5");
			st.close();
			con.close();
			System.out.println(" success..... ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
