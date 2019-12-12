
public class HttpRequest {
	
	String filename;
	
	//constructor that accepts a string
	public HttpRequest(String request) {
		//only need the first line the GET / HTTP...
		String lines[] = request.split("\n");
		filename = lines[0].split(" ")[1];
		if (filename.endsWidth("/")){
			filename += "index.html";
		}
		
	}

}










