package com.rossbille.seng4400.assignment3;

public class Payment implements java.io.Serializable 
{
	private static final long serialVersionUID = 1L;
	private String type;
	private String id;
	@Override
	public String toString()
	{
		return "{\"id\":\""+id+"\",\"type\":\""+type+"\"}";
	}
	public String getType()
	{
		return this.type;
	}
	public String getId()
	{
		return this.id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public void setType(String type)
	{
		this.type = type;
	}
}
