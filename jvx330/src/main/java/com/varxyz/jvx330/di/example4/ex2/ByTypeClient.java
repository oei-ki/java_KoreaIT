package com.varxyz.jvx330.di.example4.ex2;

public class ByTypeClient {
	private NamingService service;
	
	public NamingService getNamingService() {
		return service;
	}
	
	public void setNamingService(NamingService service) {
		this.service = service;
	}
	
	public void service(String name) {
		Object o = service.lookup(name);
		System.out.println(o);
	}
}
