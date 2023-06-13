package com.sms.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sms.dao.StudentDAO;
import com.sms.dto.StudentDTO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String userName = request.getParameter("uname");
		String password = request.getParameter("password");
		System.out.println("User Name =" + userName);
		System.out.println("password=" + password);

		StudentDTO student = new StudentDTO();
		student.setUserName(userName);
		StudentDTO dto=StudentDAO.loginCheck(student);
		if(dto != null)
		{
			if (userName.equalsIgnoreCase(student.getUserName()) && password.equalsIgnoreCase(student.getPassword())) {
				
				HttpSession session=request.getSession();
				session.setAttribute("list",dto);
				response.sendRedirect("update.jsp");
			} else
				System.out.println("Incorrect username or password");
		}
		else
			System.out.println("Cant retrieve the data from DAO");
}
	}
	
