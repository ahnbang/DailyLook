package com.ahnbang.post;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ahnbang.common.response.Response;
import com.ahnbang.common.response.ResponseUtil;
import com.ahnbang.post.bo.PostBO;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostBO postBO;
	
	@RequestMapping("/view")
	public String postView() {
		return "post/postupload";
	}
	
	@RequestMapping("/upload")
	@ResponseBody
	public Response postCreate(
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("category") String category,
			HttpSession session) {
		
		
		Integer member_id = (Integer) session.getAttribute("member_id");
		String loginid = (String) session.getAttribute("loginid");
		// spring security로 대체 해야할 부분
		/*
		if (member_id == null) {
			return  ResponseUtil.FAIL("비로그인 상태입니다", "member_id = " + member_id);
		}
		*/
		int created_board_id = postBO.addPost(member_id, title, content, category);
		//postBO.addImage(images, created_board_id);
		
		return  ResponseUtil.SUCCESS("작성이 완료되었습니다.", "member_id = " + member_id);
	}
	

}
