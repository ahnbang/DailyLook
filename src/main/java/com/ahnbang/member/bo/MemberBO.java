package com.ahnbang.member.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ahnbang.member.dao.MemberDAO;

@Service
public class MemberBO {
	
	@Autowired
	private MemberDAO mebmerDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public int createMember(String loginId, String password, String name, String email) {

		return 1;
		
	}
	
	

}
