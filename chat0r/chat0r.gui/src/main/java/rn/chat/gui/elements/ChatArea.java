package rn.chat.gui.elements;

import java.awt.Font;
import java.awt.TextArea;

/**
 * Area where the messages of the chat room are displayed.
 * 
 * @author Felix Bachmann
 *
 */
public class ChatArea extends TextArea {
	private static final long serialVersionUID = 5140807280388581584L;

	/**
	 * Creates a new ChatArea.
	 */
	public ChatArea() {
		this.setEditable(false);
		this.setFont(new Font("Arial", Font.PLAIN, 16));
	}
}
