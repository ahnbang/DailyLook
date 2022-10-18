package com.ahnbang.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ahnbang.common.Result;
import com.ahnbang.member.bo.MemberBO;


@RequestMapping("/member")
@RestController
public class MemberRestController {
	
	@Autowired
	private MemberBO memberBO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping("/sign_up")
	public String signUp(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("email") String email) {
		
		String encodredPassword = passwordEncoder.encode(password);
		int result = memberBO.createMember(loginId,encodredPassword, name, email);
				
		Result<String> resultes = new Result<>();
		resultes.setStatusCode(result);

		return resultes.toString();
	}
	

}
