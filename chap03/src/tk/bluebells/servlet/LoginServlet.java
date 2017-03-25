package tk.bluebells.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		User user = new User(name,pwd);
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		response.getWriter().print("欢迎"+user.name+",您已成功登录！<br>");
		response.getWriter().print("查看<a href='session1.jsp' >session1</a><br>");
		response.getWriter().print("查看<a href='session2.jsp' >session2</a>");
	}

}
