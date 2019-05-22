package com.city.bbs.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class CounterOnlineListener
 *
 */
@WebListener
public class CounterOnlineListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public CounterOnlineListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	ServletContext application=se.getSession().getServletContext();
    	int onlinenum=(int)application.getAttribute("onlinenum");
    	application.setAttribute("onlinenum", onlinenum+1);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	ServletContext application=se.getSession().getServletContext();
    	int onlinenum=(int)application.getAttribute("onlinenum");
    	System.out.println("session´Ý»Ù");
    	application.setAttribute("onlinenum", onlinenum-1);
    }
	
}
