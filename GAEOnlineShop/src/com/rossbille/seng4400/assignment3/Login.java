package com.rossbille.seng4400.assignment3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.*;

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
	private Logger logger = Logger.getLogger(this.getClass().getSimpleName());
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
				logger.info("success");
				request.getSession().setAttribute("lastResult", "No purchases have been processed this session.");
				response.sendRedirect("store.jsp");
			}else{
				logger.info("wrong password");
				response.sendRedirect("error.jsp");
			}
		}
		//if null then one of the fields is missing
		catch(NullPointerException e)
		{
			logger.info("error");
			response.sendRedirect("error.jsp");
		}
	}
}
