package com.varxyz.jv300.mod009;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mod009/list_course_contents.do")
public class ListCourseContentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//    private static List<String[]> contentList;
	private static List<String> textLines;

	@SuppressWarnings("unchecked")
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		List<String[]>contentList = (List<String[]>)context.getAttribute("contentList");
//		contentList = (List<String[]>)context.getAttribute("contentList"); //getAttribute("contentList"); InitializeCourseListener을 가져옴 
//		contentList = tapToSpace(contentList);
		textLines = tapToSpace(contentList);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

//		request.setAttribute("contentList", contentList);
		request.setAttribute("textLines", textLines);
		request.getRequestDispatcher("list_course_contents.jsp").forward(request, response);
		//           객체를 전달하는 영학 
		
	}
	
	private List<String> tapToSpace(List<String[]> contentList){
		List<String> lineList = new ArrayList<>();
		if(contentList.size() > 0 ) {
			for(String[] contents : contentList) {
				if(isEmptyLine(contents)) {
					continue;
				}
				for(int i =0; i < contents.length; i++) {
					if(contents[i].length() == 0) {
						contents[i] = "<span class=\"tap\">";
						contents[contents.length - 1] = contents[contents.length - 1] + "</span>";
					}
				} 
			}
		}else {
			lineList.add("-No Data-");
		}
		String line = "";
		for(String[] contents : contentList) {
			for(String s : contents) {
				line += s;
			}
			lineList.add(line);
			line="";
		}
		return lineList; 
	}

	private boolean isEmptyLine(String[] contents) {
		if(contents.length == 0) {
			return true;
		}
		return false;
	}

//	private List<String[]> tapToSpace(List<String[]> contentList){
//		if(contentList != null) {
//			for(String[] contents : contentList) {
//				for(int i=0; i < contents.length; i++) {
//					if(contents[i].length() == 0) { //리스트에 배열이 들어간곳은 값이 0임
//						contents[i] = "&nbsp;&nbsp;&nbsp;&nbsp;";
//					}
//					if(contents[i].length() == 0) {
//						
//					}
//				} 
//			}
//		}else {
//			String[] str = new String[] {"-No Data-"};
//			ArrayList<String[]> list = new ArrayList<>();
//			list.add(str);
//			contentList = list;
//		}
//		return contentList;
//	}
}
