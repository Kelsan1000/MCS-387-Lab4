
import java.io.*;

public class HttpResponse {

	HttpRequest req;
	
	String response;
	
	String root = "root";
	
	public HttpResponse(HttpRequest request) {
		req  = request;
		//open the file from the request
		File file = new File(root + req.filename);
		
		try {
			//read the file
			
			response = "HTTP/1.1 200 \r\n"; //200 means everything is okay
			
			response += "Server: Our Java Server/1.0 \r\n"; //identity of server
			response += "Content-Type: text/html \r\n"; //response is in html format
			response += "Connection: close \r\n"; //tells browser close the connection
			response += "Content-Length: " + file.length() + " \r\n"; //length of response file
			response += "\r\n"; //after blank line need to append file data
			FileInputStream fis = new FileInputStream(file);
			int i;
			while ((i = fis.read()) !=- 1) {
				response += (char) i;
			}
			fis.close();
		} 
		//error 404 FILE NOT FOUND
		catch (FileNotFoundException e) {
			response = response.replace("200", "404");
		}
		//error 500 SERVER ISSUE
		catch(Exception e) {
			response = response.replace("200", "500");
		}
			
	}
}








