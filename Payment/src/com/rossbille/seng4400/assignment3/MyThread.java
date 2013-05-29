package com.rossbille.seng4400.assignment3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.restlet.resource.ClientResource;

public class MyThread implements Runnable
{
	private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
	//get a reference when the thread starts and not every time it is run
	private ClientResource cr = new ClientResource("http://localhost:8888/sample_rest");
	public void start() 
	{		
		run();
	}
	@Override
	public void run() 
	{
		//poll
		Payment payment = cr.get(Payment.class);
		//check if null
		if(payment != null)
		{
			System.out.println(payment);
		}
		
		//schedule 
		scheduler.schedule(this, 1, TimeUnit.SECONDS);
	}
}