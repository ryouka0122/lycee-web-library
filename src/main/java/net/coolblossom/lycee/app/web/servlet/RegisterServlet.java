package net.coolblossom.lycee.app.web.servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends AbstractServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forward(req, resp, "register/index.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(StandardCharsets.UTF_8.displayName());

		if (req.getParameter("doRegister")!=null) {
			doRegister(
					req.getParameter("userName"),
					req.getParameter("pswd"),
					req.getParameter("pswdCnf")
					);
		}

		super.doPost(req, resp);
	}

	private void doRegister(String userName, String password, String passwordCnf) {


	}

}
