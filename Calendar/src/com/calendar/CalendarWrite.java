package com.calendar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CalendarWrite {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("请输入时间，格式：2016-10-21");
		
		String date = scanner.next();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Date d = dateFormat.parse(date);
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(d);
			int today = calendar.get(Calendar.DATE);
			calendar.set(Calendar.MONTH, 0);
			int week = calendar.get(Calendar.DAY_OF_WEEK);
			String str = "";
			for(int i = 0; i < week - 1; i++) {
				str +=" \t";
				
			}
			System.out.println("日\t一\t二\t三\t四\t五\t六\n");
			System.out.print(str);
			for(int i = 1; i <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
				if(i != today) {
					System.out.print(i + "\t");
					
				} else {
					
					System.out.print(i + "*\t");
					
				}
				if((i + week - 1) % 7 == 0) {
					System.out.println("\n");
					
				}
				
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(scanner != null) {
			
			scanner.close();
			scanner = null;
		}
		
	}

}
