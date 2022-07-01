package com.varxyz.jv251.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnerctionManager {
	private static final String JDBC_URL; //final => 선언과 동시에 초기화해줘야함, 안해준다면 최소한 생성자만들어야함.
	private static final String JDBC_USER; //static이랑 생성자??뭐지?
	private static final String JDBC_PASSWD;
	
	static { //외부 파일에 보관한다고? 보안적인문제랑 실리적인문제?(값이 바뀔때의 위치문제?)
		Properties props = new Properties(); //MAP 계열의 컬렉션 프레임워크와 비슷하게 동작하는 파일/key를 주면 Value를 반환하는 기능을 가짐
		try {
			props.load(new FileInputStream("jdbc.properties"));//파일 경로 읽고 load로 적재?시킴
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try { //드라이버 생성
			Class.forName(props.getProperty("JDBC_DRIVER")); //이게 키 값
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		JDBC_URL = props.getProperty("JDBC_URL");
		JDBC_USER = props.getProperty("JDBC_USER");
		JDBC_PASSWD = props.getProperty("JDBC_PASSWD");
		
		System.out.println("JDBC_URL = " + "JDBC_URL");
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWD);
	}
}
