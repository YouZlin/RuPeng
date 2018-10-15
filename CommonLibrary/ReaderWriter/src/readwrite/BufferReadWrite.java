package readwrite;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import org.apache.commons.io.IOUtils;

public class BufferReadWrite {

	public static void main(String[] args) {
		test();
		test1();
	}

	/**
	 * 使用缓存区,提高读取效率
	 * 方便逐行处理
	 */
	private static void test() {
		OutputStream fos=null;
		OutputStreamWriter writer=null;
		BufferedWriter buffWrite=null;
		try {
			fos=new FileOutputStream("D:\\1.txt");
			writer=new OutputStreamWriter(fos);
			buffWrite=new BufferedWriter(buffWrite);
			buffWrite.write("我呢?");
			buffWrite.newLine();//换行
			buffWrite.write("你啊!");
			buffWrite.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("写入出错");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("写入出错");
		}
		finally {
			IOUtils.closeQuietly(buffWrite);
			IOUtils.closeQuietly(writer);
			IOUtils.closeQuietly(fos);
			//如果文件流按顺序关闭,会正常写入,buffWrite.flush();不使用照样可以写入数据
			//Stream如果被关闭就没办法写入数据
		}
	}
	
	private static void test1() {
		InputStream inStream=null;
		Reader reader=null;
		BufferedReader buffReader=null;
		try {
			inStream = new FileInputStream("");
			reader=new InputStreamReader(inStream);
			buffReader =new BufferedReader(reader);
			String line;
			while ((line=buffReader.readLine())!=null) {
				System.out.println(line+"!");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件未找到");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("读取出错");
		}
		finally {
			IOUtils.closeQuietly(buffReader);
			IOUtils.closeQuietly(reader);
			IOUtils.closeQuietly(inStream);
		}
				
	}
}
