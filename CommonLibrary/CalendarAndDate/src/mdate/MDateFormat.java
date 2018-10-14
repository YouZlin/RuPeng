package mdate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 进行日期格式化
 * @author Black
 *
 */
public class MDateFormat {

	public static void main(String[] args) {
		format1();
	}

	static void format1(){
		Date now =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");//正常的时间格式,DD代表年中的天数
		String s=sdf.format(now);
		System.out.println(s);
		
		try {
			SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
			Date d2=sdf1.parse("2017-8-8");
			System.out.println(d2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
