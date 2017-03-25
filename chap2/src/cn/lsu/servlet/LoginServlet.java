package cn.lsu.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/LoginServlet", "/login.do" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equals("admin") && password.equals("admin")){
            request.setAttribute("username", username);
            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");//定义 接收客户端请求并将数据发送到服务器上JSP文件的 对象
            rd.forward(request, response); //将请求从一个 servlet 转发到服务器上的另一个资源  JSP 文件
        } else {
        	request.setAttribute("error", "用户名或密码错误，请重新输入！");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");//定义 接收客户端请求并将数据发送到服务器上JSP文件的 对象
            rd.forward(request, response); //将请求从一个 servlet 转发到服务器上的另一个资源  JSP 文件
        }
	}

}
