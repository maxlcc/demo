package com.lcc.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
public static final String DEFAULT_DATE_PATTERN="yyyyMMdd";
	
	private DateUtil() {
		
	}

	public static Calendar cal = Calendar.getInstance();
	
	/** 
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static String getCurrentTime() {
		Calendar cale = Calendar.getInstance();
		SimpleDateFormat simple = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		return simple.format(cale.getTime());
	}
	/**
	 * 计算两个时间之间的天数
	 * 
	 * @param start
	 * @param end
	 * @return
	 * @throws ParseException
	 */
	public static int daysBetweens(Date start, Date end) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		cal.setTime(sdf.parse(sdf.format(start)));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(sdf.format(end)));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.valueOf(String.valueOf(between_days)) + 1;

	}
	
	/**
	 * 计算某月的最后一天
	 * @param date
	 * @return
	 */
	public static String lastDay(String date){
		SimpleDateFormat simple = new SimpleDateFormat("yyyyMMdd");
		int year=Integer.valueOf(date.substring(0, 4));
		int month=Integer.valueOf(date.substring(4, 6));
		cal.set(Calendar.YEAR,year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
		Date lastDate = cal.getTime();

	//	cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
	//	Date firstDate = cal.getTime();
	//	simple.format(firstDate);
		return simple.format(lastDate);
	}
}
