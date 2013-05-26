package com.rossbille.seng4400.wsp8;

import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

public class Sample_gapREST extends ServerResource {
	private static volatile SampleRESTObject obj = new SampleRESTObject();
	
	@Get
	public SampleRESTObject retrieve()
	{
		return Sample_gapREST.obj;
	}
	
	@Put
	public void store(SampleRESTObject myObj)
	{
		Sample_gapREST.obj = myObj;
	}
}
