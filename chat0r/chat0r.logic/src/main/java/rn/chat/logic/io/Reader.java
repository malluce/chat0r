package rn.chat.logic.io;

import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimerTask;

import rn.chat.logic.http.MyHttpGetRequest;
import rn.chat.logic.tcp.TcpConnector;

/**
 * Class which reads.
 * 
 * @author Felix Bachmann
 *
 */
public class Reader extends TimerTask {
	private ArrayList<String> lastMessages;
	private Socket tcpSocket;
	private TextArea chatArea;

	/**
	 * Creates a new Reader.
	 * 
	 * @param tcpSocket
	 *            the socket which is used by the reader to read
	 * @param chatArea
	 *            area to send the messages to
	 */
	public Reader(Socket tcpSocket, TextArea chatArea) {
		lastMessages = new ArrayList<String>();
		this.tcpSocket = tcpSocket;
		this.chatArea = chatArea;
	}

	@Override
	public void run() {
		try {
			tcpSocket = new TcpConnector("i72tmdjango.tm.kit.edu", 8000).createSocket();
			PrintWriter out = new PrintWriter(tcpSocket.getOutputStream(), true);
			MyHttpGetRequest req = new MyHttpGetRequest("chat");
			out.println(req.getQuery());
			BufferedReader in = new BufferedReader(new InputStreamReader(tcpSocket.getInputStream()));
			String ln;
			while ((ln = in.readLine()) != null) {
				if (ln.startsWith("[") && !lastMessages.contains(ln)) {
					System.out.println(ln);
					lastMessages.add(ln);
				}
			}

			System.out.println(lastMessages.size());

			String conc = "";
			Iterator<String> itr = lastMessages.iterator();
			int i = 0;
			while (itr.hasNext()) {
				String str = itr.next();
				System.out.println(str);
				if (i != 0 && str.startsWith("[")) {
					conc += System.lineSeparator();
				}
				conc += str;
				i++;
			}

			chatArea.setText(conc);
			chatArea.repaint();
			chatArea.revalidate();
			// tcpSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Getter for lastMesages.
	 * 
	 * @return the last messages
	 */
	public ArrayList<String> getLastMessages() {
		return lastMessages;
	}

}
