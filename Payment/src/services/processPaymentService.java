package services;
import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public class processPaymentService
{

	@WebMethod
	public String processCard(String cardNo) 
	{
		System.out.println("Credit Card id: "+cardNo);
		return "SUCCESS";
	}
	
	@WebMethod
	public String processPaypal(String paypalID)
	{
		System.out.println("Paypal id: "+paypalID);
		return "SUCCESS";
	}
}