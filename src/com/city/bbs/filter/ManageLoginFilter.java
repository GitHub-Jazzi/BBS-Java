package com.city.bbs.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class ManageLoginFilter
 */
@WebFilter("/manage/managelogin.jsp")
public class ManageLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ManageLoginFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse res=(HttpServletResponse)response;
		HttpServletRequest req=(HttpServletRequest)request;
		
				
		HttpSession session=req.getSession();
		
		
		if(session.getAttribute("manage")==null) {
			RequestDispatcher view=req.getRequestDispatcher("../manage/managelogin.jsp");
			view.forward(request,response);
		}else {
			
			RequestDispatcher view=req.getRequestDispatcher("../module/addmodule.jsp");
			view.forward(request,response);
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
