//Peter & Leon
package vvoid.init.main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame extends JFrame {

	private static final long serialVersionUID = 9019603114311641540L;

	public Frame(int WIDTH, int HEIGHT, String title, boolean Resizable) {
		Main.panel = new DrawPanel();
		add(Main.panel);
		addKeyListener(Main.control);
		// get screen size
		setFocusable(true);
		this.requestFocusInWindow();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWIDTH = (int) screen.getWidth();
		int screenHEIGHT = (int) screen.getHeight();

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(screenWIDTH / 2 - WIDTH / 2, screenHEIGHT / 2 - HEIGHT / 2);

		setTitle(title);
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setVisible(true);

	}

}
