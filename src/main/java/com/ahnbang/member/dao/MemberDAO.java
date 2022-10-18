package com.ahnbang.member.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO {
	
	public int insertMember(
			@Param("userid") String loginId, 
			@Param("username") String password, 
			@Param("pawssword") String name, 
			@Param("email") String email);
	

}
