
/**
 * 转义符
 */
public class Test {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		char c1='a';
		char c2='\n';//换行回车,\是转义符,和后续部分组成,相对应的字符
		System.out.println(c2);
		char c3='\\';//只有一个\,\\ ==> \
		System.out.println(c3);
		
		String s="ab\nc\\d";
		System.out.println(s);
		
		char c4='\'';// \'代表'
		System.out.println(c4);
		char c5='\"';// \" 代表 "
		System.out.println(c5);
		String s2="ab\"cd";
		System.err.println(s2);
		//在程序中常用\r\n才能进行换行
		System.out.println("我要换行了\r\n换行成功");
		//还有其他的特殊用途的字符可以网上查找得出
	}

}
