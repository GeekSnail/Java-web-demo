package cn.lsu.servlet;

import java.io.IOException;
import java.io.*;
import java.util.*;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ConfigContext", urlPatterns={"/ConfigContext"},
		initParams={
				@WebInitParam(name="email",value="353988079@qq.com"),
				@WebInitParam(name="telephone",value="123456789")
		})
public class ConfigContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServletConfig config;
	ServletContext context;
//	String email;
//	String telephone;

	public ConfigContext() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
    	this.config = config;
    	this.context = config.getServletContext();
		System.out.println("init");
		Enumeration<String> names = config.getInitParameterNames();
		while(names.hasMoreElements()){
		    String name = names.nextElement();
		    String value = config.getInitParameter(name);
		    System.out.println(name+": "+value);
        }

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("request.getContextPath(): "+request.getContextPath());  //获取上下文路径
		out.println("context.getContextPath(): "+context.getContextPath());  //获取上下文路径
		out.println("config.getServletName(): "+config.getServletName());  //config获取Servlet名称
		Enumeration<String> names = config.getInitParameterNames(); //config获取所有参数名
		while(names.hasMoreElements()){
		    String name = names.nextElement();
		    String value = config.getInitParameter(name); //config根据参数名获取参数值
		    out.println(name+": "+value);
        }
		String jdbcUrl = context.getInitParameter("jdbcUrl");
		out.println(jdbcUrl);	
		String realPath = context.getRealPath("web.xml");
		out.println(realPath);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}