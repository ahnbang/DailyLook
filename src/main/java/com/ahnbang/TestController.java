package com.ahnbang;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahnbang.common.Result;

@RestController

public class TestController {
	@RequestMapping("/")
	public String test() {
		
		Result<String> resultes = new Result<>();
		resultes.setStatusCode(5);
		resultes.setData("yes");
		

		return resultes.getData();
	

	}
	

}
