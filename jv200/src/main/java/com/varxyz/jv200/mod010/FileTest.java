package com.varxyz.jv200.mod010;

import java.io.File;

public class FileTest {
	private static final String SAVE_DIR = "C:/temp";  //자바에서 역슬래쉬는 \\ 두번해야 한번 인식??
	public static void main(String[] args) {
		File saveDir = new File(SAVE_DIR);
		System.out.println(saveDir.getPath());
		System.out.println("window : " + File.separator);
	}
}
