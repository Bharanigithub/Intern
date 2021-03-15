package day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCProgram4 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey", "root", "1234");
		String query = "select * from users where uname=?";
		PreparedStatement st = con.prepareStatement(query);
		Scanner s = new Scanner(System.in);
		String str;
		for (int j = 1; j <= 3; j++) {
			System.out.println("Enter the name to search:");
			str = s.next();
			st.setString(1, str);
			ResultSet rs = st.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(rsmd.getColumnName(i) + "\t");
			}
			System.out.println();
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString("upass") + "\t");
				System.out.print(rs.getInt("flag") + "\n");
			}
		}
	}
}
