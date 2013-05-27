package com.rossbille.seng4400.assignment3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;

import static com.google.appengine.api.taskqueue.TaskOptions.Builder.*;

public class Sample_gapREST extends ServerResource {
	private static volatile SampleRESTObject obj = new SampleRESTObject();
	@Get
	public SampleRESTObject retrieve() {
		System.out.println("clear the list please");
		Queue q = QueueFactory.getQueue("pull-queue");
		return q.lease();
	}

	@Put
	public void store(SampleRESTObject myObj) {
		System.out.println(myObj.toString());
		Queue q = QueueFactory.getQueue("pull-queue");
		q.add(TaskOptions.Builder.withMethod(TaskOptions.Method.PULL)
				.payload(myObj.toString()));
		
		System.out.println("new object added");
	}
}
