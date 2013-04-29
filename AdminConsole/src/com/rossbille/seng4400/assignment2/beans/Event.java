package com.rossbille.seng4400.assignment2.beans;

import java.io.Serializable;

public class Event implements Serializable
{

	private static final long serialVersionUID = 1L;
	private long timeStamp;
	private boolean success;

	public Event(long timeStamp, boolean success) 
	{
		super();
		this.timeStamp = timeStamp;
		this.success = success;
	}
	public Event(){}
	
	public long getId() 
	{
		return timeStamp;
	}
	public void setId(long timeStamp) 
	{
		this.timeStamp = timeStamp;
	}
	public boolean isSuccess() 
	{
		return success;
	}
	public void setSuccess(boolean success) 
	{
		this.success = success;
	}	
}
