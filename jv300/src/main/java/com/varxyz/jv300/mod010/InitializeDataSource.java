package com.varxyz.jv300.mod010;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class InitializeDataSource implements ServletContextListener {

    	private static final String JDBC_FILE_PATH = "/WEB-INF/classes/jdbc.properties"; //대문자로 쓰는 이유? 

    	
   	@Override
   	public void contextInitialized(ServletContextEvent event) {    	//웹어플리케이션을 초기화할 때 호출
   		ServletContext context = event.getServletContext();
   		InputStream is = null;
   		try {
			is = context.getResourceAsStream(JDBC_FILE_PATH);
			Properties prop = new Properties();
			prop.load(is);
			
			String jdbcDriver = prop.getProperty("jdbc.driver");
			String jdbcUrl = prop.getProperty("jdbc.url");
			String jdbcName = prop.getProperty("jdbc.name");
			String password = prop.getProperty("jdbc.password");
			
			DataSource dataSource = new DataSource(jdbcDriver,jdbcUrl, jdbcName,password);
			
			NamingService namingService = NamingService.getInstance();
			namingService.setAttribute("dataSource", dataSource);
			
			System.out.println("DataSource has been initillized.");
//			context.setAttribute("dataSource", dataSource);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
   	}
    
    
    @Override
    public void contextDestroyed(ServletContextEvent event)  { 
    	System.out.println("contextDestroyed() method called"); //웹 어플리케이션을 종료할 때 호출.
    }
	
}