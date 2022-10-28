package com.ahnbang.image.model;

import java.util.Date;

public class Image {
	
	private int image_id;
	private int board_id;
	private String main_or_sub;
	private String original_name;
	private String save_name;
	private int size;
	private String delated;
	private Date createdAt;
	private Date updatedAt;
	
	
	public int getImage_id() {
		return image_id;
	}
	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getMain_or_sub() {
		return main_or_sub;
	}
	public void setMain_or_sub(String main_or_sub) {
		this.main_or_sub = main_or_sub;
	}
	public String getOriginal_name() {
		return original_name;
	}
	public void setOriginal_name(String original_name) {
		this.original_name = original_name;
	}
	public String getSave_name() {
		return save_name;
	}
	public void setSave_name(String save_name) {
		this.save_name = save_name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
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
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
}
