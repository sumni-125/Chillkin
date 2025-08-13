package branches;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ingredients")
public class IngredientsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		IngredientsDAO dao = new IngredientsDAO();

		HttpSession session = req.getSession();
		String branchId = (String) session.getAttribute("loginId");

		Service s = new Service();

		ArrayList<Ingredients> list = s.selectIngredients(branchId);

		req.setAttribute("list", list);

		req.getRequestDispatcher("WEB-INF/views/ingredients.jsp").forward(req, resp);

	}

}
