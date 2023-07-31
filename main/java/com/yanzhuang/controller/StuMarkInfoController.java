package com.yanzhuang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yanzhuang.po.Page;
import com.yanzhuang.po.PageInfo;
import com.yanzhuang.po.Storage;
import com.yanzhuang.po.StuMarkInfo;
import com.yanzhuang.service.StuMarkInfoService;
import com.yanzhuang.serviceimpl.StuMarkInfoServiceImpl;
import com.yanzhuang.util.MarkidPoolManager;
import com.yanzhuang.util.StuidPoolManager;

import net.sf.json.JSONObject;
@Controller
public class StuMarkInfoController {
	private Page pi=new Page();
	private String tablename="stumarkinfo";
	private Storage storage=Storage.getStorage();
	private MarkidPoolManager mpm=new MarkidPoolManager();
	@Resource
	StuMarkInfoService stuservice ;//= new StuMarkInfoServiceImpl();
	@RequestMapping("/deletemany.do")
	@ResponseBody
	public String deleteMany(String[] tobedelete, HttpServletRequest request, HttpServletResponse response,HttpSession session)
			throws IOException {

		//StuMarkInfoService stuservice = new StuMarkInfoServiceImpl();
		System.out.println(tobedelete);
		boolean token = stuservice.deleteMany(tobedelete);
		System.out.println(token);
		if (token) {
			if(pi.getHm().get(tablename)!=null){
			storage.remove(pi.getHm().get(tablename));
			pi.remove(tablename);
			}
			mpm.removeStuid(session.getId());
			return "yes";
		}
		return "no";

	}
	@RequestMapping("/deletestumarkinfo.do")
	@ResponseBody
	public String deleteStuMarkinfo(String markid, HttpServletRequest request, HttpServletResponse response,HttpSession session)
			throws IOException {

		//StuMarkInfoService stuservice = new StuMarkInfoServiceImpl();
		System.out.println(markid);
		boolean token = stuservice.deleteStuMarkInfo(markid);
		System.out.println(token);
		if (token) {
			if(pi.getHm().get(tablename)!=null){
			storage.remove(pi.getHm().get(tablename));
			pi.remove(tablename);
			}
			mpm.removeStuid(session.getId());
			return "yes";
		}
		return "no";

	}
	@RequestMapping("/getselectedcourse.do")
	@ResponseBody
	public List<Object> getSelectedCourse(String stuid)  {

		return stuservice.getSelectedCourse(stuid);
	}

	@RequestMapping("/getstumarkinfopage.do")
	@ResponseBody
	public Page getPage(HttpServletRequest request, HttpServletResponse response)  {
		return pi;
	}

	@RequestMapping("/getpageinfo.do")
	@ResponseBody
	public List<Object> getPageInfo(int pagenum,HttpServletRequest request, HttpServletResponse response)  {
		
		
		int tuple=10;
		
		if(pi.getHm().get(tablename)==null)
		{
			int totalinfo=stuservice.getCount();
			List<Object> lists = stuservice.queryAll();
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
	@RequestMapping("/getupdatestumarkinfo.do")
	@ResponseBody
	public void getUpdateStuMarkInfo(String markid, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//StuMarkInfoService stuservice = new StuMarkInfoServiceImpl();
		List<Object> lists = stuservice.querySelectedStuMarkInfo(markid);
		PrintWriter out = response.getWriter();
		if (lists != null) {
			StuMarkInfo stu = (StuMarkInfo) lists.get(0);
			System.out.println(stu);
			JSONObject json = JSONObject.fromObject(stu);
			out.write(json.toString());
			System.out.println(json.toString());
		}

	}
	@RequestMapping("/stumarkinfotupdate.do")
	@ResponseBody
	public String UpdateStudent(StuMarkInfo stu, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//StuMarkInfoService sis=new StuMarkInfoServiceImpl();
		System.out.println(stu);
		boolean token = stuservice.updateStuMarkInfo(stu);
		if (token) {
			if(pi.getHm().get(tablename)!=null){
			storage.remove(pi.getHm().get(tablename));
			pi.remove(tablename);
			}
			return "yes";
		}
		return "no";
	}
	@RequestMapping("/stumarkinforegister.do")
	@ResponseBody
	public String StumarkinfoRegister(StuMarkInfo stumarkinfo, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		System.out.println(stumarkinfo);
		//StuMarkInfoServiceImpl smis = new StuMarkInfoServiceImpl();
		boolean token = stuservice.saveStuMarkInfo(stumarkinfo);
		if (token) {
			if(pi.getHm().get(tablename)!=null){
			storage.remove(pi.getHm().get(tablename));
			pi.remove(tablename);
			}
			return "yes";
		} else {
			return "no";
		}
	}
	@RequestMapping("/getallstumarkinfo.do")
	@ResponseBody
	public List getAllStumarkinfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//StuMarkInfoService smis = new StuMarkInfoServiceImpl(); 
		List<Object> lists = stuservice.queryAll();
		if (lists != null) {
			// HttpSession session=request.getSession();
			// session.setAttribute("info", lists);
			return lists;
		}
		return null;
}
	@RequestMapping("/calculatetotalscore.do")
	@ResponseBody
	public String calculateTotalScore(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//StuMarkInfoService smi=new StuMarkInfoServiceImpl();
		if(stuservice.getTotalScore())
			return "yes";
		return "no";
		

	}
	@RequestMapping("/getnewmarkid.do")
	@ResponseBody
	public String GetNewMarkid(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		MarkidPoolManager mpm=new MarkidPoolManager();
		//StuMarkInfoService smis=new StuMarkInfoServiceImpl();
		if(MarkidPoolManager.max==-1)
		{
			MarkidPoolManager.max=stuservice.getMaxMarkid();
			System.out.println(StuidPoolManager.max);
		}

		//PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		//System.out.println(mpm.getMarkid(session.getId()));
		return mpm.getMarkid(session.getId());
		
	}

}
