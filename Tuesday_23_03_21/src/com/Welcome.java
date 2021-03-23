package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Welcome extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		PrintWriter pw = response.getWriter();
		Object obj=session.getAttribute("name");
		String str=obj.toString();
		pw.println("<H1>HELLO "+str+"<H1>");
		session.removeAttribute("name");
		session.invalidate();
		pw.println("<form action=\"http://localhost:2030/eyweb/LoginUser.html\" method=\"post\">\r\n"
				+ "Click here to Log Out..<input type=\"Submit\" value=\"Click Here\">\r\n"
				+ "</form>");
	}

}
