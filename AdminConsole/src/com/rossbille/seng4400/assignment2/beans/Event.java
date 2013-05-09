package com.rossbille.seng4400.assignment2.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Simple bean to hold login attempt information
 * consisting of a time stamp of when the event occurred
 * and a boolean representing whether the attempt was successful
 * @author rossbille
 *
 */
public class Event implements Serializable, Comparable<Event>
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
	/**
	 * Function to convert the time stamp into a readable date
	 * @return 	String representation of the time this event was created
	 * 			In the format dd/MM/yy - HH:mm
	 */
	public String getDate()
	{
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(this.timeStamp);
		return new SimpleDateFormat("dd/MM/yy - HH:mm").format(c.getTime());
	}
	public long getTimeStamp() 
	{
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) 
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
	@Override
	//implements reverse order
	public int compareTo(Event o) 
	{
		return Long.compare(o.getTimeStamp(), this.timeStamp);
	}	
}
