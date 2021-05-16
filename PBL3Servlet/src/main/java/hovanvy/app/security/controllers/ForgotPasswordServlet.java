package hovanvy.app.security.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hovanvy.common.enums.PathJsp;

/**
 * 
 * @author hovanvydut
 *
 */

@WebServlet(urlPatterns = {"/forgot-password"})
public class ForgotPasswordServlet extends HttpServlet{
	
	@Override 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("Helo");
		request.getRequestDispatcher(PathJsp.FORGOT_PASSWORD.getPath()).forward(request, response);
	}

}
