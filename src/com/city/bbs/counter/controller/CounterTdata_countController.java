package com.city.bbs.counter.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.bbs.counter.model.CounterModel;
import com.city.bbs.counter.service.impl.CounterServiceImpl;
import com.city.bbs.module.factory.ServiceFactory;
import com.city.bbs.module.service.impl.ModuleServiceImpl;
import com.city.bbs.note.service.impl.NoteServiceImpl;
import com.city.bbs.users.service.impl.UsersServiceImpl;

/**
 * Servlet implementation class CounterTdata_countController
 */
@WebServlet("/counter/todata_count.do")
public class CounterTdata_countController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounterTdata_countController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*这样对于morris-data.jsp，所有数据都可见了*/
		HttpSession session =request.getSession();
		CounterServiceImpl c_ser=(CounterServiceImpl) com.city.bbs.counter.factory.ServiceFactory.createCounterService();
		CounterModel o=c_ser.retTimes();	
		session.setAttribute("counter", o);
		
		
		ModuleServiceImpl m_ser=(ModuleServiceImpl) ServiceFactory.createModuleService();
		NoteServiceImpl n_ser=(NoteServiceImpl) com.city.bbs.note.factory.ServiceFactory.createNoteService();
		UsersServiceImpl u_ser=(UsersServiceImpl) com.city.bbs.users.factory.ServiceFactory.createUserService();
	
		session.setAttribute("moduleNum", m_ser.theNumOfModule());
		session.setAttribute("noteNum", n_ser.numOfNotes());
		session.setAttribute("userNum", u_ser.numOfUser());
	
		RequestDispatcher view =request.getRequestDispatcher("../counter/data_count.jsp");
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
