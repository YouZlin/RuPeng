package readwrite;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.apache.commons.io.FileExistsException;
import org.apache.commons.io.IOUtils;

public class Exercises1 {

	public static void main(String[] args) {
		try {
			String content=downloadString(new URL("https://www.baidu.com"));
			System.out.println(content);
		} catch (FileExistsException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 下载URL的内容到D:\test.txt文件<br>
	 * 如果D:\test.txt文本不存在,则执行创建<br>
	 * @param url 链接地址
	 * @return 下载的文本内容
	 * @throws FileExistsException
	 * @throws IOException
	 * @throws URLException
	 */
	static String downloadString(URL url) throws FileExistsException,IOException,URLException  {
		//创建总的文本内容
		StringBuffer content=new StringBuffer();
		//创建读取对象
		URLConnection urlConn=null;
		InputStream inStream=null;
		Reader reader=null;
		BufferedReader buffReader = null;
		String line;
		//实现读取操作
		try {
			urlConn=url.openConnection();
			if (urlConn==null) {
				new URLException("链接地址异常!");
			}
			inStream=urlConn.getInputStream();
			reader=new InputStreamReader(inStream);
			buffReader=new BufferedReader(reader);
			while ((line=buffReader.readLine())!=null) {
				content.append(line+"\r\n");//行读取,添加换行操作
			}
		}finally {
			IOUtils.closeQuietly(buffReader);
			IOUtils.closeQuietly(reader);
			IOUtils.closeQuietly(inStream);
		}
		
		//创建写入对象
		File file=null;
		Writer writer=null;
		BufferedWriter buffWriter=null;
	
		//实现写入操作
		try {
			file=new File("D:\\test.txt");
			if (!file.exists()) {
				boolean isSuccess=file.createNewFile();
				if (!isSuccess) {
					new FileExistsException("创建测试文本失败,请确认是否有写入权限");
				}
			}
			writer=new FileWriter(file);
			buffWriter=new BufferedWriter(writer);
			buffWriter.write(content.toString());
			buffWriter.flush();
		}finally {
			IOUtils.closeQuietly(buffWriter);
			IOUtils.closeQuietly(writer);
		}
		
		return content.toString();
		
	}

	
	/**
	 * 获得文本内容<br>
	 * 不添加参数,默认使用编码格式GBK
	 * @param file 文件路径及名称
	 * @return 文本内容
	 */
	static String readTxtFile(String file) {
		return readTxtFile(file,"GBK");
	}
	
	/**
	 * 获得文本内容
	 * @param file	文件路径及名称
	 * @param charsetName 编码格式
	 * @return 文本内容
	 */
	static String readTxtFile(String file,String charsetName) {
		//创建总的文本内容
				StringBuffer content=new StringBuffer();
				//创建读取对象
				File files=null;
				InputStream inStream=null;
				Reader reader=null;
				BufferedReader buffReader = null;
				String line;
				//实现读取操作
				try {
					files=new File(file);
					if (!files.exists()) {
						System.out.println("文件不存在");
						new FileNotFoundException("文件不存在");
					}
					inStream=new FileInputStream(files);
					reader=new InputStreamReader(inStream,charsetName);
					buffReader=new BufferedReader(reader);
					while ((line=buffReader.readLine())!=null) {
						content.append(line+"\r\n");//行读取,添加换行操作
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					IOUtils.closeQuietly(buffReader);
					IOUtils.closeQuietly(reader);
					IOUtils.closeQuietly(inStream);
				}
		return content.toString();
	}
	
}
class URLException extends Exception{

	public URLException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public URLException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public URLException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public URLException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public URLException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
