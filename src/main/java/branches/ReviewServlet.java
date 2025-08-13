package branches;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Review_Write")
public class ReviewServlet extends HttpServlet{

	 @Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     resp.setContentType("text/html; charset=UTF-8");
		 req.getRequestDispatcher("WEB-INF/views/reviewWrite.jsp").forward(req, resp);
	 }
	
	
	 @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 	req.setCharacterEncoding("UTF-8");
		 	resp.setContentType("text/html; charset=UTF-8");
		 	
	        String id = req.getParameter("R_cityCode");
	        String title = req.getParameter("R_title");
	        String detail = req.getParameter("R_detail");

	        Service s = new Service();
	        
	        boolean result = s.InsertReview(id, title, detail);

	        if(result) {
	        req.setAttribute("message", "문의가 성공적으로 등록되었습니다.");
	        req.getRequestDispatcher("WEB-INF/views/reviewOK.jsp").forward(req, resp);
	        }else {
	        req.setAttribute("message", "문의 등록 실패");
	        req.getRequestDispatcher("WEB-INF/views/reviewWrite.jsp").forward(req, resp);
	        }
	        
	    }
	
	
	 
}
