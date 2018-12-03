package com.example.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {
	
	
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
		Date d = new Date();
		sdf.applyPattern("yyyy-MM-dd");
		String output = sdf.format(d);
		System.out.println(output);

	}
}
