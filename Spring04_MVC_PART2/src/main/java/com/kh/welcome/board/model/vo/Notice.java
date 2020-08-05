package com.kh.welcome.board.model.vo;

public class Notice {
	
	private int nIdx;
	private String userId;
	private String regDate;
	private String title;
	private String content;
	private String save_Path;
	
	public String getSave_Path() {
		return save_Path;
	}

	public void setSave_Path(String save_Path) {
		this.save_Path = save_Path;
	}

	public int getnIdx() {
		return nIdx;
	}
	
	public void setnIdx(int nIdx) {
		this.nIdx = nIdx;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getRegDate() {
		return regDate;
	}
	
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Notice [nIdx=" + nIdx + ", userId=" + userId + ", regDate=" + regDate + ", title=" + title
				+ ", content=" + content + ", save_Path=" + save_Path + "]";
	}
	

}
