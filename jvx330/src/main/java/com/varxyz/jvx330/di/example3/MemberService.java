package com.varxyz.jvx330.di.example3;

import java.util.List;

public class MemberService {
	private MemberDao memberDoa;
	
	public MemberService(MemberDao memberDao) {
		this.memberDoa = memberDao;
	}
	
	public List<Member> getAllMembers() {
		return memberDoa.findAllMembers();
	}
}
