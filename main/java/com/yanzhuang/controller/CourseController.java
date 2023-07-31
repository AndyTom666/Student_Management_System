package com.yanzhuang.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import com.yanzhuang.po.Course;
import com.yanzhuang.po.Page;
import com.yanzhuang.po.Storage;
import com.yanzhuang.service.CourseService;

import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CourseController {
	private Page pi=new Page();
	private String tablename="course";
	private Storage storage=Storage.getStorage();
	@Resource
	private CourseService csv;
	@RequestMapping("/getallcourse.do")
	@ResponseBody
	public List<Object> getAllCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//CourseService cs=new CourseServiceImpl();
		List<Object> lists = csv.queryAll();
		if (lists != null) {
			// HttpSession session=request.getSession();
			// session.setAttribute("info", lists);
			return lists;
		}
		return null;

	}
	@RequestMapping("/getcoursepageinfo.do")
	@ResponseBody
	public List<Object> getPageInfo(int pagenum,HttpServletRequest request, HttpServletResponse response)  {
		
		
		int tuple=5;
		
		if(pi.getHm().get(tablename)==null)
		{
			int totalinfo=csv.getCount();
			List<Object> lists = csv.queryAll();
			pi=new Page(totalinfo,tuple,lists,tablename);
			/*pi.setTotalinfo(totalinfo);
			pi.setTuple(tuple);
			//pi.setPagenum(pagenum);
			pi.setRows(lists);
			pi.setTablename(tablename);*/
			pi.put(tablename);
			storage.put(pi.uuid, pi);
			System.out.println("啥也没有就新建一个数据");
		}
		else
		{
			pi=storage.get(pi.getHm().get(tablename));
			System.out.println("数据中心有就直接拿了");
		}
		
		//Page pi=new Page(totalinfo,tuple,pagenum,lists,"stumarkinfo");
		
		System.out.println(pi.uuid);
		
		return pi.getInfo(tablename,pagenum);
	}
	
	@RequestMapping("/deletecourse.do")
	@ResponseBody
	public String deleteCourse(String courseid, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		//CourseService csv=new CourseServiceImpl();
		boolean token = csv.deleteCourse(courseid);
		if (token) {
			return "yes";
		}
		return "no";

	}
	@RequestMapping("/getupdatecourse.do")
	@ResponseBody
	public JSONObject getUpdateCourse(String courseid, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//CourseService csv = new CourseServiceImpl();
		List<Object> lists = csv.querySelectedCourse(courseid);
		if (lists != null) {
			Course cs = (Course) lists.get(0);
			JSONObject json = JSONObject.fromObject(cs);
			return json;
		}
		return null;

	}
	@RequestMapping("/courseupdate.do")
	@ResponseBody
	public String UpdateCourse(Course course, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//CourseService csv=new CourseServiceImpl();
		boolean token = csv.updateAccount(course);
		if (token) {
			return "yes";
		}
		return "no";
	}
	@RequestMapping("/courseregister.do")
	@ResponseBody
	public void CourseRegister(Course course, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//CourseServiceImpl csi = new CourseServiceImpl();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		// System.out.println(stuid+"*"+pwd);
		boolean token = csv.saveCourse(course);
		if (token) {
			out.write("yes");
		} else {
			out.write("no");
		}
	}
	@RequestMapping("/getratio.do")
	@ResponseBody
	public Double GetRatio(String courseid, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//CourseService csv = new CourseServiceImpl();
		System.out.println(courseid);
		List<Object> lists = csv.querySelectedCourse(courseid);
		Course course = (Course) lists.get(0);
		if (course == null) {
			return null;
		} else {
			System.out.println(course);
			return course.getRatio();
		}
	}
	@RequestMapping("/getcourseid1.do")
	@ResponseBody
	public List<Object> getCourseid1()
	{
		//CourseService ss=new CourseServiceImpl();
		return csv.queryAll();
	}

}
