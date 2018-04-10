package web.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import repositories.DummyUserRepository;

@WebFilter(urlPatterns = { "/login", "/login.jsp"})
public class LoginFilter implements Filter {



	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String username = httpReq.getParameter("username");
		
		Boolean ok = false;
		
		for (User user : DummyUserRepository.db) {
			
			if (username.equals(user.getUsername()))
			{
				ok = true;
			}

		}
	
		if(!ok)
		{
			httpResponse.sendRedirect("/");
			return;
		}
		
		chain.doFilter(request, response);

	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

