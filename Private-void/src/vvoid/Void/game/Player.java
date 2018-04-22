package vvoid.Void.game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import vvoid.init.main.Camera;

public class Player implements KeyListener {
	public Player() {

	}

	public void drawPlayer(Graphics g) {
		g.drawRect(200, 200, 100, 100);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Camera.add(10);
			Game.move = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		Game.move = false;

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}
