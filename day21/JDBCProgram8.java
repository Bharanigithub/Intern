package day21;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class JDBCProgram8 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "1234");
		CallableStatement st=con.prepareCall("{call simpleproc(?)}");
		st.registerOutParameter(1, Types.INTEGER);
		int k=st.getInt(1);
		System.out.println(k);
	}
}
