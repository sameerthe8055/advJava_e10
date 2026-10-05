package com.UserManagement;

import java.util.Scanner;

public class Utilities {
	static int getInt(Scanner sc, String text) {
		int ip = 0;
		if(text.length() != 0) System.out.print(text);
		while(true) {
			
			if(sc.hasNextInt()) {
				ip = sc.nextInt();sc.nextLine();
				break;
			}
			System.out.print("Enter a valid input!");
			
		}
		return ip;
	}
	static String getString(Scanner sc, String text) {
		String ip = "";
		if(text.length() != 0) System.out.print(text);
		ip = sc.nextLine();
		return ip;
	}
	static long getLong(Scanner sc, String text) {
		long ip = 0L;
		if(text.length() != 0) System.out.print(text);
		while(true) {
			
			if(sc.hasNextLong()) {
				ip = sc.nextLong();
				break;
			}
			System.out.print("Enter a valid input!");			
			sc.next();
		}
		return ip;
	}
	static char getChar(Scanner sc, String text) {
		
		char ip;
		String si;
		if(text.length() != 0) System.out.print(text);
		while(true) {
			
			si = sc.nextLine();
			if(si.length() == 1) {
				ip = si.charAt(0);
				break;
			}
			sc.next();
			System.out.println("Enter a valid input!");			
		}
		return ip;
	}
}
