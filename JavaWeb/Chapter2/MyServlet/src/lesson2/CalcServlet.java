package lesson2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int i1 = Integer.parseInt(req.getParameter("i1"));
		int i2 = Integer.parseInt(req.getParameter("i2"));
		String op = req.getParameter("op");
		Float calc;
		switch (op) {
		case "+":
			calc = ((float) i1 + i2);
			break;
		case "-":
			calc = ((float) i1 - i2);
			break;
		case "*":
			calc = ((float) i1 * i2);
			break;
		case "/":
			calc = ((float) i1 / i2);
			break;
		default:
			calc = (float) -1;
			break;
		}

		resp.getWriter().print(calc);
	}
}
