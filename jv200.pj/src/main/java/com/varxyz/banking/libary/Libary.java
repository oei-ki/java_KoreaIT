package com.varxyz.banking.libary;

public class Libary {
	protected static int bookNum=1;
	private Book[] serch = new Book [100]; //100권 담을 배열
	
	private Libary(){ //생성자 - 다른학교에서 부르지 못하게 만들어야함
	}
	
	private static Libary lib = new Libary(); //객체를 생성하고 진행???
	
	private static Libary getLibray() {
		return this.lib;
	}
	
	public void addBook(Book book) {
		serch[];
		bookNum++;
	}

	public void getBook(int serial) {
		for(int i = 0 ;  ; i++) {
			serch[i]
		}	
		System.out.println();
	}
	
}

