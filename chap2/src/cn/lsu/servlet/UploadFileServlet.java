package cn.lsu.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadFileServlet
 */
@WebServlet("/fileUpload.do")
@MultipartConfig(location="D:\\35398\\",fileSizeThreshold=1024)
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UploadFileServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		//获取服务器web应用程序根目录 
		//D:\35398\Java\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\chap2
		String path = this.getServletContext().getRealPath("/");
		String number = request.getParameter("number");	//会员名
		Part p = request.getPart("fileName"); //文件名
		
		String message = "";
		if(p.getSize()>1024*1024) {  //上传的文件不能超过1MB
			p.delete();
			message = "文件超过1MB，不能上传！";
		} else {
			path = path + "\\upload\\" + number;	// upload\123
			File f = new File(path);
			if(!f.exists()) {  //若目录不存在，则创建目录
				f.mkdirs();
			}
		}
		String h = p.getHeader("content-disposition");
		String fname = h.substring(h.lastIndexOf("\\") + 1, h.length() - 1);
		p.write(path + "\\" + fname);
		message ="文件上传成功~";
		request.setAttribute("message", message);
		
		System.out.println(h + "\n" + path);
		RequestDispatcher rd = request.getRequestDispatcher("/fileUpload.jsp");
		rd.forward(request, response);
	}
}
