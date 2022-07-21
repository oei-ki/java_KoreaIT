package com.varxyz.jvx330.di.example5.ex1;

public class MemverServiceImp implements MemberService {
	
	public MemverServiceImp() {
		System.out.println("빈 생성 : " + this);
	}

	public void addMember(String id, String passwd) {
		System.out.println("New member inserted : " + id + "/" + passwd);
	}
}
