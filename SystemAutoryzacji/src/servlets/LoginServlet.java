package servlets;

import java.io.IOException;
import java.util.Arrays;

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


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private UserRepository repo;
	
	public void init(ServletConfig config)
	{
		repo = new DummyUserRepository();
	}
	
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException
	{
		String username = request.getParameter("username");
		HttpSession session = request.getSession();
		
		for (User user : DummyUserRepository.db) {
			
			if (username.equals(user.getUsername()))
			{
				session.setAttribute("current_user", user);
			}

		}

		include("menu", request, response);	
	}

	
	private void include(String page, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher(page).include(request, response);
    }
}

