package lesson1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MultServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			//getParameter("i") 获取的是name的值
			Integer i=Integer.parseInt(req.getParameter("i"));
			Integer j=Integer.parseInt(req.getParameter("j"));
			Integer r=i*j;
			resp.getWriter().print(r);
	}

}
