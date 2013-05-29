package com.rossbille.seng4400.assignment3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Pay extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//create new payment object
		Payment payment = new Payment();
		//with post parameters
		payment.setId(request.getParameter("id"));
		payment.setType(request.getParameter("type"));
		//get a reference to the Controller servlet
		Controller controller = new Controller();
		//store the payment 
		controller.store(payment);
		//redirect user back to the store
		response.sendRedirect("store.jsp");
	}
}