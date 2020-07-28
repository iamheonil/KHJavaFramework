package com.kh.welcome.member.model.vo;
import java.sql.Date;
public class Member {
	
	private String userId;
	private String password;
	private String email;
	private String tel;
	private Date regDate;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTell() {
		return tel;
	}
	public void setTell(String tel) {
		this.tel = tel;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Member [userId=" + userId + ", password=" + password + ", email=" + email + ", tel=" + tel
				+ ", regDate=" + regDate + "]";
	}
	
	

}



