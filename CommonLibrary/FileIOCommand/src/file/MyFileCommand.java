package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class MyFileCommand {

	public static void main(String[] args) {
		read();
		copyFile();
	}
	
	private static void read(){
		InputStream fis=null;
		Reader reader=null;
		try {
			fis=new FileInputStream("E:\\test.txt");
			byte[]bytes=new byte[50];//读取数据长度一定为50
			int len=fis.read(bytes);//读取的数据真正的长度,超出长度只能读50
			System.out.println("read data's Len="+len);
			System.out.println(new String(bytes));//可能出现乱码,汉字可能只读取一半
			
			//
			byte []byte_read=new byte[50];
			//read执行完了下次执行的时候就从上一次读完的位置开始
			while((fis.read(byte_read))>0){
				//但是乱码问题没有解决
				System.out.println(new String(byte_read));
			}
		} catch (FileNotFoundException e1) {
			System.out.println("文件不存在");
		} catch (IOException e) {
			System.out.println("读入错误");
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				System.out.println("do nothing");
			}
		}
		
	}

	private static void copyFile(){
		long startMS=System.currentTimeMillis();//起始毫秒数
		
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream("E:\\a.bat");
			fos=new FileOutputStream("E:\\b.bat");
//			byte[]bytes=new byte[50];//50个字节的缓存区
//			byte[]bytes=new byte[1024];//1K缓存区
			byte[]bytes=new byte[1024*1024];//1M缓存区;1024*1024编译器会自动优化,直接相乘出对应的值
			//合适的缓存区大小可以提高读写速率
			int len;
			while ((len=fis.read(bytes))>0) {
//				fos.write(bytes);//如果len=30,应该只写入bytes前30个有用的数据
				fos.write(bytes,0,len);//从0位开始,写入len个数据长度
			}
			fos.flush();
			long endMS=System.currentTimeMillis();//结束毫秒数
			System.out.println("拷贝完成,用时(毫秒):"+(endMS-startMS));
		} catch (FileNotFoundException e) {
			System.out.println("文件找不到:"+e.getMessage());
		} catch (IOException e) {
			System.out.println("读取失败");
		}finally {
			try {
				if (fis!=null) {
					fis.close();
				}
			} catch (IOException e) {
			}
			try {
				if (fos!=null) {
					fos.close();
				}
			} catch (IOException e) {
			}
		}
		
		
		
	}
	
	
	
}
