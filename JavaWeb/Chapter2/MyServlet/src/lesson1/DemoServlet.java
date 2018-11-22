package lesson1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String param_i=req.getParameter("i");
		String param_j=req.getParameter("j");
		
		if(param_i.equals("")||param_j.equals("")){
			return;
		}else {
			Integer i=Integer.parseInt(param_i);
			Integer j=Integer.parseInt(param_j);
			Integer r=i+j;
			
			resp.getWriter().print(r);
		}
		
	}

}
