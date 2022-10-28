package com.ahnbang.board.model;

import java.util.Date;

import javax.xml.crypto.Data;

public class Board {
	
	private int board_id;
	private String title;
	private String content;
	private int member_id;
	private String category;
	private String delated;
	private Date createdAt;
	private Data updatedAt;
	
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
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
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDelated() {
		return delated;
	}
	public void setDelated(String delated) {
		this.delated = delated;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Data getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Data updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	

}
