package com.yanzhuang.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yanzhuang.serviceimpl.LoginServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yanzhuang.http.Studentwai;
import com.yanzhuang.po.Login;
import com.yanzhuang.po.Page;
import com.yanzhuang.po.Storage;
import com.yanzhuang.po.Student;
import com.yanzhuang.service.LoginService;
import com.yanzhuang.service.StuMarkInfoService;
import com.yanzhuang.service.StudentService;
import com.yanzhuang.util.AccountPoolManager;
import com.yanzhuang.util.StuidPoolManager;

import net.sf.json.JSONObject;

@Controller
public class StudentController {
	private Page pi=new Page();
	private String tablename="student";
	private Storage storage=Storage.getStorage();
	@Resource
	private StudentService ssi ;//= new StudentServiceImpl();
	@Resource
	private StuMarkInfoService sms;
	@Resource
	private LoginService lsi;
	@RequestMapping("/studentregister.do")
	@ResponseBody
	public void StudentRegister(Student stu, HttpServletRequest request, HttpServletResponse response,HttpSession session)
			throws IOException {
		stu.setRole(1);
		Calendar calendar= Calendar.getInstance();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(dateFormat.format(calendar.getTime()));
		stu.setDate(dateFormat.format(calendar.getTime()));
		StuidPoolManager spm=new StuidPoolManager();
		PrintWriter out = response.getWriter();
		// System.out.println(stuid+"*"+pwd);
		boolean token = ssi.saveStudent(stu);
		
		if (token) {
			spm.removeStuid(session.getId());
			out.write("yes");
		} else {
			out.write("no");
		}
		Login loginstudent = new Login(request.getParameter("stuid"), request.getParameter("pwd"), 1, 0);
		//LoginServiceImpl lsi = new LoginServiceImpl();
		lsi.saveLogin(loginstudent);

	}
	@RequestMapping("/studentsession.do")
	@ResponseBody
	public Student StudentSession(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException {
		//TeacherServiceImpl tsi = new TeacherServiceImpl();
		AccountPoolManager apm=new AccountPoolManager();
		Login log = (Login) session.getAttribute("log");
		if(log==null) return null;
		String stuid = log.getStuid();
		System.out.println(stuid);
		Student student = ssi.querySelectedStudent(stuid);
		if(student==null)
		{
			student=  ssi.querySelectedUser(stuid);

		}
		String idnum=student.getIdnum();
		if(idnum==null||"".equals(idnum)) 
			{
			student.setAge(0);
			}
		else{
			String year=idnum.substring(6,10);
			Calendar calendar=Calendar.getInstance();
			int now = calendar.get(Calendar.YEAR);
			int age=now-Integer.parseInt(year);
			student.setAge(age);
		}
		
		apm.checkDuplicateStuid(stuid, session);
		return student;
	}
	/*@RequestMapping("/studentwai.do")
	@ResponseBody
	public String StudentWai(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Student stu=new Student();
		HttpTest ht=new HttpTest();
		String url="http://192.168.1.118:8080/webStudent/view";
		Object[] objs =ht.getOut(url);
		System.out.println(objs.toString());
		int count=0;
		for (Object object : objs) {
			Studentwai stuw=(Studentwai) object;
			stu.setStuid(stuw.getSno());
			stu.setStuname(stuw.getSname());
			stu.setIdnum(stuw.getIdnum());
			stu.setNote(stuw.getNote());
			stu.setPwd(stuw.getPwd());
			stu.setProfessionid("p03");
			stu.setRole(1);
			stu.setDate("12");
			stu.setSex(1);
			stu.setIdnum("321123197311280829");
			stu.setTotalscore(50);
			stu.setPhoto("12");
			stu.setNote("12");
			ssi.saveStudent(stu);
			count++;
		}
		if(objs.length!=count) 
			{
			return "no";
			}
		return "yes";
		
		
	}*/
	@RequestMapping("/getallstudent.do")
	@ResponseBody
	public List<Object> getAllStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//StudentService stuservice = new StudentServiceImpl();
		
		List<Object> lists = ssi.queryAll();

		if (lists != null) {
			// HttpSession session=request.getSession();
			// session.setAttribute("info", lists);
			for(int i=0;i<lists.size();i++){
				Student stu=(Student)lists.remove(0);
				String idnum=stu.getIdnum();
				if(idnum==null||"".equals(idnum)) 
					{
					stu.setAge(0);
					}
				else{
					String year=idnum.substring(6,10);
					Calendar calendar=Calendar.getInstance();
					int now = calendar.get(Calendar.YEAR);
					int age=now-Integer.parseInt(year);
					stu.setAge(age);
				}
				lists.add(stu);
			}
			
			return lists;

	}
		return null;
	}
	@RequestMapping("/getstudentpage.do")
	@ResponseBody
	public Page getPage(HttpServletRequest request, HttpServletResponse response)  {
		return pi;
	}
	@RequestMapping("/getstudentpageinfo.do")
	@ResponseBody
	public List<Object> getStudentPageInfo(int pagenum,HttpServletRequest request, HttpServletResponse response)  {
		
		
		int tuple=10;
		
		if(pi.getHm().get(tablename)==null)
		{
			int totalinfo=ssi.getCount();
			List<Object> lists = ssi.queryAll();
			System.out.println(lists);
			pi=new Page(totalinfo,tuple,lists,tablename);

			/*pi.setTotalinfo(totalinfo);
			pi.setTuple(tuple);
			pi.setPagenum(pagenum);
			pi.setRows(lists);
			pi.setTablename(tablename);*/

			pi.put(tablename);
			storage.put(pi.uuid, pi);
			System.out.println("啥也没有就新建一个数据"+pi.getPagenum());
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
	
	/*@RequestMapping("/getpage.do")
	@ResponseBody
	public PageInfo getPage(HttpServletRequest request, HttpServletResponse response)  {
		int totalinfo=ssi.getCount();
		int tuple=10;
		PageInfo pi=new PageInfo(totalinfo,tuple);
		return pi;
	}*/
	@RequestMapping("/getstudentbyprofession.do")
	@ResponseBody
	public List getStudentByProfession(String professionid,HttpServletRequest request, HttpServletResponse response) throws IOException {
		//StudentService stuservice = new StudentServiceImpl();
		List<Object> lists = ssi.queryAllByProfessionid(professionid);
		if (lists != null) {
			// HttpSession session=request.getSession();
			// session.setAttribute("info", lists);
			return lists;
		}
		return null;

	}
	@RequestMapping("/deletestudent.do")
	@ResponseBody
	public String deleteStudent(String stuid, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		//StudentServiceImpl stuservice = new StudentServiceImpl();
		//System.out.println(stuid);
		boolean token = ssi.deleteAccount(stuid);
		System.out.println(token);
		if (token) {
			return "yes";
		}
		return "no";

	}
	@RequestMapping("/studentupdate.do")
	@ResponseBody
	public String UpdateStudent(Student stu, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//StudentServiceImpl ss = new StudentServiceImpl();
		boolean token = ssi.updateAccount(stu);
		if (token) {
			return "yes";
		}
		return "no";
	}
	@RequestMapping("/getnewstuid.do")
	@ResponseBody
	public String GetNewStuid(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		StuidPoolManager spm=new StuidPoolManager();
		//StudentServiceImpl ssi=new StudentServiceImpl();
		if(StuidPoolManager.max==-1)
		{
			StuidPoolManager.max=ssi.getMaxStuid();
		}
		//PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		return spm.getStuid(session.getId());
		
	}
	@RequestMapping("/getvaguestudent.do")
	@ResponseBody
	public List<Object> getVagueStudent(String stuname,HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		//StudentService stuservice = new StudentServiceImpl();
		List<Object> lists = ssi.queryVagueUser(stuname);
		System.out.println(lists.get(0));
		// HttpSession session=request.getSession();
		// session.setAttribute("info", lists);
			return lists;

	}
	@RequestMapping("/getstuid1.do")
	@ResponseBody
	public List<Object> getStuid1()
	{
		//StudentService ss=new StudentServiceImpl();
		return ssi.queryAll();
	}
	@RequestMapping("/getupdatestudent.do")
	@ResponseBody
	public void getUpdateStudent(String stuid, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//StudentService stuservice = new StudentServiceImpl();
		Student stu = ssi.querySelectedUser(stuid);
		PrintWriter out = response.getWriter();
		if (stu != null) {
			System.out.println(stu);
			JSONObject json = JSONObject.fromObject(stu);
			out.write(json.toString());
			System.out.println(json.toString());
		}

	}

}
