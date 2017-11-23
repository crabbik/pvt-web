package by.pvt.gl.filters;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationFilter implements Filter {
	private static HashMap<String, String> users = new HashMap<>();

	static {
		users.put("user1", "pass1");
		users.put("user2", "pass2");
		users.put("user3", "pass3");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		String authHeader = request.getHeader("Authorization");
		String[] headerParts = authHeader.split(" ");
		String userPasswordEncoded = headerParts[1];
		String credentials = new String(Base64.getDecoder().decode(
				userPasswordEncoded));
		String[] userPassword = credentials.split(":");
		String user = userPassword[0];
		String password = userPassword[1];
		System.out.println(user + " " + password);
		// chain.doFilter(req, resp);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
