package com.rossbille.seng4400.assignment3;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 * Router class that directs all requests to the Controller class
 * @author rossbille
 *
 */
public class RESTApplication extends Application 
{
	@Override
	public Restlet createInboundRoot()
	{
		Router router = new Router(getContext());
		router.attachDefault(Controller.class);
		return router;
	}
}
