package rn.chat.gui.elements;

import java.awt.Dimension;
import java.awt.TextArea;

/**
 * The area where messages can be written by the user.
 * 
 * @author Felix Bachmann
 *
 */
public class MessageArea extends TextArea {
	private static final long serialVersionUID = 1509359687098725290L;

	/**
	 * Creates a new MessageArea.
	 */
	public MessageArea() {
		this.setEditable(true);
		this.setPreferredSize(new Dimension(300, 50));
		this.setMaximumSize(new Dimension(300, 50));
	}
}
