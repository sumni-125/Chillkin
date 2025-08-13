package branches;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/OrderList")
public class OrderListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String B_Code = (String) session.getAttribute("loginId");
		
		
		
		// 로그인 체크 
		
		if(B_Code != null ) {
			Service s = new Service();
			ArrayList<Order> orderList = s.selectOrder(B_Code);
	
			req.setAttribute("olist", orderList);
			
			req.getRequestDispatcher("WEB-INF/views/orderList.jsp").forward(req, resp);
		}else {
			
			// 
			
			resp.sendRedirect(req.getContextPath() +"/login");
		}

	}
}
