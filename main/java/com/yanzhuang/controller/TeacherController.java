package com.yanzhuang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yanzhuang.util.StuidPoolManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yanzhuang.po.Login;
import com.yanzhuang.po.Teacher;
import com.yanzhuang.service.LoginService;
import com.yanzhuang.service.TeacherService;
import com.yanzhuang.serviceimpl.LoginServiceImpl;
import com.yanzhuang.serviceimpl.TeacherServiceImpl;
import com.yanzhuang.util.AccountPoolManager;
import com.yanzhuang.util.TeachidPoolManager;

import net.sf.json.JSONObject;
@Controller
public class TeacherController {
	private AccountPoolManager apm=new AccountPoolManager();
	boolean token=false;
	@Resource
	private TeacherService tsi;// = new TeacherServiceImpl();
	@Resource
	private LoginService lsi;// = new LoginServiceImpl();
	@RequestMapping("/teacherregister.do")
	@ResponseBody
	public void TeacherRegister(Teacher teacher, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		teacher.setRole(2);
		//TeacherServiceImpl tsi = new TeacherServiceImpl();

		PrintWriter out = response.getWriter();
		//HttpSession session = request.getSession();
		// System.out.println(stuid+"*"+pwd);
		boolean token = tsi.saveTeacher(teacher);
		if (token) {
			out.write("yes");
		} else {
			out.write("no");
		}
		Login loginteacher = new Login(request.getParameter("teacherid"), request.getParameter("pwd"), 2, 0);
		System.out.println(loginteacher.getStuid());
		//LoginServiceImpl lsi = new LoginServiceImpl();
		lsi.saveLogin(loginteacher);
	}

	@RequestMapping("/teachersession.do")
	@ResponseBody
	public void TeacherSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//TeacherServiceImpl tsi = new TeacherServiceImpl();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Login log = (Login) session.getAttribute("log");
		if(log==null) return;
		String stuid = log.getStuid();
		System.out.println(stuid);
		List<Object> lists = tsi.querySelectedUser(stuid);
		Teacher teacher = (Teacher) lists.get(0);
		token=apm.checkDuplicateStuid(stuid, session);
		//System.out.println(teacher);
		JSONObject json = JSONObject.fromObject(teacher);
		out.write(json.toString());
		System.out.println(json.toString());
	}
	@RequestMapping("/checkduplicatestuid.do")
	@ResponseBody
	public String CheckDuplicateStuid(String stuid,HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException 
	{
		
		if(token)
		{
			return "yes";
					
		}
		return "no";
	}

	
	@RequestMapping("/getallteacher.do")
	@ResponseBody
	public List<Object> getAllTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//TeacherService ts=new TeacherServiceImpl();
		List<Object> lists = tsi.queryAll();
		if (lists != null) {
			// HttpSession session=request.getSession();
			// session.setAttribute("info", lists);
			return lists;
		}
		return null;

	}
	@RequestMapping("/getnewteachid.do")
	@ResponseBody
	public String GetNewTeachid(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		TeachidPoolManager tpm=new TeachidPoolManager();
		if(TeachidPoolManager.max==-1)
		{
			TeachidPoolManager.max=tsi.getMaxTeachid();
		}
		//PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		return tpm.getTeachid(session.getId());

	}
	@RequestMapping("/deleteteacher.do")
	@ResponseBody
	public String deleteTeacher(String teacherid, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		//TeacherService ts=new TeacherServiceImpl();
		boolean token = tsi.deleteAccount(teacherid);
		if (token) {
			return "yes";
		}
		return "no";

	}
	@RequestMapping("/getupdateteacher.do")
	@ResponseBody
	public Teacher getUpdateTeacher(String teacherid, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//TeacherService ts=new TeacherServiceImpl();
		List<Object> lists = tsi.querySelectedUser(teacherid);
		if (lists != null) {
			Teacher cs = (Teacher) lists.get(0);
			//JSONObject json = JSONObject.fromObject(cs);
			return cs;
		}
		return null;

	}
	@RequestMapping("/teacherupdate.do")
	@ResponseBody
	public String UpdateTeacher(Teacher teacher, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//TeacherService ts=new TeacherServiceImpl();
		boolean token = tsi.updateAccount(teacher);
		if (token) {
			return "yes";
		}
		return "no";
	}


}
