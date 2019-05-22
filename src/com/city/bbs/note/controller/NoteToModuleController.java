package com.city.bbs.note.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.bbs.module.model.ModuleModel;
import com.city.bbs.module.service.impl.ModuleServiceImpl;
import com.city.bbs.note.factory.ServiceFactory;
import com.city.bbs.note.model.NoteModel;
import com.city.bbs.note.service.impl.NoteServiceImpl;

/**
 * Servlet implementation class NoteToModuleController
 */
@WebServlet("/module/tomodule.do")
public class NoteToModuleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoteToModuleController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoteServiceImpl n_ser=(NoteServiceImpl) ServiceFactory.createNoteService();
		ModuleServiceImpl m_ser=(ModuleServiceImpl) com.city.bbs.module.factory.ServiceFactory.createModuleService();
		HttpSession session =request.getSession();
		
		String id= request.getParameter("id");
		if(id==null) {
			id=(String) session.getAttribute("chose_id");
		}
		List<NoteModel> v=n_ser.allOfNotes(Integer.parseInt(id));
		ModuleModel o=m_ser.idOfModule(Integer.parseInt(id));
		
		
		
		session.setAttribute("notes", v);
		session.setAttribute("faMod", o);
		session.setAttribute("chose_id", id);
		
		RequestDispatcher view=request.getRequestDispatcher("module.jsp");
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
