package listeners;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.restlet.resource.ClientResource;

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
	 * The console application for this assignment will record an event when it is started.
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
        //myThread.run();
        //MyThread myThread = new MyThread();
        //myThread.start();
    }

	@Override
	public void contextDestroyed(ServletContextEvent sce) 
	{
		try{
			myThread.interrupt();
		}
		catch (Exception e)
		{
			
		}
		System.out.println("stopped thread");
	}
	
}
