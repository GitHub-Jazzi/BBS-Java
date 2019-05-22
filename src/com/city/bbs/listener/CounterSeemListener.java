package com.city.bbs.listener;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.city.bbs.counter.factory.ServiceFactory;
import com.city.bbs.counter.model.CounterModel;
import com.city.bbs.counter.service.impl.CounterServiceImpl;

/**
 * Application Lifecycle Listener implementation class CounterSeemListener
 *
 */
@WebListener
public class CounterSeemListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public CounterSeemListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	CounterServiceImpl c_user=(CounterServiceImpl) ServiceFactory.createCounterService();
    	
    	Calendar c = Calendar.getInstance();
    	int h=c.get(Calendar.HOUR_OF_DAY); 
    	if(h>=5&&h<=9){
    	    c_user.addMor();
    	}else if(h>9&&h<=15){
    		c_user.addNoo();
    	}else if(h>15&&h<=20){
    		c_user.addEve();
    	}else{
    		c_user.addNig();
    	}
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
