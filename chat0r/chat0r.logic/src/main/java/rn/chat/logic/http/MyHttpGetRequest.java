package rn.chat.logic.http;

/**
 * Class representing a HTTP GET request.
 * @author Felix Bachmann
 *
 */
public class MyHttpGetRequest extends MyHttpRequest {
	
	/**
	 * Creates a new GET request to request a resource.
	 * @param resource the resource to request
	 */
	public MyHttpGetRequest(String resource) {
		String lineSep = System.lineSeparator();
		query = "GET /" + resource + " HTTP/1.1" + lineSep + "Host: i72tmdjango.tm.kit.edu" + lineSep + lineSep; 
	}
	
}
