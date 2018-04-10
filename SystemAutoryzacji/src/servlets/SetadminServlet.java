package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repositories.DummyUserRepository;


@WebServlet("/setadmin")
public class SetadminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException
	{

		request.setAttribute("userslist", DummyUserRepository.db);

		include("setadmin.jsp", request, response);	
	}
		
	private void include(String page, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher(page).include(request, response);
    }
}


