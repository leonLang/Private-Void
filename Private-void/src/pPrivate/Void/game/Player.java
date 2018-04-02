package pPrivate.Void.game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import vvoid.init.main.Camara;

public class Player extends Game implements KeyListener{
	public Player() {
		
	}
	public static void drawPlayer(Graphics g) {
		g.drawRect(200, 200, 100, 100);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			System.out.println("hi");
			Camara.add(10);
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			System.out.println("hi");
			Camara.add(10);
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			System.out.println("hi");
			Camara.add(10);
		}
		
	}
}
