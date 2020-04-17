package com.douzone.jblog.vo;

public class CartegoryVo {

	private long no;
	private String name;
	private String description;
	private String regdate;
	private int postcount;
	private String id;
	
	public CartegoryVo() {
		
	}
	public CartegoryVo(Long no, String name,String regdate,int postcount, String description, String id) {
		this.no = no;
		this.name = name;
		this.description = description;
		this.postcount = postcount;
		this.regdate = regdate;
		this.id = id;
	}
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getPostcount() {
		return postcount;
	}
	public void setPostcount(int postcount) {
		this.postcount = postcount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "CartegoryVo [no=" + no + ", name=" + name + ", description=" + description + ", regdate=" + regdate
				+ ", id=" + id + "]";
	}
}
