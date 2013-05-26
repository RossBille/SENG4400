package services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

/**
 * Servlet class used to call external payment methods
 * Uses wsdl generated classes in this package to make the method call
 * Servlet class doesnt implement doGet
 * @author rossbille
 *
 */
@WebServlet("/Pay")
public class Pay extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			//locate the 
			ProcessPaymentServiceService ppss = new ProcessPaymentServiceServiceLocator();
			String result = "Last payment returned result: ";
			ProcessPaymentService ps = ppss.getprocessPaymentServicePort();
			if(request.getParameter("type").equals("paypal"))
			{
				result += ps.processPaypal(request.getParameter("id"));
			}else{
				result += ps.processCard(request.getParameter("id"));
			}
			request.getSession().setAttribute("lastResult", result);
			//redirect back to the store
			response.sendRedirect("store.jsp");
		} 
		catch (ServiceException e) 
		{
			e.printStackTrace();
		}
		catch (NullPointerException e) 
		{
			request.getSession().setAttribute("lastResult", "Please fill out all the fields");
			response.sendRedirect("store.jsp");
		}
	}
}
