package by.pvt.gl.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter w = resp.getWriter();
		w.println("<HTML>");
		w.println("<body>");
		w.println("<h1>Hello</h1>");
		w.println("</body>");
		w.println("</HTML>");

	}

}
