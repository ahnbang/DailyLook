package com.ahnbang.member.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahnbang.member.dao.MemberDAO;
import com.ahnbang.member.model.Member;

@Service
public class MemberBO {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public int existLoginId(String loginid) {
		return memberDAO.existLoginId(loginid);
	}
	
	public int insertMember(String loginid, String name, String password, String email, String role){
		return memberDAO.insertMember(loginid, name, password, email, role);
	}
	
	public Member getMemberByLoginId(String loginid) {
		return memberDAO.selectMemberByLoginId(loginid);
	}
	
	public List<Member> getMemberList(){
		return memberDAO.selectMemberList();
	}
	
	public Member getMemberById(int member_id) {
		return memberDAO.selectMemberById(member_id);
	}
	
	public String getPasswordByLoginId (String loginid) {
		return memberDAO.selectPasswordByLoginId(loginid);
	}

}
