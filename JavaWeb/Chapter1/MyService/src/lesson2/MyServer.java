package lesson2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	
	private static MyServer server;

	public static void main(String[] args) throws IOException {
		server=new MyServer();
		server.startServer();
		
	}
	
	private void startServer() throws IOException {
		ServerSocket serverSocket=new ServerSocket(8080);
		while (true) {
			Socket clientSocket=serverSocket.accept();
			OutputStream os=clientSocket.getOutputStream();
			OutputStreamWriter writer=new OutputStreamWriter(os);
			writer.write("HTTP/1.1 200 OK\r\n");
			writer.write("\r\n");
			writer.write("<html><head><title>302 Found</title></head><body bgcolor='white'><h1>302 Found</h1><p>The requested resource resides temporarily under a different URI.</p></body></html>\r\n");
			writer.write("\r\n");
			writer.flush();
			writer.close();
			clientSocket.close();
		}
	}
}
