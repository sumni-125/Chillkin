package branches;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;



@WebServlet("/myReview")
public class ReviewListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		
		HttpSession session = req.getSession();
		String b_code = (String) session.getAttribute("loginId");
		
		Service s = new Service();
		JSONArray arr = s.getJsonArray(b_code);
		out.print(arr);
		
		
	}
}
