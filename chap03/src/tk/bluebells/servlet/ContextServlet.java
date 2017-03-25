package tk.bluebells.servlet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.CycleRecoverable.Context;

/**
 * Servlet implementation class ContextServlet
 */
@WebServlet("/ContextServlet")
public class ContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//ServletContext context = getServletContext();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    //init函数只在servlet第一次载入的时候调用，对服务器clear以后就会抛异常
//    public void init() {
//    	//通过ServletContext对象获取上下文资源
//    	
//    	//获取web.xml中的定义的初始化参数
//    	String email = context.getInitParameter("adminEmail");
//    	URL url = null;
//    	try {
//    		//获取给定路径的指定url对象(绝对路径),返回URL类型，file开头
//			url = context.getResource("/NewFile.jsp");
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	//获取给定相对路径的绝对路径，返回String类型，盘符开头，反斜杠
//    	String path = context.getRealPath("/NewFile.jsp");
//    	System.out.println(email+"\n"+url.toString()+"\n"+path);
//    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(request.getContextPath()); //chap3
		ServletContext context = getServletContext(); 
		String phone = (String) context.getAttribute("phone");		
		System.out.println("phone:"+phone);
		context.log("我来了");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
