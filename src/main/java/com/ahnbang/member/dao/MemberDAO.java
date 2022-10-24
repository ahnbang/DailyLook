package com.ahnbang.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ahnbang.member.model.Member;

@Repository
public interface MemberDAO {
	
	public int insertMember(
			@Param("loginid") String loginid,
			@Param("name") String name,
			@Param("password") String password,
			@Param("email") String email,
			@Param("role") String role);
	
	
	public Member selectMemberByLoginId(
			@Param("loginid") String loginid);
	
	public List<Member> selectMemberList();
	
	public int existLoginId(String loginid);
	
	public Member selectMemberById(int member_id);
	
	public String selectPasswordByLoginId(String loginid);

}
