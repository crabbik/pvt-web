package by.pvt.gl.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//String fio = req.getParameter("fio");
		// String lastName = req.getParameter("lastName");
		// int age = Integer.parseInt(req.getParameter("age"));
		// Enumeration<String> params = req.getParameterNames();

		// while (params.hasMoreElements()) {
		// String string = (String) params.nextElement();
		// System.out.println(string);
		// }
		//resp.getWriter().print("Servlet 1");

		//System.out.println(req.getHeader("User-Agent"));
		//System.out.println(req.getHeader("x-my-header"));
		System.out.println("Servlet 1");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("do Post");

	}

}
