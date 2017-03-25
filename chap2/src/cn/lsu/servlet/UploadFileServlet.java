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
		//��ȡ������webӦ�ó����Ŀ¼ 
		//D:\35398\Java\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\chap2
		String path = this.getServletContext().getRealPath("/");
		String number = request.getParameter("number");	//��Ա��
		Part p = request.getPart("fileName"); //�ļ���
		
		String message = "";
		if(p.getSize()>1024*1024) {  //�ϴ����ļ����ܳ���1MB
			p.delete();
			message = "�ļ�����1MB�������ϴ���";
		} else {
			path = path + "\\upload\\" + number;	// upload\123
			File f = new File(path);
			if(!f.exists()) {  //��Ŀ¼�����ڣ��򴴽�Ŀ¼
				f.mkdirs();
			}
		}
		String h = p.getHeader("content-disposition");
		String fname = h.substring(h.lastIndexOf("\\") + 1, h.length() - 1);
		p.write(path + "\\" + fname);
		message ="�ļ��ϴ��ɹ�~";
		request.setAttribute("message", message);
		
		System.out.println(h + "\n" + path);
		RequestDispatcher rd = request.getRequestDispatcher("/fileUpload.jsp");
		rd.forward(request, response);
	}
}
