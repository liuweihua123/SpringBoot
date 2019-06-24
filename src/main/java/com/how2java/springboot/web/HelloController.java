package com.how2java.springboot.web;
import java.text.DateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class HelloController {
 
    @SuppressWarnings("unused")
	@RequestMapping("/hello")
    public String hello(Model m) throws Exception {
    	m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
    	if(true){
    		throw new Exception("some exception");
    	}
        return "hello";
    }
    

    
    
}
