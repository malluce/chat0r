package rn.chat.gui.elements;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Menubar for options etc.
 * 
 * @author Felix Bachmann
 *
 */
public class MyMenuBar extends JMenuBar {
	private static final long serialVersionUID = 4999542987702652815L;
	private JMenu optionsMenu;
	private JMenu aboutMenu;
	private JMenuItem nameItem;;
	private JMenuItem aboutItem;
	private ConfigUserName config;

	/**
	 * Creates a new MenuBar on a current frame.
	 * 
	 * @param mf
	 *            the frame
	 */
	public MyMenuBar(final MainFrame mf) {
		optionsMenu = new JMenu();
		optionsMenu.setText("Options");

		nameItem = new JMenuItem();
		nameItem.setText("Change username");
		nameItem.setMnemonic('C');
		nameItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				config = new ConfigUserName(mf);
				config.setVisible(true);
			}

		});

		optionsMenu.add(nameItem);

		aboutMenu = new JMenu();
		aboutMenu.setText("About..");

		aboutItem = new JMenuItem();
		aboutItem.setText("About..");
		aboutItem.setMnemonic('A');

		aboutMenu.add(aboutItem);

		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		this.add(optionsMenu);
		this.add(aboutMenu);

		this.setPreferredSize(new Dimension(450, 20));
		this.setMaximumSize(new Dimension(450, 20));
		this.setVisible(true);
	}
}
