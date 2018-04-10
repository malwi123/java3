package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import domain.UserType;
import repositories.DummyUserRepository;
import repositories.UserRepository;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private UserRepository repo;
	
	public void init(ServletConfig config)
	{
		repo = new DummyUserRepository();
	}
	
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException
	{
		HttpSession session = request.getSession();
		session.removeAttribute("current_user");

		include("/index.jsp", request, response);	
	}
		
	private void include(String page, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher(page).include(request, response);
    }
}

