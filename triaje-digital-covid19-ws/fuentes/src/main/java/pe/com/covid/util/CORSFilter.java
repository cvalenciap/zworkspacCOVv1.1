package pe.com.covid.util;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import org.springframework.stereotype.Component;
import javax.servlet.Filter;

@Component
public class CORSFilter implements Filter {
	public CORSFilter() {
		super();
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
			throws IOException, ServletException {
		final HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "DELETE, GET, OPTIONS, PATCH, POST, PUT, HEAD");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Origin, X-Auth-Token, Access-Control-Request-Headers, Access-Control-Request-Method, Accept, x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		chain.doFilter(req, res);
	}

	@Override
	public void init(final FilterConfig arg0) throws ServletException {
	}
}