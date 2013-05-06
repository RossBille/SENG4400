package com.rossbille.seng4400.wsp8;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class SampleRESTApplication extends Application {
	@Override
	public Restlet createInboundRoot()
	{
		Router router = new Router(getContext());
		router.attachDefault(Sample_gapREST.class);
		
		return router;
	}

}
