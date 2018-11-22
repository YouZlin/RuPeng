package lesson2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userName=req.getParameter("username");
		String userPassword=req.getParameter("password");
		
		if (userName.equals("admin")&&userPassword.equals("123")) {
			resp.getWriter().print("Login Success");
		}else {
			resp.getWriter().print("Login Failed");
		}
	}
}
