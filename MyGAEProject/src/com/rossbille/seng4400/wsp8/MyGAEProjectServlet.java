package com.rossbille.seng4400.wsp8;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class MyGAEProjectServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
