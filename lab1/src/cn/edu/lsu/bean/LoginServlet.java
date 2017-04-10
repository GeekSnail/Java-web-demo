package cn.edu.lsu.bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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

    public LoginServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); 
		// username、password 可能为null, 可能不为null
		if(request.getParameter("username") == "") {  
			//?username=
			if(request.getParameter("password") == null) {
				out.print("用户名不能为空！");
			} 
		} else if(request.getParameter("username") == null) { 
			if(request.getParameter("password") == ""){
				//?password=
				out.print("密码不能为空！");	
			}	
		} else { 
			//?username=xxx
			String name = request.getParameter("username");		
			if(!name.equals("admin")) {
				if(request.getParameter("password") == null) {
					out.print("用户名不存在！");	
				} 			
		    }
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); 
		
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
	
		if(name.equals("admin") && pwd.equals("admin")) {
			User user = new User(name,pwd);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);		
            //RequestDispatcher rd = request.getRequestDispatcher("/");
            //rd.forward(request, response);
			response.sendRedirect("showStudent");
		} else {
			request.setAttribute("error", "用户名或密码错误，<br>请重新登录！");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
			//response.sendRedirect("login.jsp");
		}
	}
}
