package com.ahnbang.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ahnbang.member.bo.MemberBO;
import com.ahnbang.member.model.Member;

public class PasswordMatchTest {
	@Autowired
	private MemberBO memberBO;
	@Autowired
	private PasswordEncoder passwordEncoder;

@Test
@DisplayName("패스워드 매칭 테스트")
void passwordEncode() {

	// given
   String loginid = "test9";
   String realpassword = "test9";
   String password = passwordEncoder.encode("test9");
   String email = "test9";
   String name = "test9";
   String role = "USER";
   
   Member member = new Member();
   member.setLoginid(loginid);
   member.setPawssword(password);
   member.setEmail(email);
   member.setName(name);
   member.setRole_type(role);
  

   

   // when
   Member member2 = memberBO.getMemberByLoginId(loginid);
   String encodedPassword = passwordEncoder.encode(member2.getPawssword());
   
   

   // then
   assertAll(
         () -> assertNotEquals(password, encodedPassword),
         () -> assertTrue(passwordEncoder.matches(password, encodedPassword))
   );
}
}
