package com.city.bbs.note.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.bbs.note.factory.ServiceFactory;

/**
 * Servlet implementation class NoteAddnoteController
 */
@WebServlet("/note/addnote.do")
public class NoteAddnoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoteAddnoteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		
		String title=request.getParameter("title");
		String cont=request.getParameter("text");
		
		String user_name=(String) session.getAttribute("user");
		String sup_id=session.getAttribute("up_id").toString();
		int up_id=Integer.parseInt(sup_id);
		Timestamp time = new Timestamp(new Date().getTime());
		
		ServiceFactory.createNoteService().addReplyNote(up_id, title, cont, time, user_name);
		
		RequestDispatcher view=request.getRequestDispatcher("../note/toreplynote.do");
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
