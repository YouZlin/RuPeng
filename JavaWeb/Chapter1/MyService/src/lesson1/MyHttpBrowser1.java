package lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyHttpBrowser1 {
	private static MyHttpBrowser1 mBrowser1;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		mBrowser1=new MyHttpBrowser1();
		mBrowser1.connect();
	}
	
	private void connect() throws UnknownHostException, IOException {
		Socket socket=new Socket("www.baidu.com",80);//连接服务器,默认端口80
		OutputStream os=socket.getOutputStream();
		OutputStreamWriter writer=new OutputStreamWriter(os);
		
		//浏览器向服务器发送请求
		writer.append("GET / HTTP/1.1\n");
		writer.append("Host: www.baidu.com\n");
		writer.append("\n");
		writer.flush();
		//接受服务器返回的请求
		InputStream is=socket.getInputStream();
		InputStreamReader reader=new InputStreamReader(is);
		BufferedReader bufferedReader=new BufferedReader(reader);
		
		String line;
		while ((line=bufferedReader.readLine())!=null) {
			System.out.println(line);
		}
		
		bufferedReader.close();
		reader.close();
		is.close();
		writer.close();
		os.close();socket.close();
		
	}

}
