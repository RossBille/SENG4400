package com.rossbille.seng4400.assignment2.beans;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


public class Records implements Serializable
{
	private static final long serialVersionUID = 1L;
	List<Event> events;
	public Records()
	{
		events = new LinkedList<Event>();
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
}
