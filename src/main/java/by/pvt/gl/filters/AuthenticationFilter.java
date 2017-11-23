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
		users.put("name", "qwerty");

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		String authHeader = request.getHeader("Authorization");
		if (authHeader == null) {
			error401(response);
			return;
		}

		String[] headerParts = authHeader.split(" ");
		String userPasswordEncoded = headerParts[1];
		String credentials = new String(Base64.getDecoder().decode(
				userPasswordEncoded));
		String[] userPassword = credentials.split(":");
		if (userPassword == null || userPassword.length < 2) {
			error401(response);
			return;
		}
		String user = userPassword[0];
		String password = userPassword[1];

		String expectedPassword = users.get(user);
		if (password != null && password.equals(expectedPassword)) {
			chain.doFilter(req, resp);

		} else {
			error401(response);
			return;
		}
	}

	private void error401(HttpServletResponse response) throws IOException {

		response.addHeader("WWW-Authenticate", "Basic");
		response.setStatus(401);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
