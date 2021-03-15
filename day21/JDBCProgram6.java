package day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;

public class JDBCProgram6 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/ey","root","1234");
		System.out.println(con);
		con.setAutoCommit(false);
		Statement st=con.createStatement();
		String query1="update users set flag=1 where uid=1";
		String query2="update users set flag=1 where uiid=1";
		Savepoint sp1=null;
		try {
			st.executeUpdate(query1);
			sp1=con.setSavepoint("savepoint1");
			st.executeUpdate(query2);
			//con.commit();
		}
		catch(Exception e) {
			System.out.println("Exception Caught!!");
			con.rollback(sp1);
			con.commit();
		}
	}
}
