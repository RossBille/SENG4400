package com.rossbille.seng4400.assignment3;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskHandle;
import com.google.appengine.api.taskqueue.TaskOptions;

import static com.google.appengine.api.taskqueue.TaskOptions.Builder.*;

public class Controller extends ServerResource 
{
	@Get
	public Payment retrieve() throws UnsupportedEncodingException, UnsupportedOperationException {
		
		//get a reference to the qeue
		Queue q = QueueFactory.getQueue("pull-queue");
		//lease the next task
		List<TaskHandle> tasks = q.leaseTasks(100,TimeUnit.MILLISECONDS,1);
		//empty check
		if(!tasks.isEmpty())
		{
			//get the list of key:value pairs from the task
			List<java.util.Map.Entry<java.lang.String,java.lang.String>> list = tasks.get(0).extractParams();
			//make a new payment object with the above parameters
			Payment payment = new Payment();
			payment.setId(list.get(1).getValue().toString());
			payment.setType(list.get(0).getValue().toString());
			//delete the task from the queue
			q.deleteTask(tasks.get(0));
			//send to the client
			return payment;
		}
		return null;
	}

	@Put
	public void store(Payment payment) 
	{
		System.out.println(payment.toString());
		Queue q = QueueFactory.getQueue("pull-queue");
		q.add(TaskOptions.Builder.withMethod(TaskOptions.Method.PULL).payload(payment.toString()));
		System.out.println("new object added");
	}
}
