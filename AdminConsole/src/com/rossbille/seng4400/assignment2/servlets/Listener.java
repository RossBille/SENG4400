package com.rossbille.seng4400.assignment2.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;
import java.util.*;

import javax.jms.*;
import javax.naming.*;

import com.rossbille.seng4400.assignment2.beans.Event;
import com.rossbille.seng4400.assignment2.beans.Records;

/**
 * Application Lifecycle Listener implementation class Listener
 * Starts the message listener when the application server has started up
 * @author rossbille
 */

@WebListener
public class Listener extends HttpServlet implements ServletContextListener, MessageListener 
{

	private static final long serialVersionUID = 1L;
	private static ServletContextEvent e;
	@Override
	public void contextInitialized(ServletContextEvent event) 
	{
		e = event;
		Records records = new Records();
		event.getServletContext().setAttribute("records", records);
		try 
		{
			Properties p = new Properties();
			p.put(Context.PROVIDER_URL, "iiop://127.0.0.1:3700");

			Context context = new InitialContext(p);
			TopicConnectionFactory tf = (TopicConnectionFactory) context
					.lookup("jms/myConnectionFactory");

			TopicConnection tc = tf.createTopicConnection();
			TopicSession ts = tc.createTopicSession(false,
					Session.AUTO_ACKNOWLEDGE);
			TopicSubscriber subscriber = ts.createSubscriber((Topic) context.lookup("jms/seng4400ass2PS"));

			subscriber.setMessageListener(this);

			tc.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onMessage(Message message) 
	{
		if (message instanceof TextMessage) 
		{
			TextMessage tm = (TextMessage) message;
			try 
			{
				boolean success;
				if(tm.getText().equals("success"))
				{
					success = true;
				}else{
					success = false;
				}
				
				Records records = (Records) e.getServletContext().getAttribute("records");
				records.getEvents().add(new Event(System.currentTimeMillis(),success));
				System.out.println(((TextMessage) message).getText());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
	}

}
