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
import javax.servlet.http.HttpSession;

import domain.User;

@WebFilter(urlPatterns = { "/setpremium", "/setpremium.jsp", "/dosetpremium", "/premium.jsp"})
public class SetPremimFilter implements Filter {



	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession();
		
		if(session.getAttribute("current_user")==null)
		{
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("/index.jsp");
			return;
		}
		
		User user = (User) session.getAttribute("current_user");
		
		if(!user.IsPrivilaged())
		{
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("/menu");
			return;
		}
		
		chain.doFilter(request, response);

	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

