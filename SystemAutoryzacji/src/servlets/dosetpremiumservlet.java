package servlets;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import domain.UserType;
import repositories.DummyUserRepository;


@WebServlet("/dosetpremium")
public class dosetpremiumservlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException
	{

		String[] selections = request.getParameterValues("privilage");
		
		for (User user : DummyUserRepository.db) {
			if (selections!=null && Arrays.asList(selections).contains(user.getEmail()))
			{
				if(user.getUserType()!=UserType.admin)
				{
					user.setUserType(UserType.privilaged);
				}
			}
			else
			{
				user.setUserType(UserType.standart);
			}
		}
		
		request.setAttribute("userslist", DummyUserRepository.db);

		include("setpremium.jsp", request, response);	
	}
		
	private void include(String page, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher(page).include(request, response);
    }
}