package tk.bluebells.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendCookieServlet
 */
@WebServlet("/ReadCookieServlet")
public class ReadCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cookieName = "username";
		String cookieValue = null;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(int i=0; i<cookies.length; i++){
				Cookie cookie = cookies[i];
				System.out.println(cookie.getName()+"\n"+cookie.getValue());
				if(cookie.getName().equals(cookieName)){
					cookieValue = cookie.getValue();
				} else {
					cookieName = cookie.getName(); //返回JSESSIONID
					cookieValue = cookie.getValue();
				}
			}
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><title>读取Cookie</title>");
		out.println("<body>从浏览器读回一个Cookie.<br>");
		out.println("Cookie名："+cookieName+"<br>");
		out.println("Cookie值："+cookieValue+"<br>");
		out.println("</body></html>");		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);

	}

}
