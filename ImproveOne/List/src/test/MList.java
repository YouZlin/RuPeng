package test;

public class MList {

	public static void main(String[] args) {
//		test1();
		test2();
	}
	
	/**
	 * why use list
	 */
	private static void test1(){
		String []strs1=new String[5];
		String[] strs2={"abcd","123","456"};
		strs2=new String [5];//strs2指向一个新的数组对象
		
		int[]num={3,5,6,9,7,14,86};
	}
	
	/**
	 * 获得被3整除的数
	 * @param num
	 * @return
	 */
	private static int[]getData(int []num){
		//繁琐的方式获得
		int count=0;
		for (int i = 0; i < num.length; i++) {
			if (num[i]%3==0) {
				
				count++;
			}
		}
		int[] result=new int[count];
		int counter=0;
		for (int i = 0; i < num.length; i++) {
			if (num[i]%3==0) {
				result[counter]=num[i];
				counter++;
			}
		}
		return num;
	}

	/**
	 * 自定义可变数组
	 */
	private static void test2(){
		MyArrayList myArrayList=new MyArrayList();
		myArrayList.add("he");
		myArrayList.add("546");
		myArrayList.add("wtf");
		myArrayList.add("check");
		System.out.println(myArrayList.size());
		System.out.println(myArrayList.get(2));
		
		for (int i = 0; i < myArrayList.size(); i++) {
			System.out.println(myArrayList.get(i));
		}
		
		
		int[]num={3,5,6,9,7,14,86};
		MyArrayList list=getData2(num);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
	}

	
	private static MyArrayList getData2(int[]num){
		
		MyArrayList list=new MyArrayList();
		for (int i = 0; i < num.length; i++) {
			if (num[i]%3==0) {
				list.add(num[i]);
			}
		}
		return list;
	}
	
	
	
}
