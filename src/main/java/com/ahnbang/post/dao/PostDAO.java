package com.ahnbang.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface PostDAO {
		
	public int insertPost(
			@Param("member_id") int member_id
			,@Param("title") String title
			,@Param("content") String content
			,@Param("category") String category);
	
	
	public void insertImage(
			@Param("images") List<MultipartFile> images
			,@Param("created_board_id") int created_board_id);
}
