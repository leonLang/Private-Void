package vvoid.Void.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import vvoid.init.main.Camera;
import vvoid.init.main.Main;

public class Control implements KeyListener{
	public Control() {
		System.out.print("hi");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//Menue Control
		if(Main.menu) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				Main.menue.loadinto();
			} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				if(Menue.MenueNumber > 1) {
					System.out.println(Menue.MenueNumber);
					Menue.MenueNumber--;
					Main.menue.ChangeOption(Menue.MenueNumber,-1);
				} else {
					
				}
			} else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if(Menue.MenueNumber < 3) {
					System.out.println(Menue.MenueNumber);
					Menue.MenueNumber++;
					Main.menue.ChangeOption(Menue.MenueNumber,1);
					
				} else {
					System.out.println("l�uft");
				}
			}
		}else
		//Ingame Control
		{
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Game.move = true;
			Camera.add(10);
		}	
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