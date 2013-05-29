package com.rossbille.seng4400.assignment3.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.rossbille.seng4400.assignment3.MyThread;

/**
 * Application Lifecycle Listener implementation class Startup
 *
 */
@WebListener
public class Startup implements ServletContextListener 
{
	
    /**
     * Default constructor. 
     */
    public Startup() 
    {
    	
    }

	/**
	 * Starts up a background thread that will poll the google app for payment details
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    private Thread myThread = null;
    public void contextInitialized(ServletContextEvent sce) 
    {
        System.out.println("Payment Service started");
        if((myThread == null ) || (!myThread.isAlive()))
    	{
        	System.out.println("started thread");
    		myThread = new Thread(new MyThread());
    		myThread.start();
    	}
    }

	@Override
	public void contextDestroyed(ServletContextEvent sce) 
	{
		try
		{
			myThread.interrupt();
		}
		catch (Exception e)
		{
			
		}
		System.out.println("stopped thread");
	}	
}