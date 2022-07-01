package com.varxyz.jv300.mod004;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/mod004/file_upload.do")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 2, // 2MB 파일 업로드 시 보관하는 서버에 바로 보관할지 추후에 보관할지 설정..
		maxFileSize = 1024 * 1024 * 10,      //10MB 업로드최대크기
		maxRequestSize = 1024 * 1024 * 50)   //50MB 모든 정보 전체 사이즈
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "C:/temp"; //파일생성되는 위치?

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		File saveDir = new File(SAVE_DIR);
		if(!saveDir.exists()) {  //exists 존재 확인???
			saveDir.mkdir();
		}
		for(Part part : request.getParts()) {
			//C:\temp\eclipse.ini(그냥 파일명인듯)
			part.write(saveDir.getPath() + File.separator + extractFileName(part));
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h3> Upload has been done successfully. </h3>");
		out.println("</body></html>");
		out.close();
		
		/*Enumeration<String> en = request.getHeaderNames();
		while(en.hasMoreElements()) {
			String header = en.nextElement();
			System.out.println(header + " = " + request.getHeader(header));*/
		
	}

	private String extractFileName(Part part) { //파일명만 찾는 메소드
		String contentDisp = part.getHeader("Content-Disposition");
		System.out.println("Content-contentDisp : " + contentDisp);
		for(String s : contentDisp.split(";")) {
			if(s.contains(File.separator)) {
				return s.substring(s.lastIndexOf(File.separator) + 1).replace("\"" , "");
			}else {
				if(s.contains("filename=")) {
					return s.substring("filename=".length() + 1).replace("\"" , "");
				}
			}
		}
		return "";
	}
}
