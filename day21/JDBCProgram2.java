package day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCProgram2 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/ey","root","1234");
		Statement st=con.createStatement();
		String query="insert into users values(3,'Vikram','mypass',1)";
		//int count=st.executeUpdate(query);
		//System.out.println("No. of Entries inserted:"+count);
		query="select * from users";
		boolean b=st.execute(query);
		System.out.println("Result Set Returned:"+b);
	}
}
