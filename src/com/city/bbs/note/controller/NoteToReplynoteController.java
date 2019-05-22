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
 * Servlet implementation class NoteToReplynoteController
 */
@WebServlet("/note/toreplynote.do")
public class NoteToReplynoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoteToReplynoteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		
		String sid =request.getParameter("id");
		if(sid==null) {
			sid=session.getAttribute("up_id").toString();
		}
		int id=Integer.parseInt(sid);
		
		NoteServiceImpl n_ser=(NoteServiceImpl) ServiceFactory.createNoteService();
		List<NoteModel> reply=n_ser.allOfReply(id);
		NoteModel choseNote =n_ser.oneOfNote(id);
		
		
		session.setAttribute("up_id", id);
		session.setAttribute("reply", reply);
		session.setAttribute("choseNote", choseNote);
		
		RequestDispatcher view =request.getRequestDispatcher("../note/replynote.jsp");
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
