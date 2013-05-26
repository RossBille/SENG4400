package com.rossbille.seng4400.assignment2.authenticate;

import java.io.IOException;
import java.util.*;

import javax.jms.*;
import javax.naming.*;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet to deal with authentication
 * Hard coded user names and passwords are as follows:
 * 		username: User 
 * 		password: User
 * 		username: Admin 
 * 		password: Admin
 * Only ha an implementation of doPost.
 * @author rossbille
 *
 */
public class Login extends HttpServlet 
{
	private Map<String, String> usernames;
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException 
	{
		usernames = new HashMap<String, String>();
		usernames.put("Admin", "Admin");
		usernames.put("User", "User");	
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		//grab parameters from the posted form
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//server-side check
		try{
			if (usernames.get(username).equals(password)) 
			{
				post("success");
				request.getSession().setAttribute("lastResult", "No purchases have been processed this session.");
				response.sendRedirect("store.jsp");
			}else{
				post("wrong password");
				response.sendRedirect("error.jsp");
			}
		}
		//if null then one of the fields is missing
		catch(NullPointerException e)
		{
			post("error");
			response.sendRedirect("error.jsp");
		}
	}

	/**
	 * method used to publish messages to the queue
	 * @param m		message to be published to the queue
	 */
	private void post(String m) 
	{
		try 
		{
			//get resources needed for the message queue
			Properties p = new Properties();
			p.put(Context.PROVIDER_URL, "iiop://127.0.0.1:3700");
			Context context = new InitialContext(p);
			TopicConnectionFactory tf = (TopicConnectionFactory) context.lookup("jms/myConnectionFactory");
			TopicConnection tc = tf.createTopicConnection();
			TopicSession ts = tc.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			TopicPublisher publisher = ts.createPublisher((Topic) context.lookup("jms/seng4400ass2PS"));
			//create and publish the actual message
			TextMessage message = ts.createTextMessage();
			message.setText(m);
			publisher.publish(message);
			//release resources
			context.close();
			tc.close();
		} 
		catch (Exception  e) 
		{
			e.printStackTrace();
		}
	}
}
