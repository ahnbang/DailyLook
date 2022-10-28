package com.ahnbang.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ahnbang.common.FileManagerService;
import com.ahnbang.post.dao.PostDAO;

@Service
public class PostBO {
	
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private FileManagerService fileManager;
	
	public int addPost(int member_id, String title, String content, String category) {
		return postDAO.insertPost(member_id, title, content, category);
	}
	
	public void addImage(List<MultipartFile> images, int created_board_id) {
		postDAO.insertImage(images, created_board_id);
	}
	
}
