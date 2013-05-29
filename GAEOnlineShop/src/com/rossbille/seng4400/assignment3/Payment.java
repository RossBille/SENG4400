package com.rossbille.seng4400.assignment3;

public class Payment implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	private String id;
	private String type;
	@Override
	public String toString()
	{
		return "type="+type+"&id="+id;
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
