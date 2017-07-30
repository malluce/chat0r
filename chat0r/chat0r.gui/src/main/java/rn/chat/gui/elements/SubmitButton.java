package rn.chat.gui.elements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;

import rn.chat.logic.io.Writer;
import rn.chat.logic.tcp.TcpConnector;

/**
 * Represents the button which is used to submit a message.
 * 
 * @author Felix Bachmann
 *
 */
public class SubmitButton extends JButton {
	private static final long serialVersionUID = 320717772218358720L;
	private String userName = "huehue";

	/**
	 * Creates a new submit button.
	 * 
	 * @param mf
	 *            the main frame
	 */
	public SubmitButton(final MainFrame mf) {
		super("Submit message");
		this.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					Writer wr = new Writer(new TcpConnector("i72tmdjango.tm.kit.edu", 8000).createSocket());
					wr.write(userName, mf.getMessageArea().getText());
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}

		});
	}

	/**
	 * Setter..
	 * 
	 * @param userName
	 *            new name..
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
