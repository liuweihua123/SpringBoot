package com.how2java.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.springboot.mapper.BookMapper;
import com.how2java.springboot.pojo.Book;

@Controller
public class BookController {

	@Autowired
	BookMapper bookMapper;
	@RequestMapping("/showBooks")	
	public String showBook(Model model,@RequestParam(value="start",defaultValue="0") int start,
			@RequestParam(value="size",defaultValue="5") int size){	
		PageHelper.startPage(start, size, "id desc");
		List<Book> list=bookMapper.showAllBook();
		PageInfo<Book> page=new PageInfo<>(list);
		model.addAttribute("page", page);
		return "showBooks";	
	}

	@RequestMapping("/addBook")
	public String addBook(Book book){
		if (book.getBookname().equals("")) {
			return "errorPage";
		} else {
			bookMapper.insertBook(book);
			return "redirect:showBooks";
		}
	}
	@RequestMapping("/deleteBook")
	public String deleteBook(int id){
		bookMapper.deleteBook(id);
		return "redirect:showBooks";
	}
	@RequestMapping("/updateBook")
	public String updateBook(Book book){
		bookMapper.updateBook(book);
		return "redirect:showBooks";
	}
	@RequestMapping("/editBook")
	public String editBook(int id,Model model){
		Book book=bookMapper.getBook(id);
		model.addAttribute("b", book);
		return "editBook";
	}
	/*
	 * Json数据传输
	 * 
	@RequestMapping("/addBook")
	@ResponseBody
	public JsonData addBook(Book book){
		if (book.getBookname().equals("")) {
			return JsonData.fail("书名不能为空!");
		} else {
			int a=bookMapper.insertBook(book);
			return a>0?JsonData.success():JsonData.fail("error");
		}	
	}
	*/
	
}
