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

import domain.UserType;


@WebFilter("/add")
public class AddFilter implements Filter {



	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession();
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		if(session.getAttribute("current_user")!=null)
		{
			httpResponse.sendRedirect("/profile");
			return;
		}
		
		
		String username = httpRequest.getParameter("username");
		String email = httpRequest.getParameter("email");
		String pass = httpRequest.getParameter("password");  
		String cpass = httpRequest.getParameter("cpassword");  
		
		
		if(username==null || email==null || pass==null || !pass.equals(cpass))
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
