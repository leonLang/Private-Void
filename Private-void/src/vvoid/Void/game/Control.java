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
				switch(Menue.MenueNumber) {
				case 1:
					Main.menue.loadinto();
					break;
				case 2:
					break;
				case 3:
					break;
				default:
					break;
				}
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
					System.out.println("läuft");
				}
			}
		}else if(Main.running) {
			Game.move = true;
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				Camera.addx(-10);
				
			}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				Camera.addx(10);
				
			}
			else if(e.getKeyCode() == KeyEvent.VK_UP) {
				Camera.addy(-10);
				
			}
			else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				Camera.addy(10);
	
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
