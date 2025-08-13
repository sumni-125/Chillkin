package branches;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String Menu_Code=req.getParameter("Menu_Code");
		String Branch_Id =req.getParameter("Branch_Id");
		int O_cnt=Integer.parseInt(req.getParameter("O_cnt")) ;
		
		
		
		System.out.println(Menu_Code );
		System.out.println(Branch_Id );
		System.out.println(O_cnt );
		
		
		
		Service s = new Service();
		s.insertOrder(Menu_Code, Branch_Id, O_cnt);
		
		resp.sendRedirect(req.getContextPath()+"/MenuList");
	}
}
