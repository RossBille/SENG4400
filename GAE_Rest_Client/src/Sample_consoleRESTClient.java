import org.restlet.resource.ClientResource;


public class Sample_consoleRESTClient {
	public static void main(String[] args) throws Exception
	{
		ClientResource cr = 
				new ClientResource("http://localhost:8888/sample_rest");
		
		Sample_gapRESTObj obj = cr.get(Sample_gapRESTObj.class);
		
		System.out.println("Parsed results:");
		System.out.println(obj.par1);
		System.out.println(obj.par2);
	}
}
