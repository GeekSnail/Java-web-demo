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
            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");//���� ���տͻ������󲢽����ݷ��͵���������JSP�ļ��� ����
            rd.forward(request, response); //�������һ�� servlet ת�����������ϵ���һ����Դ  JSP �ļ�
        } else {
        	request.setAttribute("error", "用户名或密码错误，请重试！");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");//���� ���տͻ������󲢽����ݷ��͵���������JSP�ļ��� ����
            rd.forward(request, response); //�������һ�� servlet ת�����������ϵ���һ����Դ  JSP �ļ�
        }
	}

}
