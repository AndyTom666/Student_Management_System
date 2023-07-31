package com.yanzhuang.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file/")
public class FileUpLoadController {

	@RequestMapping("upload.do")  // /file/upload.do
	@ResponseBody
	public String upload(@RequestParam(value = "file", required = true) MultipartFile file,HttpServletRequest request) {

		String  url="upload"+File.separator;
		// url为相对路径
	
		String path = request.getSession().getServletContext()
				.getRealPath(File.separator+"upload"+File.separator);
		System.out.println("绝对" + path);
		//path存放绝对路径
		
		
		SimpleDateFormat  stFormat=new SimpleDateFormat("yyyymmddhhMMSS");
		String newfileName=stFormat.format(new Date());
		
		SimpleDateFormat  stFormat1=new SimpleDateFormat("yyyy");
		String year=stFormat1.format(new Date());
		//按年份建立目录
		url+=year+File.separator;
		
		path+=File.separator+year;
		
		//测试绝对路径的目录是否存在，不存在，则建立对应目录;
		File file2=new File(path);
		if(!file2.exists())
			  file2.mkdirs();
		
		/*
		 * 接下来代码是复制文件，进行实质的保存；
		 */

		//得到原始的上传文件的文件名（包含后缀）
		String fileName = file.getOriginalFilename();
		System.out.println("fileName:" + fileName);
		//获得新文件的文件名，添加后缀
        newfileName+=fileName.substring(fileName.lastIndexOf("."), fileName.length());
        System.out.println("newfileName:" + newfileName);
		url+=newfileName;
		
		// 在磁盘建立文件进行
		File targetFile = new File(path, newfileName);
	   try {
			//文件复制
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		//String url = request.getContextPath() + "/upload/" + newfileName;
	   	System.out.println("相对" + url);  
		//model.addAttribute("url", url);
		//model.addAttribute("filename", fileName);
		return url;
	}
  
		
	@RequestMapping("downLoad.do")
	public ResponseEntity<byte[]> download(HttpServletRequest request,String fileID) throws IOException {  
		 HttpHeaders headers = new HttpHeaders();  
		 headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);  
		
		 headers.setContentDispositionFormData("attachment", "ss.java");
		 
		 String path = request.getSession().getServletContext()
					.getRealPath("//upload//");
		 
		  File file=new File(path+"/2019/201939280207603.java");
		  
		return new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file),
		           headers, HttpStatus.CREATED);  
	}
	
}
