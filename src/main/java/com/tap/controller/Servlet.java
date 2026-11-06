package com.tap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/callServlet")
public class Servlet extends HttpServlet {
	static int count=3;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		resp.setContentType("text/html");
		if(username.equals("Manasa") && password.equals("12345")) {
			PrintWriter out=resp.getWriter();
			out.print("Welcome"+username);
			
		}
		else if(count>0) {
			
			PrintWriter out=resp.getWriter();
			count--;
			out.println("Invalid Credentials \n Try again" + count +" more chances");
			 RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req,resp);
		}
		else {
			PrintWriter out=resp.getWriter();
			
			out.println("Blocked");
			
			
		}
	}
	

}
