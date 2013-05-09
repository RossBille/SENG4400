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
 * @author rossbille
 *
 */
public class Login extends HttpServlet {
	private Map<String, String> usernames;
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		usernames = new HashMap<String, String>();
		usernames.put("Admin", "Admin");
		usernames.put("User", "User");	
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try{
			if (usernames.get(username).equals(password)) {
				post("success");
				//System.out.println("success");
				response.sendRedirect("store.jsp");
			} else {
				//System.out.println("wrong password");
				post("wrong password");
				response.sendRedirect("error.jsp");
			}
		}
		catch(NullPointerException e)
		{
			//System.out.println("error");
			post("error");
			response.sendRedirect("error.jsp");
		}
	}


	private void post(String m) 
	{
		try 
		{
			Properties props = new Properties();
			props.put(Context.PROVIDER_URL, "iiop://127.0.0.1:3700");

			Context context = new InitialContext(props);
			TopicConnectionFactory tfactory = (TopicConnectionFactory) context
					.lookup("jms/myConnectionFactory");

			TopicConnection tconnection = tfactory.createTopicConnection();
			TopicSession tsession = tconnection.createTopicSession(false,
					Session.AUTO_ACKNOWLEDGE);
			TopicPublisher publisher = tsession.createPublisher((Topic) context
					.lookup("jms/seng4400ass2PS"));

			TextMessage message = tsession.createTextMessage();
			message.setText(m);
			publisher.publish(message);
			
			context.close();
			tconnection.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
