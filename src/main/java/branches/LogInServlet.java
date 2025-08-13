package branches;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LogInServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String branchId = req.getParameter("branch_id");
		String pw = req.getParameter("pw");

		Service s = new Service();

		boolean login = s.checkLogin(branchId, pw);

		if (login) {

			System.out.println("login ok");
			HttpSession session = req.getSession();

			if (branchId.equals("admin")) {
				session.setAttribute("headquerter", branchId);
				resp.sendRedirect(req.getContextPath() + "/h_main");

			} else {
				session.setAttribute("loginId", branchId);
				session.setMaxInactiveInterval(1800);

				String address = s.getAddressByBranchId(branchId);
				session.setAttribute("branch_name", address);

				req.getRequestDispatcher("WEB-INF/views/branchmain.jsp").forward(req, resp);
			}

		} else {
			req.setAttribute("error", "아이디 또는 비밀번호가 틀렸습니다.");
			System.out.println("로그인실패;;");
			req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
		}

	}

}
