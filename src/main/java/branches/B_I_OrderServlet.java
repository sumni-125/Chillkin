package branches;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/B_I_Order")
public class B_I_OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Service s = new Service();
        ArrayList<Hub> h_list = s.selectHub();

        req.setAttribute("h_list", h_list);
        req.getRequestDispatcher("WEB-INF/views/b_i_order.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String B_Code = (String) session.getAttribute("loginId");  

        String[] codes = req.getParameterValues("I_Code[]");
        String[] counts = req.getParameterValues("I_Cnt[]");

        Service s = new Service();

        if (codes != null && counts != null) {
            for (int i = 0; i < codes.length; i++) {
                int count = 0;
                try {
                    count = Integer.parseInt(counts[i]);
                } catch (NumberFormatException e) {
                    continue;
                }

                if (count > 0) {
                    B_I_Order order = new B_I_Order(B_Code, codes[i], count);
                    s.insertBIOrder(order);
                }
            }
        }

        req.getRequestDispatcher("/WEB-INF/views/b_i_orderComplete.jsp").forward(req, resp);

    }
}

