package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
	Connection con;
	PreparedStatement st;

	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/serv","root","1234");
			st = con.prepareStatement("Insert into user values(?,?,?,?)");
		} catch (Exception e) {
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String s1 = req.getParameter("name");
		String s2 = req.getParameter("username");
		String s3 = req.getParameter("password");
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		try {
			st.setString(1, s1);
			st.setString(2, s2);
			st.setString(3, s3);
			st.setInt(4, 0);
			st.executeUpdate();
		} catch (Exception e) {
		}
		pw.println("<h2>Registered Successfully!!!</h2>");
//		RequestDispatcher rd3=req.getRequestDispatcher("LoginUser.html");
//		rd3.forward(req, res);
		//req.getRequestDispatcher("LoginUser.html").include(req,res);
		res.sendRedirect("LoginUser.html");
	}
}
