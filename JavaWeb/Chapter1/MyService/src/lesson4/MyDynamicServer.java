package lesson4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyDynamicServer {
	static MyDynamicServer myDynamicServer;
	public static void main(String[] args) throws IOException {
		myDynamicServer =new MyDynamicServer();
		myDynamicServer.startServer();
	}
	

	private void startServer() throws IOException {
		ServerSocket serverSocket=new ServerSocket(8080);
		while (true) {
			Socket clientSocket=serverSocket.accept();
			InputStream is=clientSocket.getInputStream();
			InputStreamReader reader=new InputStreamReader(is);
			BufferedReader bufferedReader=new BufferedReader(reader);
			String firstLine=bufferedReader.readLine();
			
			if (firstLine==null) {
				reader.close();
				is.close();
				continue;
			}
			
			//获得请求地址
			String fileName=firstLine.split(" ")[1];
			
			OutputStream os=clientSocket.getOutputStream();
			OutputStreamWriter writer=new OutputStreamWriter(os);
			writer.write("HTTP/1.1 200 OK\r\n");
			writer.write("\r\n");
			writer.flush();
			
			
			//粗暴认为有?就表示GET请求带有参数,获取动态请求
			if (fileName.contains("?")) {
				if (fileName.startsWith("/add?")) {
					//匹配GET后面有i和j的两个参数的正则表达式
					Pattern pattern=Pattern.compile(
							"i=(\\d+)&j=(\\d+) HTTP/1\\.1");
					Matcher matcher=pattern.matcher(firstLine);
					if (matcher.find()) {
						int i=Integer.parseInt(matcher.group(1));
						int j=Integer.parseInt(matcher.group(2));
						System.out.println("i="+i+",j="+j);
						int r=i+j;
						writer.write("<html><tile><tile/><body>");
						writer.write(i+"+"+j+"="+r);
						writer.write("<body/><html/>");
					}
				}
				
			}else {
				File file=new File("H:\\test",fileName);
				if (file.exists()&&file.isFile()) {//如果存在并且是文件
					FileInputStream fileis=new FileInputStream(file);
					copy(is, os);
					fileis.close();
				}else {
					writer.write("文件不存在!!!");
				}
			}
			
			
			writer.close();
			os.close();
			clientSocket.close();
		}
	}
	
	private static void copy(InputStream is,OutputStream os) throws IOException{
		byte []bytes=new byte[1024];
		int len;
		while ((len=is.read(bytes))>0) {
			os.write(bytes, 0, len);
		}
	}
	

}
