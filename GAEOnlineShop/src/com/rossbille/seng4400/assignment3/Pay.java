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
		SampleRESTObject obj = new SampleRESTObject();
		obj.id = request.getParameter("id");
		obj.type = request.getParameter("type");
		Sample_gapREST gap = new Sample_gapREST();
		gap.store(obj);
		response.sendRedirect("store.jsp");
	}
}