package com.ahnbang;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahnbang.common.response.Response;
import com.ahnbang.common.response.ResponseUtil;

@Controller
public class TestController {
	@RequestMapping("/")
	public String test() {		
		return "/post/postupload"; 
	}
	
	
	@RequestMapping("/test")
	@ResponseBody
	public String test2() {
		Response result = ResponseUtil.SUCCESS("회원가입에 성공했습니다.", "success");
		return result.getData().toString(); 
	}


}
