package rn.chat.gui.elements;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

/**
 * The main window containing all GUI elements.
 * 
 * @author Felix Bachmann
 *
 */
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 8642231420001008515L;
	private ChatArea chatArea;
	private MessageArea messageArea;
	private MainPanel mainPane;
	private SubmitButton submitButton;
	private MyMenuBar menuBar;

	/**
	 * Creates a new MainFrame instance.
	 */
	public MainFrame() {
		super("chat0r client");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(450, 500));

		mainPane = new MainPanel();
		mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.PAGE_AXIS));

		menuBar = new MyMenuBar(this);
		mainPane.add(menuBar);

		chatArea = new ChatArea();
		mainPane.add(chatArea);

		messageArea = new MessageArea();
		mainPane.add(messageArea);

		submitButton = new SubmitButton(this);
		mainPane.add(submitButton);

		this.add(mainPane);
		this.pack();
	}

	/**
	 * Getter for chatArea.
	 * 
	 * @return the chat area
	 */
	public ChatArea getChatArea() {
		return chatArea;
	}

	/**
	 * Getter for messageArea.
	 * 
	 * @return the message area
	 */
	public MessageArea getMessageArea() {
		return messageArea;
	}

	/**
	 * Getter for submitButton
	 * 
	 * @return the submit button
	 */
	public SubmitButton getSubmitButton() {
		return submitButton;
	}
}
