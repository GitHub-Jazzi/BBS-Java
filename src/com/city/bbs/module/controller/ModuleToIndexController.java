package com.city.bbs.module.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.city.bbs.module.factory.ServiceFactory;
import com.city.bbs.module.model.ModuleModel;
import com.city.bbs.module.service.impl.ModuleServiceImpl;

/**
 * Servlet implementation class ModuleToIndexController
 */
@WebServlet("/include/toindex.do")
public class ModuleToIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModuleToIndexController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModuleServiceImpl m_ser=(ModuleServiceImpl) ServiceFactory.createModuleService();
		List<ModuleModel> v=m_ser.allOfModule();
		
		HttpSession session =request.getSession();
		session.setAttribute("module", v);
		
		
		RequestDispatcher view =request.getRequestDispatcher("index.jsp");
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
