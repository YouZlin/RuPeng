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
import java.io.Writer;

import org.apache.commons.io.IOUtils;



public class ReaderWriter {

	public static void main(String[] args) {
		test();
		test1();
	}
	
	static void test() {
		InputStream inputStream=null;
		try {
			inputStream=new FileInputStream("D:\\1.txt");
			byte[]buffer=new byte[4];
			inputStream.read(buffer);
			String s=new String(buffer);
			System.out.println(s);//读到半个文字会出现乱码
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("文件未找到"+e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			IOUtils.closeQuietly(inputStream);
		}
		
//		Reader、Writer逐字符读取
		
		Reader reader=null;
		InputStream inStream=null;
		try {
			inStream=new FileInputStream("D:\\1.txt");
			reader=new InputStreamReader(inStream);
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
			
		/*
		 * InputStreamReader内部实现是依靠InputStream实现
		 */
		
	}
	
	
	static void test1() {
		OutputStream fos=null;
		OutputStreamWriter writer=null;
		
		try {
			fos=new FileOutputStream("D:\\1.txt");
			writer=new OutputStreamWriter(fos);
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
