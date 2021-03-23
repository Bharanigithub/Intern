package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	Connection con;
	PreparedStatement st1;
	PreparedStatement st2;
	PreparedStatement st3;
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/serv","root","1234");
			st1 = con.prepareStatement("select username from user where username=?");
			st2 = con.prepareStatement("select username,password,flag from user where username=? and password=?");
			st3 = con.prepareStatement("update user set flag=? where username=?");
		} catch (Exception e) {
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String s1 = req.getParameter("username");
		String s2 = req.getParameter("password");
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
	
		String username="",password="",username1="";
		int fl=0;
		try {
			st1.setString(1, s1);
			st2.setString(1, s1);
			st2.setString(2, s2);
			ResultSet rs=st1.executeQuery();
			while(rs.next()) {
				username1=rs.getString("username");
			}
			rs.close();
			ResultSet rs1=st2.executeQuery();
			while(rs1.next()) {
				username=rs1.getString("username");
				password=rs1.getString("password");
				fl=rs1.getInt("flag");
			}
			rs1.close();
			if(username.equals(s1) && password.equals(s2)) {
				if(fl==1) {
					st3.setInt(1,0);
					st3.setString(2, username);
					st3.execute();
					pw.println("<form action=\"http://localhost:2030/eyweb/LoginUser.html\" method=\"post\">\r\n"
							+ "You have Already Logged In.Click Here to LogOut and Log In again..<input type=\"Submit\" value=\"Click Here\">\r\n"
							+ "</form>");
				}
				else {
					HttpSession session=req.getSession();
					session.setAttribute("name", username);
					st3.setInt(1,1);
					st3.setString(2, username);
					st3.execute();
					res.sendRedirect("Welcome.html");
				}
			}
			else if(username1.isEmpty()) {
				res.sendRedirect("RegisterUser.html");
			}
			else {
				
				res.sendRedirect("LoginUser.html");
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
