package day21;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class JDBCProgram5 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "1234");
		CallableStatement st=con.prepareCall("{call proc2(?,?)}");
		int uid=3;
		st.setInt(1, uid);
		st.registerOutParameter(2, Types.VARCHAR);
		st.execute();
		System.out.println(st.getString(2));
	}
}
