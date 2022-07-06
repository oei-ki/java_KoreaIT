package com.varxyz.jv300.mod009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class InitializeCourseListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent event)  { //웹어플리케이션을 초기화할 때 호출
    	System.out.println("contextInitialized() method called");

    	
    	ServletContext context = event.getServletContext();
    	InputStream is = null;
    	BufferedReader reader = null;
    	List<String[]> contentList = new ArrayList<>();
			try { //IO가 일어나기 때문에? try를 써줘야 함
				is = context.getResourceAsStream("/WEB-INF/classes/cours_contents.txt");
				reader = new BufferedReader(new InputStreamReader(is));
				String record = null;
				while((record = reader.readLine())!= null) { //readLine 한줄씩 읽음
					record = escapeHtml(record);
					String[] fields = record.split("\t"); //\t 이게 탭이라서 탭으로 배열이 생김
					contentList.add(fields); //여기서 txt리스트에 담음
				}
				context.setAttribute("contentList", contentList); //여기 정보는 컴퓨터가 셧다운되기 전까지 저장중?
				System.out.println("The course contents has been loaded");
			}catch(Exception e) {
				e.printStackTrace();
			}
    }
    
    private String escapeHtml(String line) {
        if(line.length() == 0) {
           return line;
        }
        return line.replace("<", "&lt;").replace(">", "&gt;"); //replace 자신이 바꾸고싶은 문자로 문자열을 치환
     }
    
    @Override
    public void contextDestroyed(ServletContextEvent event)  { 
    	System.out.println("contextDestroyed() method called"); //웹 어플리케이션을 종료할 때 호출.
    }
}