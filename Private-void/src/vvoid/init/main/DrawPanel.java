package vvoid.init.main;

import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JPanel;

import vvoid.Void.game.Game;

public class DrawPanel extends JPanel {
	private static final long serialVersionUID = -7664245199454481726L;

	public DrawPanel() {

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Game.draw(g);
		Toolkit.getDefaultToolkit();
	}

}