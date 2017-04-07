package cn.edu.lsu.bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={ "/showStudent", "/addStudent", "/editStudent", "/delStudent", "/checkId", "/checkQq" })
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<Student> students = new ArrayList<Student>();	
	public void init(ServletConfig config) throws ServletException {
		Student s1 = new Student("01", "关羽", 23, "598086307");
		Student s2 = new Student("02", "张飞", 22, "598086307");
		Student s3 = new Student("03", "刘备", 21, "353988079");
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");
		String uri = new String(request.getRequestURI());
		if(uri.endsWith("showStudent")) { 
			showStudent(request,response); //显示所有学生
		} else if(uri.endsWith("addStudent")) {
			if(request.getMethod().equals("GET")){
				response.sendRedirect("showStudent.jsp");
			}else{
				addStudent(request,response);
			}
		} else if(uri.endsWith("editStudent")) {
			editStudent(request,response);
		} else if(uri.endsWith("delStudent")) {
			delStudent(request, response);
		} else if(uri.endsWith("checkId")) {
			checkInfo(request, response, "id");	
		} else if(uri.endsWith("checkQq")) {
			checkInfo(request, response, "qq");	
		}
	}

	private void checkInfo(HttpServletRequest request, HttpServletResponse response, String str) throws IOException {
		String attr = request.getParameter(str);
		PrintWriter out = response.getWriter();
		for(Student stu:students){
			if(str.equals("id")){
				if(stu.id.equals(attr)) {
					System.out.println("checkId?id="+attr);
					out.print(true);
				}				
			}
			if(str.equals("qq")){
				if(stu.qq.equals(attr)) {
					System.out.println("checkQq?qq="+attr);
					out.print(true);
				}				
			}
		}
	}

	private void editStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String name = new String(request.getParameter("name").getBytes("iso8859-1"),"utf-8"); //GET请求中文转码
		name = URLDecoder.decode(name, "UTF-8");
		System.out.println("editStudent?name="+name);
		String qq = request.getParameter("qq");
		for(Student stu:students){
			if(stu.id.equals(id)) {
				if(!stu.name.equals(name)){
					stu.name = name;
				}
				if(request.getParameter("age")!=""){
					int age = Integer.valueOf(request.getParameter("age"));
					if(stu.age != age){
						stu.age = age;
					}					
				}
				if(!stu.qq.equals(qq)){
					stu.qq = qq;
				}
				break;
			}
		}
		request.setAttribute("students", students);
		response.sendRedirect("showStudent");
	}

	private void delStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("删除了: "+id);
		for(Student stu:students){
			if(stu.id.equals(id)) {
				students.remove(stu);
				break;
			}
		}
		request.setAttribute("students", students);
		//request.getRequestDispatcher("showStudent").forward(request, response);
		response.sendRedirect("showStudent");
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		System.out.println("addStudent方法");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.valueOf(request.getParameter("age"));
		String qq = request.getParameter("qq");
		students.add(new Student(id, name, age, qq));
		request.setAttribute("students", students);
		//request.getRequestDispatcher("showStudent").forward(request, response);
		response.sendRedirect("showStudent");  //避免uri不变导致刷新时重复提交表单
	}

	private void showStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("showStudent方法");
		request.setAttribute("students", students);
		request.getRequestDispatcher("showStudent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
