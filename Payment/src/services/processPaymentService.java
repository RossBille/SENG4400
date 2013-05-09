package services;
import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public class processPaymentService
{
	/**
	 * 
	 * @param cardNo 	an ID for the credit card
	 * @return SUCCESS or ERROR respectively
	 */
	@WebMethod
	public String processCard(String cardNo) 
	{
		//small and weak server-side validation
		if(cardNo.isEmpty())
		{
			System.out.println("no id was provided");
			return "ERROR";
		}
		System.out.println("Credit Card id: "+cardNo);
		return "SUCCESS";
	}
	
	/**
	 * 
	 * @param paypalID 	an ID for the paypal account
	 * @return SUCCESS or ERROR respectively
	 */
	@WebMethod
	public String processPaypal(String paypalID)
	{
		//small and weak server-side validation
		if(paypalID.isEmpty())
		{
			System.out.println("no id was provided");
			return "ERROR";
		}
		System.out.println("Paypal id: "+paypalID);
		return "SUCCESS";
	}
}