package vvoid.init.main;

import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

import pPrivate.Void.game.Enemie;
import pPrivate.Void.game.Game;
import pPrivate.Void.game.Objekte;

public class DrawPanel extends JPanel{

	private static final long serialVersionUID = -7664245199454481726L;
	public DrawPanel() {
		
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Game.draw(g);
		Objekte.enemy1(200, 200, g);
		Objekte.enemy2(200, 100, g);
		//x geht nach links und y nach unten
		Enemie.createEnemie(1);
		System.out.println(Enemie.x2);
		Toolkit.getDefaultToolkit();
	}

}