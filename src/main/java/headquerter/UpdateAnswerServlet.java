package headquerter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateanswer")
public class UpdateAnswerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect(req.getContextPath() + "/reviewPrint");
	}
	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        // 파라미터 받아오기
        String answer = req.getParameter("h_answer");
        String r_code = req.getParameter("r_code"); // 이 부분이 빠져 있었어!

        // 서비스 객체 생성 및 메서드 호출
        ReviewService service = new ReviewService();
        service.doAnswer(r_code, answer);

        // 처리 후 리디렉션 (예: 다시 리스트 페이지로 보내기)
        resp.sendRedirect(req.getContextPath() + "/reviewPrint");
    }
}
