package net.coolblossom.lycee.app.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String JSP_ROOT_DIR = "/WEB-INF/views/";

	protected boolean validateLogined() {
		// TODO: implements validate logined session.
		return true;
	}

	protected void logout() {
		// TODO: implements logout

	}


	protected void redirect(HttpServletRequest request, HttpServletResponse response, String to) throws IOException {
		String ctxPath = getServletContext().getContextPath();
		response.sendRedirect(ctxPath + to);
	}

	protected void forward(HttpServletRequest request, HttpServletResponse response, String forward) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(JSP_ROOT_DIR + forward);
		dispatcher.forward(request, response);
	}

}
