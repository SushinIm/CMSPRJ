package com.cmsprj.vos;

public class MemberVo {
	private int user_no;
	private String user_id;
	private String password;
	private String user_nm;
	private int right_no;
	
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_nm() {
		return user_nm;
	}
	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}
	public int getRight_no() {
		return right_no;
	}
	public void setRight_no(int right_no) {
		this.right_no = right_no;
	}
	
	@Override
	public String toString() {
		return "MemberVo [user_no="+user_no+", user_id="+user_id+", password="+password+", user_nm="+user_nm+", right_no="+right_no+"]";
	}
}
