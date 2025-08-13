package headquerter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/h_orderingInfo")
public class H_orderingInfoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		B_I_OrderDAO oDAO = new B_I_OrderDAO();
		ArrayList<B_I_Order> list = oDAO.allOrders();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/h_orderingInfo_j.jsp").forward(req, resp);
	}
}
