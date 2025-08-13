package branches;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/B_I_OrderList")
public class B_I_OrderListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String B_Code = (String) session.getAttribute("loginId");
		
		Service s = new Service();
		ArrayList<B_I_Order> ordeLlist = s.selectBIOrder(B_Code);

		req.setAttribute("ordeLlist", ordeLlist);
		
		req.getRequestDispatcher("WEB-INF/views/b_i_orderList.jsp").forward(req, resp);

	}
}
