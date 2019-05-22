package com.city.bbs.users.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.bbs.users.factory.ServiceFactory;

/**
 * Servlet implementation class UserschangemmController
 */
@WebServlet("/users/changemm.do")
public class UserschangemmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserschangemmController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				//获得会话
				HttpSession session=request.getSession();
				
				String mail=(String) session.getAttribute("user");
				String password=request.getParameter("mm");
				ServiceFactory.createUserService().update(mail, password);
				
				RequestDispatcher view=request.getRequestDispatcher("../include/login.jsp");
				view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
