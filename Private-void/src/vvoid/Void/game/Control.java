package vvoid.Void.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import vvoid.init.main.Camera;

public class Control implements KeyListener{
	public Control() {
		System.out.print("hi");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("es geht");
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Game.move = true;
			Camera.add(10);
		}		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Game.move = false;
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
