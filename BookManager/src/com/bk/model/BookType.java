package com.bk.model;

//图书类型实体

public class BookType {

	private int id;//编号
	private String bookTypeName;//图书类型名
	private String bookTypeDesc;//图书类型描述
	
	public BookType() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public BookType(String bookTypeName, String bookTypeDesc) {
		super();
		
		this.bookTypeName = bookTypeName;
		this.bookTypeDesc = bookTypeDesc;
	}
	

	public BookType(int id, String bookTypeName, String bookTypeDesc) {
		super();
		this.id = id;
		this.bookTypeName = bookTypeName;
		this.bookTypeDesc = bookTypeDesc;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public String getBookTypeDesc() {
		return bookTypeDesc;
	}
	public void setBookTypeDesc(String bookTypeDesc) {
		this.bookTypeDesc = bookTypeDesc;
	}

	@Override
	public String toString() {
		return bookTypeName;
	}
	
}
