package com.city.bbs.manage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.bbs.manage.factory.ServiceFactory;
import com.city.bbs.manage.service.impl.ManageServiceImpl;
import com.city.bbs.module.model.ModuleModel;
import com.city.bbs.users.model.UsersModel;
import com.city.bbs.users.service.impl.UsersServiceImpl;

/**
 * Servlet implementation class ManageManageloginController
 */
@WebServlet("/manage/managelogin.do")
public class ManageManageloginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageManageloginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManageServiceImpl m_ser=(ManageServiceImpl) ServiceFactory.createManageService();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		HttpSession session =request.getSession();
		
		
		if(m_ser.PassIsTrue(email, password)==1) {
			UsersServiceImpl u_ser=(UsersServiceImpl) com.city.bbs.users.factory.ServiceFactory.createUserService();
			List<UsersModel> users=u_ser.AllOfUser();
			session.setAttribute("users", users);
			session.setAttribute("manage", email);
			session.setAttribute("manageIsno2", 2);
			RequestDispatcher view =request.getRequestDispatcher("../module/addmodule.jsp");
			view.forward(request, response);
		
		}else {
			session.setAttribute("manageIsno2", 1);
			RequestDispatcher view =request.getRequestDispatcher("../manage/managelogin.jsp");
			view.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
