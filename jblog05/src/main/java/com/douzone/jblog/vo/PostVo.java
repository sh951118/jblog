package com.douzone.jblog.vo;

public class PostVo {

	private Long no;
	private String title;
	private String contents;
	private String regdate;
	private int cartegoryno;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getCartegoryno() {
		return cartegoryno;
	}
	public void setCartegoryno(int cartegoryno) {
		this.cartegoryno = cartegoryno;
	}
	@Override
	public String toString() {
		return "PostVo [no=" + no + ", title=" + title + ", contents=" + contents + ", regdate=" + regdate
				+ ", cartegoryno=" + cartegoryno + "]";
	}
}
