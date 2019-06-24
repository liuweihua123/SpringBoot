package com.how2java.springboot.pojo;

public class Book {

	private int id;
	private String bookname;
	private float price;
	public int getId() {
		return id;
	}
	public String getBookname() {
		return bookname;
	}
	public float getPrice() {
		return price;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
