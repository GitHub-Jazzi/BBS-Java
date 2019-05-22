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

import com.city.bbs.note.factory.ServiceFactory;
import com.city.bbs.note.model.NoteModel;
import com.city.bbs.note.service.impl.NoteServiceImpl;

/**
 * 这个top_left已经隶属与index，其路径为index路径
 */
@WebServlet("/include/top_left.do")
public class Notetop_leftController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Notetop_leftController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoteServiceImpl n_ser=(NoteServiceImpl) ServiceFactory.createNoteService();
		List<NoteModel> title_notes=n_ser.AllOfTitle(request.getParameter("find"));
		
		HttpSession session =request.getSession();
		session.setAttribute("title_notes", title_notes);
		
		RequestDispatcher view=request.getRequestDispatcher("toindex.do");
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
