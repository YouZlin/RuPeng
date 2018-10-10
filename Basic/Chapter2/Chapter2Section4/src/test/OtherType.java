package test;

public class OtherType {

	//浮点型
	double d1;//双精度浮点型,精度范围大于float
	float f1;//单精度浮点型
	//字符型
	char a1;
	//布尔类型
	boolean bool1;//真假判断:只有true和false,有些语言0,1也代表着真假
	//字符串类型
	String str1;//String不是基本的数据类型,它是由多个的char类型进行拼接成的
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		double d2=3.14;
		float f2=222.3F;//float需要在赋予的值后面加上F(f)来表示数值为float类型
		System.out.println(d2);
		System.out.println(f2);
		char a2='a';
		System.out.println(a2);
		boolean boolean2=false;
		System.out.println(boolean2);
		
		String s="Hello World!";
		System.out.println(s);
		
		//String和其他类型操作结果为String类型,是进行拼接而不是加减
		String s1="test"+1;
		System.out.println(s1);
		String s2="1"+1+3.14;
		System.out.println(s2);
		String s3=3+"2";
		System.out.println(s3);
		String s4=1+4+"6";
		System.out.println(s4);
		String s5=1+(2+"3");
		System.out.println(s5);
		
		String s6="";//长度为0的字符串
		System.out.println(s6);
	}

}
