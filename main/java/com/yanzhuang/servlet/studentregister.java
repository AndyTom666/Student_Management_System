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
import com.yanzhuang.po.Student;
import com.yanzhuang.serviceimpl.LoginServiceImpl;
import com.yanzhuang.serviceimpl.StudentServiceImpl;

/**
 * Servlet implementation class studentregister
 */
@WebServlet("/studentregister")
public class studentregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentregister() {
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
		Student stu=new Student();
/*		stu.setStuid(request.getParameter("stuid"));
		String stuid=request.getParameter("stuid");
		String stuname=request.getParameter("stuname");
		String pwd=request.getParameter("pwd");
		String professionid=request.getParameter("professionid");
		String date=request.getParameter("date");
		String sex=request.getParameter("sex");
		String idnum=request.getParameter("idnum");
		String totalscore=request.getParameter("totalscore");
		String photo=request.getParameter("photo");
		String note=request.getParameter("note");*/
		System.out.println(request.getParameter("stuname"));
		stu.setStuid(request.getParameter("stuid"));
		stu.setStuname(request.getParameter("stuname"));
		stu.setPwd(request.getParameter("pwd"));
		stu.setProfessionid(request.getParameter("professionid"));
		stu.setDate(request.getParameter("date"));
		stu.setRole(1);
		stu.setSex(Integer.parseInt(request.getParameter("sex")));
		stu.setIdnum(request.getParameter("idnum"));
		stu.setTotalscore(Integer.parseInt(request.getParameter("totalscore")));
		stu.setPhoto(request.getParameter("photo"));
		stu.setNote(request.getParameter("note"));
		StudentServiceImpl ssi=new StudentServiceImpl();
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		//System.out.println(stuid+"*"+pwd);
		boolean token=ssi.saveStudent(stu);
		if(token)
		{
			out.write("studentregister success");
		}else
		{
			out.write("studentregister fail");
		}
		Login loginstudent=new Login(request.getParameter("stuid"),request.getParameter("pwd"),1,0);
		LoginServiceImpl lsi=new LoginServiceImpl();
		lsi.saveLogin(loginstudent);
		
		//session.setAttribute("registeredstu", stu);
	}

}
