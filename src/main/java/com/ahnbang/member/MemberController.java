package com.ahnbang.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahnbang.common.response.Response;
import com.ahnbang.common.response.ResponseUtil;
import com.ahnbang.member.bo.MemberBO;
import com.ahnbang.member.model.Member;
import com.ahnbang.member.model.MemberRole;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberBO memberBO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	// 회원가입 view
	@RequestMapping("/sign_up_view")
	public String signUpView(){
		return "/member/sign_up_in";
	}
	
	// 회원가입 
	@RequestMapping("/sign_up")
	@ResponseBody
	public Response sign_up(
			@RequestParam("loginid") String loginid,
			@RequestParam("name") String name,
			@RequestParam("password") String password,
			@RequestParam("email") String email){
		
		String encodedPassword = passwordEncoder.encode(password);
		String role = MemberRole.USER.toString();
		int row = memberBO.insertMember(loginid, name, encodedPassword, email, role);

		if(row == 1) {
			return ResponseUtil.SUCCESS("회원가입에 성공했습니다. 로그인을 해주세요", encodedPassword);
		}
		else
			return ResponseUtil.FAIL("회원가입에 실패했습니다. 관리자에게 문의 부탁드립니다.", row);
	}
	
	// 아이디 중복 검사 
	@RequestMapping("/is_id_duplicated")
	@ResponseBody
	public Response isIdDuplicated(@RequestParam("loginid") String loginid) {
		
		int row = memberBO.existLoginId(loginid);
		if (row > 0) {
			return ResponseUtil.FAIL("이미 존재하는 아이디입니다.", row);
		}
		else
			return ResponseUtil.SUCCESS("사용가능한 아이디입니다.", row);
	}
	
	@RequestMapping("/sign_in_view")
	public String signInView() {
		return "/member/sign_up_in";	
	}
	
	// 로그인
	@RequestMapping("/sign_in")
	@ResponseBody
	public Response sign_in(
			@RequestParam("loginid_login") String loginid_login,
			@RequestParam("password_login") String password_login,
			HttpSession session) {
		
		/*
		Member member = memberBO.getMemberByLoginId(loginid_login);

		return ResponseUtil.FAIL("테스트입니다", member);
		*/
		
		Member member = memberBO.getMemberByLoginId(loginid_login);
		
		if (member != null) {
			
			String encodedPassword  = memberBO.getPasswordByLoginId(loginid_login);
			
			if(passwordEncoder.matches(password_login, encodedPassword)) {
				session.setAttribute("loginid", member.getLoginid());
				session.setAttribute("name", member.getName());
				session.setAttribute("member_id", member.getMember_id());
				return ResponseUtil.SUCCESS("로그인에성공했습니다.", member); 	
			}
			
			else {
				return ResponseUtil.FAIL("비밀번호가 일치하지 않습니다.", password_login + "+테스트용 데이터 출력+" + encodedPassword);
				}
		}else {
			return ResponseUtil.FAIL("일치하는 아이디가 없습니다", loginid_login);
		}
		
		
		
		
	
	}
}
