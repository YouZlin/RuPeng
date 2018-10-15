package file;

import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadPicture {

	public static void main(String[] args) {
		download();
	}
	
	private static void download() {
		InputStream in=null;
		OutputStream os=null;
		try {
			URL url=new URL("https://www.baidu.com/img/bd_logo1.png");
			in=url.openStream();
			//不管是哪个InputStream的子类,都可以read
			//多态好处:不要在意这些细节
			System.out.println(in.getClass());
			os=new FileOutputStream("E:\\1.png");
			copy(in, os);
			System.out.println("下载成功");
		} catch (MalformedURLException e) {
			System.out.println("网络地址错误");
		} catch (IOException e) {
			System.out.println("下载失败");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}finally {
			closeQuietly(in);
			closeQuietly(os);
		}
	}

	//对常用的方法进行封装,方便调用以及简化代码~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * 进行拷贝(方法重载)
	 * @param in 输入流
	 * @param os 输出流
	 * @param bufferSize 缓存区大小
	 * @throws IOException 数据读取可能出现异常
	 * @throws IllegalAccessException 
	 */
	static void copy(InputStream in,OutputStream os) throws IOException, IllegalAccessException{
		copy(in,os,1024*1024);
	}
	/**
	 * 进行拷贝
	 * @param in 输入流
	 * @param os 输出流
	 * @param bufferSize 缓存区大小
	 * @throws IOException 数据读取可能出现异常
	 * @throws IllegalAccessException 
	 */
	static void copy(InputStream in,OutputStream os,int bufferSize) throws IOException, IllegalAccessException{
		//检查参数的合理性
		if (in==null) {
			throw new IllegalAccessException("in 不能为空");
		}
		if (os==null) {
			throw new IllegalAccessException("os 不能为空");
		}
		if (bufferSize<=0) {
			throw new IllegalAccessException("bufferSize必须大于0");
		}
		byte[]buffer=new byte[bufferSize];
		int len;
		///在这里不用catch异常,因为不知道怎么处理,让调用者处理
		while ((len=in.read(buffer))>0) {
			os.write(buffer, 0, len);
		}
	}
	
	private static void closeQuietly(Closeable closeable) {
		if (closeable!=null) {
			try {
				closeable.close();
			} catch (IOException e) {
			}
		}
	}
	
}
