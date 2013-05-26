package com.rossbille.seng4400.assignment3;

import java.util.ArrayList;
import java.util.List;

import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

public class Sample_gapREST extends ServerResource {
	private static volatile SampleRESTObject obj = new SampleRESTObject();
	private static List<SampleRESTObject> list = new ArrayList<SampleRESTObject>();
	@Get
	public List<SampleRESTObject> retrieve() {
		System.out.println("clear the list please");
		return list;
	}

	@Put
	public void store(SampleRESTObject myObj) {
		System.out.println("new object added");
		list.add(myObj);
	}
}
