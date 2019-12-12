
import java.io.*;
import java.net.*;

public class HttpServer {
	
	ServerSocket serverSocket;
	
	public static void main(String[] args) throws IOException {
		new HttpServer().runServer();
	}
	
	public void runServer() throws IOException {
		System.out.println("Server is started");
		serverSocket = new ServerSocket(8082);
		
		acceptRequests();
	}
	
	private void acceptRequests() throws IOException {
		while(true) { //accepts all request
			Socket socket = serverSocket.accept();
			ConnectionHandler ch = new ConnectionHandler(socket);
			
			ch.start();
		}
	}

}












