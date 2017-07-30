package rn.chat.logic.http;

/**
 * Class represents a HTTP POST request.
 * 
 * @author Felix Bachmann
 *
 */
public class MyHttpPostRequest extends MyHttpRequest {

	/**
	 * Creates a new POST request with a given user and message.
	 * 
	 * @param user
	 *            the user to send the message from
	 * @param message
	 *            the message to send
	 */
	public MyHttpPostRequest(String user, String message) {
		String lineSep = System.lineSeparator();
		Integer contentLength = "message".length() + "user".length() + message.length() + user.length() + 3;
		query = "POST /chat" + " HTTP/1.1" + lineSep + "Host: i72tmdjango.tm.kit.edu" + lineSep
				+ "Content-Type: application/x-www-form-urlencoded" + lineSep + "Content-Length: "
				+ contentLength.toString() + lineSep + lineSep + "user=" + user + "&message=" + message + lineSep
				+ lineSep;
		System.out.println(query);
	}
}
