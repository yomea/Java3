package com.calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarTest {
	
	public static void main(String[] args) {
		Calendar calendar = new GregorianCalendar();
		DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//calendar.set(2018, 1, 1, 0, 0, 0);//设置年月日时分秒
		calendar.set(Calendar.YEAR, 2018);//设置年
		calendar.set(Calendar.MONTH, 11);//设置月
		calendar.add(Calendar.YEAR, 10);//增加十年
		Date date = calendar.getTime();
		String d = simpleDateFormat.format(date);
		System.out.println(d);
	}
	

}
