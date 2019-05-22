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
import com.city.bbs.users.service.impl.UsersServiceImpl;

/**
 * Servlet implementation class UsersLoginController
 */
@WebServlet({ "/include/login.do" })
public class UsersLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ûỰ
		HttpSession session=request.getSession();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		UsersServiceImpl u_ser=(UsersServiceImpl) ServiceFactory.createUserService();
		
		if(u_ser.UserIsExist(email)==1) {
			
			/*���Ҹ��û��������Ӧ���ݿ�����*/
			if(u_ser.PassIsTrue(email, password)==1) {
				session.setAttribute("user", email);
				
				/*��������ͼƬ*/
				u_ser.loadAllPic();
				session.setAttribute("manageIsno", 2);
				
				RequestDispatcher view=request.getRequestDispatcher("toindex.do");
				view.forward(request, response);
			}else {
				session.setAttribute("userIsno", 2);
				
				RequestDispatcher view=request.getRequestDispatcher("login.jsp");
				view.forward(request, response);
			}
		}else {
			//System.out.println("haha");
			//����1�������ڸ��û�
			session.setAttribute("userIsno", 1);
			
			RequestDispatcher view=request.getRequestDispatcher("login.jsp");
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
