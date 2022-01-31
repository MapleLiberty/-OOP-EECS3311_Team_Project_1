package view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * View class that displays menu options such as New game, Exit, Pause, or Resume
 * @author Group 1
 *
 */
public class GameMenuBar extends JMenuBar {

	/**
	 * Creates GameMenuBar and add the parameter ActionListener to it.
	 * @param menubarListener actionListener to be added to the gameMenuBar
	 */
	public GameMenuBar(ActionListener menubarListener) {
		super();
		JMenu gameMenu = new JMenu("Game");
		gameMenu.add(createMenuItem("New game", "NEW", KeyEvent.VK_N, menubarListener));
		gameMenu.addSeparator();
		gameMenu.add(createMenuItem("Exit", "EXIT", KeyEvent.VK_Q, menubarListener));
		super.add(gameMenu);
		JMenu controlMenu = new JMenu("Control");
		controlMenu.add(createMenuItem("Pause", "PAUSE", KeyEvent.VK_P, menubarListener));
		controlMenu.add(createMenuItem("Resume", "RESUME", KeyEvent.VK_R, menubarListener));
		super.add(controlMenu);
	}

	/**
	 * Returns menu item created with the parameters.
	 * @param text text of the menu item
	 * @param actionCommand actionCommand of the menu item
	 * @param accelerator shortcut key of the menu item
	 * @param listener actionListener of the menu item
	 * @return menu item created with the parameters
	 */
	private JMenuItem createMenuItem(String text, String actionCommand, int accelerator, ActionListener listener) {
		JMenuItem menuItem = new JMenuItem(text);
		menuItem.setActionCommand(actionCommand);
		menuItem.addActionListener(listener);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(accelerator, 0));
		return menuItem;
	}

}
