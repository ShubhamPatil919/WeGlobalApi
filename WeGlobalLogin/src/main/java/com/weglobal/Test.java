package com.weglobal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		System.out.println(date);
	}

}
