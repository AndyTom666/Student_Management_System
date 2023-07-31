package com.yanzhuang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yanzhuang.po.Login;
import com.yanzhuang.po.Teacher;
import com.yanzhuang.serviceimpl.TeacherServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class teachersession
 */
@WebServlet("/teachersession")
public class teachersession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teachersession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TeacherServiceImpl tsi=new TeacherServiceImpl();
		PrintWriter  out=response.getWriter();
        HttpSession session=request.getSession();
        Login log=(Login)session.getAttribute("log");
        String stuid=log.getStuid();
        System.out.println(stuid);
        List<Object> lists=tsi.querySelectedUser(stuid);
        Teacher teacher=(Teacher)lists.get(0);
        System.out.println(teacher);
        JSONObject  json=JSONObject.fromObject(teacher);
        out.write(json.toString());
        System.out.println(json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
