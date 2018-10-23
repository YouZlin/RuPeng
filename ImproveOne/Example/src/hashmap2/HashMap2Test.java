package hashmap2;

public class HashMap2Test {

	public static void main(String[] args) {
		test();
	}
	
	private static void test(){
			String value=Jian2Fan_CH.convert("这只是简单的测试");
			System.out.println("转换成繁体:"+value);
			System.out.println("从繁体再转换成简体:"+Fan2Jian_CH.convert(value));
	}
	
	
}
