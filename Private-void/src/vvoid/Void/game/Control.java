package vvoid.Void.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import vvoid.init.main.Camera;
import vvoid.init.main.Main;

public class Control implements KeyListener, Runnable {
	public Control() {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// Menue Control
		if (Main.menu) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				switch (Menue.MenueNumber) {
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
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (Menue.MenueNumber > 1) {
					Menue.MenueNumber--;
					Main.menue.ChangeOption(Menue.MenueNumber, -1);
				} else {

				}
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (Menue.MenueNumber < 3) {
					Menue.MenueNumber++;
					Main.menue.ChangeOption(Menue.MenueNumber, 1);

				} else {
				}
			}
		} else if (Main.running) {
			Game.move = true;
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				while (Game.player.l != true) {
					Game.player.r = false;
					Game.player.l = true;
					Game.player.Move("l");
				}

			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				while (Game.player.r != true) {
					Game.player.l = false;
					Game.player.r = true;
					Game.player.Move("r");
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				Camera.addy(-10);
				Game.player.UP();

			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				Camera.addy(10);
				Game.player.DOWN();

			}
			if (e.getKeyCode() == KeyEvent.VK_Y) {

			}
			if (e.getKeyCode() == KeyEvent.VK_X) {

			}
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {

			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		Game.move = false;
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Game.player.l = false;

		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Game.player.r = false;

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
