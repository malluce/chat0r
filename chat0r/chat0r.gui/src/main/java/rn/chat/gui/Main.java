package rn.chat.gui;

import java.io.IOException;
import java.net.Socket;
import java.util.Timer;

import rn.chat.gui.elements.MainFrame;
import rn.chat.logic.io.Reader;
import rn.chat.logic.tcp.TcpConnector;

/**
 * Main class to start the GUI for chatting.
 * 
 * @author Felix Bachmann
 *
 */
public final class Main {
	private Main() {

	}

	/**
	 * Starts the gui.
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
		mf.setVisible(true);

		Socket tcpSocket;
		try {
			tcpSocket = new TcpConnector("i72tmdjango.tm.kit.edu", 8000).createSocket();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		Timer timer = new Timer();
		timer.schedule(new Reader(tcpSocket, mf.getChatArea()), 0, 5000);
	}

}
