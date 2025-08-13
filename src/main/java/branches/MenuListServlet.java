package branches;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MenuList")
public class MenuListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Service s = new Service();
		ArrayList<Menu> mList = s.selectMenu();
		ArrayList<Branches> bList = s.selectBranchesList();
		
		req.setAttribute("mList", mList);
		req.setAttribute("bList", bList);
		req.getRequestDispatcher("WEB-INF/views/menuList.jsp").forward(req, resp);
	}

}
