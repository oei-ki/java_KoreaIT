package com.varxyz.jvx330.di.example3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //설정관련된거라고 알려주는거임
public class AppConfig {
	@Bean
	public MemberService memberService() {
		return new MemberService(memberDao());
	}
	
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
}
