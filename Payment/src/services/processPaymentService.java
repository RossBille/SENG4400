package services;
import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public class processPaymentService
{

	@WebMethod
	public String processCard(String cardNo) 
	{
		System.out.println(cardNo);
		return "";
	}
	
	@WebMethod
	public String processPaypal(String paypalID)
	{
		System.out.println(paypalID);
		return "";
	}
}