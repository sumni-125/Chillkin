package headquerter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/h_stockmanage")
public class H_stockManageServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HubDAO hDAO = new HubDAO();
		ArrayList<Hub> list =hDAO.allHubs(); 
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/h_stockmanage_j.jsp").forward(req, resp);
	}
}
