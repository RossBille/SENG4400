package com.rossbille.seng4400.assignment2.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;

import java.util.*;

import javax.jms.*;
import javax.naming.*;

/**
 * Application Lifecycle Listener implementation class Listener
 * 
 */
@WebListener
public class Listener extends HttpServlet implements ServletContextListener,
		MessageListener {
	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			Properties props = new Properties();
			props.put(Context.PROVIDER_URL, "iiop://127.0.0.1:3700");

			Context context = new InitialContext(props);
			TopicConnectionFactory tfactory = (TopicConnectionFactory) context
					.lookup("jms/myConnectionFactory");

			TopicConnection tconnection = tfactory.createTopicConnection();
			TopicSession tsession = tconnection.createTopicSession(false,
					Session.AUTO_ACKNOWLEDGE);
			TopicSubscriber subscriber = tsession
					.createSubscriber((Topic) context
							.lookup("jms/seng4400ass2PS"));

			subscriber.setMessageListener(this);

			tconnection.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			try {
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
