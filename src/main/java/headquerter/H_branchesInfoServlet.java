package headquerter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/h_branchesInfo")
public class H_branchesInfoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BranchesDAO bDAO = new BranchesDAO();
		ArrayList<Branches> list = bDAO.allBranches();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/h_branchesinfo_j.jsp").forward(req, resp);
	}
}