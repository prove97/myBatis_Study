package com.kh.myBatis.member.service;

import com.kh.myBatis.member.model.vo.Member;

public interface MemberService {
	public abstract int insertMember(Member m);
	public abstract Member loginMember(Member m);
}
