package com.varxyz.jv200.mod010;

import java.io.*;


public class FileInputStreamTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		int totalBytes = 0;
		try {
			try {
				fis = new FileInputStream("test.txt"); //파일 경로 읽음(상대주소)
				fos = new FileOutputStream("test_copy.txt");
				for(int readByte; (readByte = fis.read()) != -1;) {
					fos.write(readByte); //output
//					System.out.write(readByte); input
					totalBytes++;
				}
			} finally {
				fis.close();
			}
		} catch (IOException e) { //file과 관련된 exception은 다 IOException임
			e.printStackTrace();
		}
		System.out.println("\n전체 바이트 수 : " + totalBytes + "bytes.");
	}

}

