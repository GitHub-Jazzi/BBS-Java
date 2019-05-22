package com.city.bbs.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class CounterInitOnlineListener
 *
 */
@WebListener
public class CounterInitOnlineListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public CounterInitOnlineListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext application=sce.getServletContext();
    	application.setAttribute("onlinenum", 0);
    }
	
}
