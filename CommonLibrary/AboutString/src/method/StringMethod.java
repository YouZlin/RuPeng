package method;

public class StringMethod {

	public static void main(String[] args) {
		/*
		 * 字符串的一些方法和解释
		 */
		String s1 = "";
		s1.equals("");//判断字符串内容是否相等,区分大小写
		s1.equalsIgnoreCase("");//判断字符串是否相等,不区分大小写
		s1.contains("");//判断字符串是否包含给定的字符
		s1.startsWith("");//判断字符串是否以给定的字符开始
		s1.endsWith("");//判断字符串是否以给定的字符结束
		
		s1.length();//获取字符串的长度
		s1.charAt(0);//获得字符串中给定索引处的字符
		s1.indexOf(0);//获得给定字符第一次出现的索引
		s1.indexOf("");//获得给定字符串第一次出现的索引
		//~~~indexOf()还有其他的重载方式
		s1.lastIndexOf("");//获得给定字符最后一次出现的索引
		s1.substring(0);//截取字符串,从指定位置截取到最后
		s1.substring(0,1);//截取字符串,从指定位置截取到另一个指定位置
		
		
		
		judgeEqual();
		judgeHtmlAddress();
		outputMethodReturn();
		changeString();
	}
	
	/**
	 * 常用于判断验证码<br>
	 * 当前用于判断账号名
	 */
	private static void judgeEqual() {
		String username="asdfasdfs";
//		username="admin";
		if (username.equals("admin")) {
			System.out.println("用户名正确");
		}else {
			System.out.println("用户名错误");
		}

		username="ADmin";
		if (username.equalsIgnoreCase("admin")) {
			System.out.println("不区分大小写,用户名正确");
		}
	}
	
	/**
	 * 判断网址
	 */
	private static void judgeHtmlAddress() {
		String str="http://www.rupeng.com";
		str="https://www.baudu.com";
		if (str.startsWith("http://")&&(str.endsWith(".com")||str.endsWith(".cn"))) {
			System.out.println("是网址");
		}else {
			System.out.println("不是网址");
		}
	}
	
	/**
	 * 获得字符串方法的返回值
	 */
	private static void outputMethodReturn() {
		String s1="abcd123axa";
		System.out.println(s1.length());
		System.out.println(s1.charAt(3));
		System.out.println(s1.indexOf('a'));
		System.out.println(s1.indexOf("12"));
		System.out.println(s1.lastIndexOf('a'));
		System.out.println(s1.substring(4));
		System.out.println(s1.substring(3,5));

		String filename="林志玲.avi";
		int dotIndex=filename.indexOf('.');//获取"."第一次出现的位置
		String name=filename.substring(0,dotIndex);
		System.out.println(name);
		
		String ext=filename.substring(dotIndex+1);
		System.out.println(ext);
		
		String videoName="[BPA-827]无人生还.avi";
		
		int desStrat=videoName.indexOf("[");
		int desEnd=videoName.indexOf("]", desStrat+1);//确保是上一次的{
		String des=videoName.substring(desStrat, desEnd);
		System.out.println("番号:"+des);
		
		int dot=videoName.lastIndexOf('.');
		String video=videoName.substring(desEnd+1, dot);
		System.out.println("片名:"+video);
		
		String type=videoName.substring(dot+1);
		System.out.println("播放格式:"+type);
		
	}
	
	/**
	 * 对字符串改变
	 */
	private static void changeString() {
		//字符串对象"aBcD123"声明后不能改变
		String s1="aBcD123";
//		s1[1]="w";
//		s1.toLowerCase();
//		System.out.println(s1);
		
		String s2=s1.toLowerCase();
		System.out.println(s2);
		
		s2="uskt";//把String 类型的变量s2指向性的对象"uskt"
		s2=s2.toUpperCase();//与上面同样的道理
		
		s1=s1.replace('1', '一');//替换字符
		System.out.println(s1);
		s1=s1.replace("12", "进行变动了");//替换字符串
		System.out.println(s1);
		
		String name="北兵库,哈萨克,阿里嘎多,等等";
		String[] names=name.split(",");//需要符合正则表达式,有些字符会出现问题
		for(String value:names){
			System.out.println(value);
		}
		
		String admin=" admin "; //去除首位的字符串
		System.out.println(admin.equals("admin"));
		System.out.println(admin.trim().equals("admin"));
		
		admin=admin.replace(" ", "");//可以去除字符串中空格
		System.out.println(admin);
		
	}
	
}
