package rn.chat.logic.tcp;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Class used to connect via Tcp to a certain host on a certain port.
 * 
 * @author Felix Bachmann
 * 
 */
public class TcpConnector {
	private String host;
	private int port;

	/**
	 * Creates a new TcpConnector with a given host and port.
	 * 
	 * @param host
	 *            the host for the new instance
	 * @param port
	 *            the port for the new instance
	 */
	public TcpConnector(String host, int port) {
		this.host = host;
		this.port = port;
	}

	/**
	 * Create a new socket.
	 * 
	 * @throws UnknownHostException
	 *             is thrown if the host is unknown
	 * @throws IOException
	 *             is thrown if an IO error occurs
	 * @return the socket which was created
	 */
	public Socket createSocket() throws UnknownHostException, IOException {
		return new Socket(host, port);
	}

}
