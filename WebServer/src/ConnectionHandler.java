
import java.net.*;
import java.io.*;

//handles connections that contains requests
public class ConnectionHandler extends Thread {
	
	Socket socket;
	
	//sends output to client
	PrintWriter pw;
	
	//gets input from client
	BufferedReader br;
	
	//constructor to accept a socket
	public ConnectionHandler(Socket s) throws IOException {
		this.socket = s;
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(socket.getOutputStream());
	}
	
	@Override
	public void run() {
		
		try {
			//get the request string for HttpRequest 
			String reqString = "";
			
			//file input is ready to be read or is not get
			while(br.ready() || reqString.length() == 0) {
				reqString += (char) br.read(); //want to read in as characters
			}
			System.out.println(reqString); //to see what reqString is for testing
			HttpRequest req = new HttpRequest(reqString);
			//req object to HttpResponse
			HttpResponse res = new HttpResponse(req);
			//write out the output
			pw.write(res.response.toCharArray());
			pw.close();
			br.close();
			socket.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}














