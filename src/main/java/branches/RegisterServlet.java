package branches;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/signup")
public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 req.getRequestDispatcher("WEB-INF/views/register.jsp").forward(req, resp);
	}
	
	
	@Override                        
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String password = req.getParameter("pw");
	    String address = req.getParameter("address");
	    String tel = req.getParameter("tel");

	    BranchesDAO dao = new BranchesDAO();
	    dao.insertUser(password, address, tel);
		
	    
	    req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
		
	}
	
	
	
}
