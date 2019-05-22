package com.city.bbs.filter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class UserLoginFilter
 */
@WebFilter("/include/login.jsp")
public class UserLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserLoginFilter() {
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
		
		String ip = request.getRemoteAddr();
		
		
		String uri=request.getServletContext().getRealPath("ip.txt");
		File file=new File(uri);
		FileInputStream in=new FileInputStream(file);
		byte byt[]=new byte[1024];
		String buff="";
		int len;
		while((len=in.read(byt))>0) {
			buff=buff+new String(byt,0,len);
		}
		System.out.println(buff);
		//System.out.println(buff);
		//仅量用equals，用==会报错
		if(!Pattern.matches(".*("+ip+").*", buff)) {
			
			chain.doFilter(request, response);
		}else {
			
			res.sendRedirect("../users/loginfiled.jsp");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
