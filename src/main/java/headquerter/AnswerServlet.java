package headquerter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/answer123")
public class AnswerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터로 받은 r_code를 request에 저장
		String r_code = req.getParameter("r_code");
		req.setAttribute("r_code", r_code);

		// JSP로 포워딩
		req.getRequestDispatcher("/WEB-INF/views/answer.jsp").forward(req, resp);
	}
}
