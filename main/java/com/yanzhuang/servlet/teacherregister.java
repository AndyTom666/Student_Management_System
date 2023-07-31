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
import com.yanzhuang.po.Teacher;
import com.yanzhuang.serviceimpl.LoginServiceImpl;
import com.yanzhuang.serviceimpl.TeacherServiceImpl;

/**
 * Servlet implementation class teacherregister
 */
@WebServlet("/teacherregister")
public class teacherregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacherregister() {
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
		Teacher teacher=new Teacher();
		teacher.setTeacherid(request.getParameter("teacherid"));
		teacher.setTeachername(request.getParameter("teachername"));
		teacher.setPwd(request.getParameter("pwd"));
		teacher.setProfessionid(request.getParameter("professionid"));
		teacher.setRole(2);
		TeacherServiceImpl tsi=new TeacherServiceImpl();
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		System.out.println("*afdafa");
		boolean token=tsi.saveTeacher(teacher);
		if(token)
		{
			out.write("teacherregister success");
		}else
		{
			out.write("teacherregister fail");
		}
		Login loginteacher=new Login(request.getParameter("teacherid"),request.getParameter("pwd"),2,0);
		LoginServiceImpl lsi=new LoginServiceImpl();
		lsi.saveLogin(loginteacher);
	}

}
