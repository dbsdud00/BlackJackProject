package com.callor.blackJack.utils;

public class Line {
	public static final String dLine = "=".repeat(50);
	public static final String sLine = "-".repeat(50);
	
	public static final String dLine(int length) {
		return "=".repeat(length);
	}
	public static final String sLine(int length) {
		return "-".repeat(length);
	}
	public static final String bLine(int Length) {
		return "\n".repeat(Length);
	}
	public static final String line(String a ,int length) {
		return String.format("%s", a).repeat(length);
	}

}
