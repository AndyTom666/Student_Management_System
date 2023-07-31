package com.yanzhuang.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.yanzhuang.po.Login;
import com.yanzhuang.po.LoginVO;
import com.yanzhuang.serviceimpl.LoginServiceImpl;
/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String stuid=request.getParameter("stuid");
		String pwd=request.getParameter("pwd");
		LoginServiceImpl lsi=new LoginServiceImpl();
		//System.out.println(stuid+"*"+pwd);
		LoginVO loginVo=lsi.login(stuid, pwd);
		
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		//session.setMaxInactiveInterval();
		
		if(loginVo.getMessage().equals("notexist"))
		{
			out.write("notexist");
		}
		else if(loginVo.getMessage().equals("wrong pwd"))
		{
			out.write("wrong pwd");
		}
		else if(loginVo.getMessage().equals("welcome student"))
		{
			out.write("welcome student");
		}
		else if(loginVo.getMessage().equals("welcome teacher"))
		{
			out.write("welcome teacher");
		}
		Login log=loginVo.getLog();
		session.setAttribute("log", log);
		/*StudentServiceImpl sti=new StudentServiceImpl();
		//System.out.println(stuid+"*"+pwd);
		StudentVO stuvo=sti.login(stuid, pwd);
		Student stu=stuvo.getStudent();
		PrintWriter out=response.getWriter();
		if(stu!=null&&stu.getPwd().equals(pwd))
		{
			
			HttpSession session=request.getSession();
			//session.setMaxInactiveInterval();
			session.setAttribute("stu", stu);
			//response.sendRedirect("success.jsp");
			out.write("success");
		}
		else if(stu==null)
		{
			out.write("notexist");
		}
		else
		{
			out.write("wrong pwd");
			//response.sendRedirect("login.html");
		}*/
		/*HttpSession session=request.getSession();
		session.setAttribute("stu", stu);
		System.out.println(stuvo.getMessage());
		if(stuvo.getMessage().equals("用户名不存在"))
		{
			response.sendRedirect("notexist.jsp");
		}
		else if(stuvo.getMessage().equals("success"))
		{
			response.sendRedirect("success.jsp");
		}
		else
		{
			response.sendRedirect("login.html");
		}*/
	}

}
