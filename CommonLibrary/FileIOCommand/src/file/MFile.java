package file;

import java.io.File;

/**
 * 文件处理
 */
public class MFile {

	public static void main(String[] args) {
		test();
		
		test2();
	}
	
	static void test() {
		File f1=new File("E:\\Temp");//  \是转义符,所以表示一个\需要\\
		File f2=new File("E:\\1.txt");
		File f3=new File("E:\\","TFS.txt.bak");
		
		if (f1.isFile()) {//判断是否是文件
			System.out.println("是文件");
		}else if(f1.isDirectory()){//判断是否是文件夹
			System.out.println("是文件夹");
		}
		
		if (f2.exists()) {//判断是否存在
			if (f2.isFile()) {
				System.out.println("是文件");
			}else if(f2.isDirectory()){
				System.out.println("是文件夹");
			}
		}else {
			System.out.println(f2+"不存在");
		}
		
		
		File f4=new File("E:\\a\\b");
		f4.mkdir();//如果当前文件夹不存在则创建,如果父文件夹不存在则创建失败
		File f5=new File("E:\\a");
		f5.mkdir();//返回值,判断是否创建成功
		
		File f6=new File("E:\\b\\a");
		f6.mkdirs();//把所有不存在的文件夹都创建
		
		boolean isSuccess=f5.delete();//删除文件夹a,如果文件夹下还有文件就会删除失败
		System.out.println(isSuccess);
		//delete是从磁盘删除,而不会进入回收站
		
		
		File f7=new File("E:\\Temp\\test.txt");
		System.out.println(f7.getName());
		System.out.println(f7.length());
		
		
	}
	
	
	/**
	 * 遍历文件夹
	 */
	static void test2(){
		File f1=new File("E:\\Temp");
		//方法一:不建议使用
		String[]files=f1.list();
		for(int i=0;i<files.length;i++){
			/*
			File file=new File(files[i]);//只有文件名,无法找到文件名所在的位置
			System.out.println(file);
			*/
			
			File file=new File(f1,files[i]);
			if (file.isFile()) {
				System.out.println(file);
			}
		}
		//方法二
		File[]files2=f1.listFiles();
		for(int i=0;i<files2.length;i++){
			if (files2[i].isFile()) {
				System.out.println(files2[i]);
			}
		}
		
		
		File[]files3=f1.listRoots();//根目录的File
		for(int i=0;i<files2.length;i++){
			System.out.println(files3[i]);
		}
	}

}
