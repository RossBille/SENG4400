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

public class Sample_gapREST extends ServerResource {
	private static volatile SampleRESTObject obj = new SampleRESTObject();
	@Get
	public String retrieve() throws UnsupportedEncodingException, UnsupportedOperationException {
		
		Queue q = QueueFactory.getQueue("pull-queue");
		List<TaskHandle> tasks = q.leaseTasks(100,TimeUnit.MILLISECONDS,1);
		System.out.println("hi");
		List<java.util.Map.Entry<java.lang.String,java.lang.String>> list = tasks.get(0).extractParams();
		System.out.println(list.get(1).getValue().toString());
		System.out.println("bye");
		q.deleteTask(tasks.get(0));
		System.out.println("clear the list");
		System.out.println(tasks.get(0).getPayload().toString());
		return tasks.get(0).getPayload().toString();
	}

	@Put
	public void store(SampleRESTObject myObj) {
		System.out.println(myObj.toString());
		Queue q = QueueFactory.getQueue("pull-queue");
		q.add(TaskOptions.Builder.withMethod(TaskOptions.Method.PULL)
				.payload(myObj.toString()));
		
		System.out.println("new object added");
	}
	@Post
	public void something(final String input)
	{
		System.out.println(input);
	}
}
