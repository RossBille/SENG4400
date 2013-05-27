package com.rossbille.seng4400.assignment3;

public class SampleRESTObject {
	public String id;
	public String type;
	@Override
	public String toString()
	{
		return "type=paypal&id=qq";
		//return "{\"id\":\""+id+"\",\"type\":\""+type+"\"}";
	}
}
