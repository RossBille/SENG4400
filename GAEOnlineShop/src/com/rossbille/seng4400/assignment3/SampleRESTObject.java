package com.rossbille.seng4400.assignment3;

public class SampleRESTObject {
	public String id;
	public String type;
	@Override
	public String toString()
	{
		return "{\"id\":\""+id+",\"type\":\""+type+"\"}";
	}
}
