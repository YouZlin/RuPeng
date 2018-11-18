package lesson3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyStaticServer {
	private static MyStaticServer myStaticServer;
	public static void main(String[] args) throws IOException {
		myStaticServer=new MyStaticServer();
		myStaticServer.startServer();
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
			
			File file=new File("H:\\test",fileName);
			if (file.exists()&&file.isFile()) {//如果存在并且是文件
				FileInputStream fileis=new FileInputStream(file);
				copy(is, os);
				fileis.close();
			}else {
				writer.write("文件不存在!!!");
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
