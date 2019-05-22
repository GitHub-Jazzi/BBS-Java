package com.city.bbs.counter.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.bbs.counter.factory.ServiceFactory;
import com.city.bbs.counter.model.CounterModel;
import com.city.bbs.counter.service.impl.CounterServiceImpl;

/**
 * Servlet implementation class CounterTodata_counterController
 */
@WebServlet("/counter/todata_counter.do")
public class CounterTodata_counterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounterTodata_counterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		CounterServiceImpl c_ser=(CounterServiceImpl) ServiceFactory.createCounterService();
		CounterModel o=c_ser.retTimes();
		
		session.setAttribute("counter", o);
		
		/*让这些值初始化，查询morris-data.php中取数报错导致以下代码也无法正确执行*/
		session.setAttribute("moduleNum", 0);
		session.setAttribute("noteNum", 0);
		session.setAttribute("userNum", 0);
		RequestDispatcher view =request.getRequestDispatcher("../counter/data_counter.jsp");
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
