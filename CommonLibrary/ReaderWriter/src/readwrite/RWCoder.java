package readwrite;

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

public class RWCoder {

	public static void main(String[] args) {
		test();
	}

	static void test() {
		/*
		 * GB2312(汉字国家标准)
		 * GBK(GB2312扩展,还能表示繁体)
		 * UTF-8(国际标准)
		 * UTF-16
		 */
		//用什么编码存储用什么编码读取,确保无乱码
		
		Reader reader=null;
		InputStream inStream=null;
		try {
			inStream=new FileInputStream("D:\\1.txt");
			reader=new InputStreamReader(inStream,"UTF-8");
			//-1 if the end of the stream has been reached
			int i;
			while ((i=reader.read())>-1) {
				char ch=(char) i;
				System.out.print(ch);
			}
		} catch (IOException e) {
			System.out.println("读取出错"+e.getMessage());
		}
		finally {
			IOUtils.closeQuietly(reader);
			IOUtils.closeQuietly(inStream);
		}
	}
	
	static void test1() {
		OutputStream fos=null;
		OutputStreamWriter writer=null;
		try {
			fos=new FileOutputStream("D:\\1.txt");
			writer=new OutputStreamWriter(fos,"UTF-8");
			writer.write("测试");
			writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			IOUtils.closeQuietly(writer);
			IOUtils.closeQuietly(fos);
		}
	}
}
