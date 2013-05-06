package services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;


@WebServlet("/Pay")
public class Pay extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ProcessPaymentServiceService ppss = new ProcessPaymentServiceServiceLocator();
		try 
		{
			String result = "Last payment returned result: ";
			ProcessPaymentService ps = ppss.getprocessPaymentServicePort();
			if(request.getParameter("type").equals("paypal"))
			{
				result += ps.processPaypal(request.getParameter("id"));
			}else{
				result += ps.processCard(request.getParameter("id"));
			}
			request.getSession().setAttribute("lastResult", result);
			response.sendRedirect("store.jsp");
		} 
		catch (ServiceException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
