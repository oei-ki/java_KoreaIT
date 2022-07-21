package com.varxyz.jvx330.di.example3;

import java.util.List;

public class MemberDao {

	public List<Member> findAllMembers() {
		return List.of(new Member("java","유비"), new Member("String", "관우"));
	}
}
