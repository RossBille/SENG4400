package com.rossbille.seng4400.assignment3;

public class Sample_gapRESTObj {
	public String type = "Default1";
	public String id = "Default2";
	@Override
	public String toString()
	{
		return "type="+type+"&id="+id;

		//return "{\"id\":\""+id+"\",\"type\":\""+type+"\"}";
	}
}