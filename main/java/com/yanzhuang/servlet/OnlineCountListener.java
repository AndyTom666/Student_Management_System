package com.yanzhuang.servlet;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.yanzhuang.util.OnlineCount;

/**
 * Application Lifecycle Listener implementation class OnlinListener
 *
 */
@WebListener
public class OnlineCountListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public OnlineCountListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("session create success!");
    	OnlineCount.counter.incrementAndGet();
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	OnlineCount.counter.decrementAndGet();
    }
	
}
