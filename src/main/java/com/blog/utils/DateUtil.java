package com.blog.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateUtil {

	public static String dateToStamp(Date date){
		return String.valueOf(date.getTime()/1000);
	}

	public static String stampToDate(String s){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Long lt = Long.parseLong(s);//方法解析的字符串参数s作为一个符号的十进制长
		Date date = new Date(lt*1000);
		return simpleDateFormat.format(date);
	}

	public static Long stampToDate(Long s){
		Long lt = s;
		Date date = new Date(lt*1000);
		return date.getTime();
	}

	@Test
	public void Test(){
		System.out.println(dateToStamp(new Date()));
		System.out.println(stampToDate("1506015268"));
	}
}
