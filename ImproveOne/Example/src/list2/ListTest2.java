package list2;

import java.util.ArrayList;

public class ListTest2 {
	public static void main(String[] args) {
		deleteElement();
	}
	
	private static void deleteElement(){
		ArrayList<String> list=new ArrayList<>();
		list.add("abc");
		list.add("chelgj");
		list.add("sdfaksd");
		list.add("sada");
		list.add("ckjhs");
		list.add("as");
		
		//方法一:从后往前删除
		/*
		for (int i = list.size()-1; i >=0; i--) {
			String str=list.get(i);
			if (str.length()>5) {
				list.remove(i);//程序长度变化,当前元素移除后,i向后移动一位,下一个元素向前移动一位,将会被跳过
			}
		}
		*/
		//方法二:
		
		//记录要删除元素
		ArrayList<String >delList=new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			String str=list.get(i);
			if (str.length()>5) {
				delList.add(str);
			}
		}
		//遍历完成再删除
		for (String string : delList) {
			list.remove(string);
		}
		
		//方法三:删除后检索位置不动
		for (int i = 0; i < list.size(); i++) {
			String str=list.get(i);
			if (str.length()>5) {
				list.remove(i);//程序长度变化,当前元素移除后,i向后移动一位,下一个元素向前移动一位,将会被跳过
				i--;//为保证数据正确性,将i保持在当前位置,指向向前移动一位的后续元素
			}
		}
		for (String string : list) {
			System.out.println("当前元素:"+string);
		}
		
	}
}
