package com.city.bbs.module.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.bbs.module.factory.ServiceFactory;

/**
 * Servlet implementation class ModuleAddmoduleController
 */
@WebServlet("/module/addmodule.do")
public class ModuleAddmoduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModuleAddmoduleController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		String text=request.getParameter("text");
		String mail=request.getParameter("mail");
		
		String colour=request.getParameter("colour");
		String pic=request.getParameter("pic");
		
		System.out.println(title+text+mail+colour+pic);
		int c=Integer.parseInt(colour);
		
		if(c==1){
		    colour="yellow";
		}else if (c==2){
		    colour="green";
		}else if (c==3){
		    colour="primary";
		}else if (c==4){
		    colour="red";
		}
		

		if(pic.equals("1")){
		    pic="space-shuttle";
		}else if (pic.equals("4")){
		    pic="mortar-board";
		}else if (pic.equals("3")){
		    pic="trophy";
		}else if (pic.equals("2")){
		    pic="heart-o";
		}

		ServiceFactory.createModuleService().add(title, text, mail, pic, colour);
		RequestDispatcher view =request.getRequestDispatcher("../include/toindex.do");
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
