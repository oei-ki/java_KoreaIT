package com.varxyz.jv300.mod006;

public class ConnectionManager {
	private static ConnectionManager Connection = new ConnectionManager();
	private static String user;
	private static String passwd;
	private static String url;
	
	
	private ConnectionManager() {
		
	}
	
	public static ConnectionManager getConnection() {
		return Connection;
	}
}
