package calc;

public class Calc {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		
		/**
		 * 加号:+
		 * 减号:-
		 * 乘号:*
		 * 除号:/
		 * 取余:%
		 */
		
		int a=2;
		int b=5;
		String s1="abc";
		String s2="cde";//String 只能相加,代表着字符串进行拼接

		System.out.println(a+b);
		System.err.println(a+s1);
		System.out.println(a+b+s1);
		System.out.println(a+4+s1);
		System.out.println(s1+s2);
		System.out.println(a-b);

		float f1=3;
		float f2=5.0f;
		int c=a*b;
		float f3=a*b;//整数和整数相乘的结果还是整数
		System.out.println(c);
		System.out.println(f1*a);
		System.out.println(f3);
		System.out.println(f2*3);//小数和整数或者小数相乘的结果还是小数
		
		
		float f4=1/3*3;//整数和整数相除只能为整数,1/3=0,0*3f=0.0
		System.out.println(f4);
		
	}

}
