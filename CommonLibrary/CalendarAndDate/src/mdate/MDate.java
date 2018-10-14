package mdate;

import java.util.Calendar;
import java.util.Date;

public class MDate {

	public static void main(String[] args) {
		
		//引用java.util.Date;
		Date now =new Date();
		System.out.println(now);
		
		Date now1=new Date(System.currentTimeMillis());
		System.out.println(now1);//两种是一样的
		
		int year=now.getYear();//出现的横线,表示不被推荐的方法,按F3进入源码部分可以查看到:@deprecated 不被推荐;推荐使用Calendar.YEAR
		System.out.println(year);
		int hour=now.getHours();
		System.out.println(hour);
		
		mCalendar();
		
		createDate();
		
		deal();
	}
	
	/**
	 * Calendar使用例子
	 */
	private static void mCalendar(){
		Calendar cal=Calendar.getInstance();//返回Calendar对象
		System.out.println(cal);//指向的对象的实际类型
		cal.setTime(new Date());//帮我解析当前时间
		int year=cal.get(Calendar.YEAR);//获得时间的"年"部分
		System.out.println(year);
		
		int minute=cal.get(Calendar.MINUTE);//获得日期的"分钟"部分
		System.out.println(minute);
		
		System.out.println(cal.get(Calendar.WEEK_OF_MONTH));//月的第几周
		/*
		 * 等等方法
		 */
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));//周的第几天
		System.out.println(cal.get(Calendar.HOUR));//12小时制的小时
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));//24小时制的小时
		
	}
	
	/**
	 * 创建Date对象类型
	 */
	private static void createDate(){
		
		Calendar cal=Calendar.getInstance();
		cal.set(2018, 1,14);
		Date d1=cal.getTime();
		
		System.out.println(d1);//Sat Jan 12 15:00:26 CST 2019,输出设定时间
		
		Date now =new Date();
		Calendar cal1=Calendar.getInstance();
		cal1.setTime(now);
		
		System.out.println(cal1.getTime());//Sun Oct 14 15:00:26 CST 2018//输出当前时间
		
		System.out.println(cal1.get(Calendar.MONTH));//月份从0开始,代表了一月份
		System.out.println(cal1.get(Calendar.YEAR));
		
	}
	
	private static void deal(){
		Calendar cal=Calendar.getInstance();
		
		cal.set(2018, 1,14);
		System.out.println(cal.getTime());
//		Wed Feb 14 15:08:24 CST 2018
		//月份从0开始,输入 1 ,结果会是二月份
		
		cal.set(2018, 11,14);
		System.out.println(cal.getTime());
//		Fri Dec 14 15:08:24 CST 2018
		//输入 11 ,结果是12月份 
		
		cal.set(2018, 12,14);
		System.out.println(cal.getTime());
//		Mon Jan 14 15:08:24 CST 2019
		//输入 12 ,结果是一月份,本来是十三月份,但实际不存在十三月份,导致年份加一
		
		cal.set(2018, 24,14);
		System.out.println(cal.getTime());
//		Tue Jan 14 15:08:24 CST 2020
		//根据上面月份超出实际的值,年份会自动增长
	}
	
	

}
