package com.how2java.springboot.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class UploadController {

	
	@RequestMapping("/uploadPage")
	public String uploadPage(){
		return "uploadPage";
	}
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String upload(HttpServletRequest request,@RequestParam("file") MultipartFile file,Model model){
		
		try {
			String filename=System.currentTimeMillis()+file.getOriginalFilename();
			String destFilename=request.getServletContext().getRealPath("")+"uploaded"+File.separator+filename;
			File destFile=new File(destFilename);
			destFile.getParentFile().mkdirs();
			file.transferTo(destFile);
			model.addAttribute("fileName", filename);	
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "上传失败，"+e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "上传失败，"+e.getMessage();
		}
		return "showImg";
		
	}
	
}
