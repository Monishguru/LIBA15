package com.hostelmanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hostelmanagement.model.AdminUserInformation;
import com.hostelmanagement.service.AddAdminService;


public class AddAdmin extends HttpServlet {
	
	
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("psw");
		
		AdminUserInformation adminUserInformation=new AdminUserInformation();
		adminUserInformation.setUserEmail(email);
		adminUserInformation.setPassword(password);
		
		AddAdminService addAdmin=new AddAdminService();
		addAdmin.validateLogin(adminUserInformation);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Invoked the Servlet");
		String authToken=request.getParameter("authtoken");
		String password=request.getParameter("psw");
		String email=request.getParameter("email");
		
		AdminUserInformation adminUserInformation=new AdminUserInformation();
		adminUserInformation.setUserEmail(email);
		adminUserInformation.setAuthToken(authToken);
		adminUserInformation.setPassword(password);
		
		AddAdminService addAdmin=new AddAdminService();
		int addminAddedValue=addAdmin.addAdminToDatbase(adminUserInformation);
		
		if(addminAddedValue>0) {
			System.out.println("Admin added Successfully");
			response.sendRedirect("adminlogin.jsp");
		}
		else {
			System.out.println("Admin Adding Failed");
			request.setAttribute("adminaddingresult", "Admin registration failed message");
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}
		
		System.out.println("Processing Request with Following details "+"Email:"+email+": Authtoken" +authToken);
		
	}

}
