package lesson5;

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

public class MyLoginServer {
	static MyLoginServer loginServer;
	public static void main(String[] args) throws IOException {
		loginServer =new MyLoginServer();
		loginServer.startServer();
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
				if (fileName.startsWith("/login?")) {
					//正则表达式的"非贪婪模式"

					Pattern pattern=Pattern.compile(
							"username=(.+?)&password=(.+?) HTTP/1\\.1");
					Matcher matcher=pattern.matcher(firstLine);
					if (matcher.find()) {
						String username=matcher.group(1);
						String password=matcher.group(2);
						writer.write("<html><tile><tile/><body>");
						if (username.equals("admin")&&password.equals("123")) {
							writer.write("登陆成功");	
						}else {
							writer.write("登陆失败");
						}
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
