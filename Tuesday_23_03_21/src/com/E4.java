package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class E4 extends HttpServlet {

	Connection con;
	PreparedStatement st;

	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/serv","root","1234");
			st = con.prepareStatement("Insert into emp values(?,?)");
		} catch (Exception e) {
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String s1 = req.getParameter("name");
		String s2 = req.getParameter("age");
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<h1> Inserting Record:  </h1>");
		int x = Integer.parseInt(s2);
		try {
			st.setString(1, s1);
			st.setInt(2, x);
			st.executeUpdate();
		} catch (Exception e) {
		}
		pw.println("<h2>   BYE!!!  </h2>");
	}
}
