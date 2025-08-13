package headquerter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/h_main")
public class H_main extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = 1;
		if(req.getParameter("page") !=null) {
			page = Integer.parseInt(req.getParameter("page"));
		}
		
		ReviewService service = new ReviewService();
		PagingVO paging = service.getPaging(page);
		ReviewService r = new ReviewService();
		
		List<Reviews> rlist = service.getPagedReviews(paging);
		ArrayList<Reviews> list = r.getReviewList();
		
		
		req.setAttribute("paging", paging);
		req.setAttribute("rlist", rlist);
		
		req.getRequestDispatcher("WEB-INF/views/h_main.jsp").forward(req, resp);
		
	}
	
}
