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
import com.city.bbs.note.service.impl.NoteServiceImpl;

/**
 * Servlet implementation class NoteAddnodulenoteController
 */
@WebServlet("/note/addmodulenote.do")
public class NoteAddnodulenoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoteAddnodulenoteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoteServiceImpl n_ser=(NoteServiceImpl) ServiceFactory.createNoteService();
		HttpSession session =request.getSession();
		
		String title=request.getParameter("title");
		String cont=request.getParameter("cont");
		String user_name=(String) session.getAttribute("user");
		Timestamp time = new Timestamp(new Date().getTime());
		
		//System.out.println(title+cont+user_name+time);
		String smodule_id=(String)session.getAttribute("chose_id");
		String scolourid=request.getParameter("colour");
		
		int module_id=Integer.parseInt(smodule_id);
		int colourid=Integer.parseInt(scolourid);
		
		String colour=null;
		
		if(colourid==1){
		    colour="yellow";
		}else if (colourid==2){
		    colour="green";
		}else if (colourid==3){
		    colour="primary";
		}else if (colourid==4){
		    colour="red";
		}
		
		n_ser.addModuleNote(module_id, title, cont, time, user_name, colour);
		//System.out.println(module_id+title+cont+user_name+time);
		
		RequestDispatcher view=request.getRequestDispatcher("../module/tomodule.do");
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
