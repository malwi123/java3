package tests;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import domain.ConferenceApplication;
import domain.User;
import repositories.UserRepository;
import servlets.AddUserServlet;


@RunWith(MockitoJUnitRunner.class)
public class BaseTests  extends Mockito{
	
	@Spy
	UserRepository repo = mock(UserRepository.class);
	
	@InjectMocks
	AddUserServlet addUserServlet;
	
	
	@Test
	public void AddUserServletShouldWriteInfoIntoSession() throws IOException, ServletException
	{
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);
		
		HttpSession ses = mock(HttpSession.class);
		RequestDispatcher rd = mock(RequestDispatcher.class);
		
		when(req.getSession()).thenReturn(ses);
		when(req.getParameter("usertype")).thenReturn("admin");
		when(req.getRequestDispatcher("menu")).thenReturn(rd);
		
		addUserServlet.doGet(req, resp);
		verify(ses).setAttribute(eq("current_user"), Mockito.any(ConferenceApplication.class));
	}
	
	@Test
	public void AddUserServletShouldAddIntoRepo() throws IOException, ServletException
	{
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);
		
		HttpSession ses = mock(HttpSession.class);
		RequestDispatcher rd = mock(RequestDispatcher.class);
		
		when(req.getSession()).thenReturn(ses);
		when(req.getParameter("usertype")).thenReturn("admin");
		when(req.getRequestDispatcher("menu")).thenReturn(rd);

		addUserServlet.doGet(req, resp);
		verify(repo).add(Mockito.any(User.class));
	}
	
	@Test
	public void AddUserServletShouldRedirectUser() throws IOException, ServletException
	{
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);
		
		HttpSession ses = mock(HttpSession.class);
		RequestDispatcher rd = mock(RequestDispatcher.class);
		
		when(req.getSession()).thenReturn(ses);
		when(req.getParameter("usertype")).thenReturn("admin");
		when(req.getRequestDispatcher("menu")).thenReturn(rd);

		addUserServlet.doGet(req, resp);
		verify(resp).sendRedirect("menu");
	}
	
		
}
