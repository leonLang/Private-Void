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
				case 4:
					(new Thread(new Editor())).start();
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
				if (Menue.MenueNumber < 4) {
					Menue.MenueNumber++;
					Main.menue.ChangeOption(Menue.MenueNumber, 1);

				} else {
				}
			}
		} else if (Main.menu != true) {
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
				while (Game.player.u != true) {
					Game.player.d = false;
					Game.player.u = true;
					Game.player.Move("u");
				}

			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				while (Game.player.d != true) {
					Game.player.u = false;
					Game.player.d = true;
					Game.player.Move("d");
				}

			}
			if (e.getKeyCode() == KeyEvent.VK_Y) {

			}
			if (e.getKeyCode() == KeyEvent.VK_X) {
				Game.player.shoot();

			}
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {

			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(Main.menu != true) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Game.player.l = false;
			Game.player.waitl = false;

		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Game.player.r = false;
			Game.player.waitr = false;


			}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Game.player.u = false;
			Game.player.waitu = false;


			}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Game.player.d = false;
			Game.player.waitd = false;


			}
		}
		//Game.move = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
