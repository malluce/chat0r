package rn.chat.logic.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import rn.chat.logic.http.MyHttpPostRequest;

/**
 * Class to write in the chat.
 * 
 * @author Felix Bachmann
 *
 */
public class Writer {
	private Socket tcpSocket;

	/**
	 * Creates a new writer.
	 * 
	 * @param tcpSocket
	 *            the TCP socket the writer uses to write
	 */
	public Writer(Socket tcpSocket) {
		this.tcpSocket = tcpSocket;
	}

	/**
	 * Performs the write action.
	 * 
	 * @param user
	 *            the name of the user
	 * @param message
	 *            the message to be written
	 */
	public void write(String user, String message) {
		try {
			PrintWriter out = new PrintWriter(tcpSocket.getOutputStream(), true);
			MyHttpPostRequest req = new MyHttpPostRequest(user, message);
			out.println(req.getQuery());

			BufferedReader in = new BufferedReader(new InputStreamReader(tcpSocket.getInputStream()));
			String ln;
			while ((ln = in.readLine()) != null) {
				System.out.println(ln);
			}

			// tcpSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
