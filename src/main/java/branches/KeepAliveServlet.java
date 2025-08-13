package branches;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/keep-alive")
public class KeepAliveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        
        // 응답 콘텐츠 타입을 JSON으로 설정
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        
        // PrintWriter로 응답을 작성
        PrintWriter out = resp.getWriter();
        
        // 세션이 존재하면 세션 연장
        if (session != null) {
            session.setMaxInactiveInterval(30 * 60); // 30분 연장
            
			// 성공적으로 세션 연장했을 때 JSON 응답

			// Map<String, String> messgage = new HashMap<>();
			// messgage.put("status", "success");
			// messgage.put("message", "세션이 30분 연장되었습니다");

            out.print("{\"status\": \"success\", \"message\": \"세션이 30분 연장되었습니다.\"}");
            resp.setStatus(HttpServletResponse.SC_OK);  // 상태 코드 200
        } else {
            // 세션이 없을 경우, 인증되지 않았다고 응답
            out.print("{\"status\": \"error\", \"message\": \"세션이 만료되었습니다. 다시 로그인해주세요.\"}");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);  // 상태 코드 401
        }
        
        // 응답을 전송
        out.flush();
    }
}
