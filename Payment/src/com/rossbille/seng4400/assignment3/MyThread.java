package com.rossbille.seng4400.assignment3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.restlet.resource.ClientResource;

public class MyThread implements Runnable
{
	private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
	public void start() 
	{
		run();
	}
	@Override
	public void run() 
	{
		//System.out.println("hello");
		//poll for new transactions
		System.out.println("polling");
		ClientResource cr = new ClientResource("http://localhost:8888/sample_rest");
		String str = cr.get(String.class);
		//check if null
		
		if(str != null)
		{
			System.out.println(str);
		}
		
		//schedule 
		scheduler.schedule(this, 1, TimeUnit.SECONDS);
		
	}
	
}