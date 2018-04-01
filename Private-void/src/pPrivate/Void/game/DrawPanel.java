package pPrivate.Void.game;

import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawPanel extends JPanel{
	public DrawPanel() {
		
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Game.draw(g);
	}

}
