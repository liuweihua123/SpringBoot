package com.how2java.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.how2java.springboot.pojo.Book;

@Mapper
public interface BookMapper {

	
	@Select("select * from book")
	public List<Book> showAllBook();
	
	@Select("select * from book where id=#{id}")
	public Book getBook(int id);
	
	@Update("update book set bookname=#{bookname},price=#{price} where id=#{id}")
	public int updateBook(Book book);
	
	@Delete("delete from book where id=#{id}")
	public void deleteBook(int id);
	
	@Insert("insert into book(bookname,price) values(#{bookname},#{price})")
	public int insertBook(Book book);
	
}
