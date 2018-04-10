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


@WebServlet("/add")
public class AddUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private UserRepository repo;
	
	public void init(ServletConfig config)
	{
		repo = new DummyUserRepository();
	}
	
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException
	{
		User user = getUser(request);
		repo.add(user);


		HttpSession session = request.getSession();
		session.setAttribute("current_user", user);

		include("menu", request, response);	
	}
	
	private User getUser(HttpServletRequest req)
	{
		User user = new User();
		
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		UserType userType = UserType.valueOf(req.getParameter("usertype"));

		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(pass);
		user.setUserType(userType);

		return user;	
	}	
	
	private void include(String page, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher(page).include(request, response);
    }
}

