package test;

/**
 * 整数类型
 */
public class IntegerClass {
	//以下整数类型会有默认值
	byte b1;//字节,1byte=00000000,8位2进制
	short short1;//短整型,2byte,16位2进制
	int int1;//整型,4byte,32位2进制
	long long1;//长整型,8byte,64位2进制

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int a=200;
		System.out.println(a);//输出变量a
		System.out.println(180);//输出int类型的值180
		System.out.println("a");//输出字符串a
		
		//取值范围
		System.out.println("byte的最小值"+Byte.MIN_VALUE);
		System.out.println("byte的最大值"+Byte.MAX_VALUE);
		System.out.println("short的最小值"+Short.MIN_VALUE);
		System.out.println("short的最大值"+Short.MAX_VALUE);
		System.out.println("int的最小值"+Integer.MIN_VALUE);
		System.out.println("int的最大值"+Integer.MAX_VALUE);
		System.out.println("long的最小值"+Long.MIN_VALUE);
		System.out.println("long的最大值"+Long.MAX_VALUE);
		//超出取值范围会导致数据越界,数据偏离真实值
		long mLong=8888888L;//一般用L,小写的L(l)与一(1)相似会分不清
		System.out.println(mLong);
		
	}

}
