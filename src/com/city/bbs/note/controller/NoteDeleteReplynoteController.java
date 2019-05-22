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

import com.city.bbs.counter.factory.ServiceFactory;
import com.city.bbs.note.model.NoteModel;
import com.city.bbs.note.service.impl.NoteServiceImpl;

/**
 * Servlet implementation class NoteDeleteReplynoteController
 */
@WebServlet("/note/deletereplynote.do")
public class NoteDeleteReplynoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoteDeleteReplynoteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		String faModname=session.getAttribute("faModname").toString();
		String user=session.getAttribute("user").toString();
		
		String sdelreply=request.getParameter("delreply");
		int delreply=Integer.parseInt(sdelreply);
		
		String sid=session.getAttribute("up_id").toString();
		int id=Integer.parseInt(sid);
		
		if(faModname.equals(user)) {
			NoteServiceImpl n_ser=(NoteServiceImpl) com.city.bbs.note.factory.ServiceFactory.createNoteService();
			n_ser.deleteFromId(delreply);
			
			List<NoteModel> reply=n_ser.allOfReply(id);
			session.setAttribute("reply", reply);
			
			RequestDispatcher view =request.getRequestDispatcher("../note/replynote.jsp");
			view.forward(request, response);
		}else {
			RequestDispatcher view =request.getRequestDispatcher("../note/deletereplyfiled.jsp");
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
