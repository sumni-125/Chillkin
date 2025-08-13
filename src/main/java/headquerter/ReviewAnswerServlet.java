package headquerter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/answering")
public class ReviewAnswerServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String answer = req.getParameter("h_answer");
		String r_code = req.getParameter("r_code");
//		String r_code = null;
		
		ReviewService service = new ReviewService();
		service.doAnswer(r_code, answer);
		
		req.getRequestDispatcher("WEB-INF/views/answer.jsp").forward(req, resp);
	}
}
