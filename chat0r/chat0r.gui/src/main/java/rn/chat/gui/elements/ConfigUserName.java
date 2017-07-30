package rn.chat.gui.elements;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Representing the frame used to change user name.
 * 
 * @author Felix Bachmann
 *
 */
public class ConfigUserName extends JFrame {
	private static final long serialVersionUID = -4695202752536399339L;
	private JPanel mainPane;
	private JTextField userName;
	private JButton configButton;

	/**
	 * Creates a new instance.
	 * 
	 * @param mf
	 *            the main frame the instance "is part of"
	 */
	public ConfigUserName(final MainFrame mf) {
		super("Change username");

		mainPane = new MainPanel();
		mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.LINE_AXIS));

		userName = new JTextField();
		mainPane.add(userName);

		configButton = new JButton("Use this name");
		configButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SubmitButton smb = mf.getSubmitButton();
				smb.setUserName(userName.getText());
				ConfigUserName.this.dispose();
			}

		});
		mainPane.add(configButton);

		mainPane.setPreferredSize(new Dimension(300, 50));

		this.add(mainPane);

		this.setPreferredSize(new Dimension(300, 100));
		this.setMinimumSize(new Dimension(300, 100));
	}
}
