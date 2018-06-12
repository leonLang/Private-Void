package vvoid.Void.game;

import vvoid.Void.collision.PlayerColl;
import vvoid.init.main.Camera;

public class Gravity implements Runnable {
	public PlayerColl pC = new PlayerColl();
	int test = 0;

	public Gravity() {
	}

	public void grav() {
		while (test == 0) {
			pC.collPlayer();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (PlayerColl.downP == true) {

			} else {
				Camera.addy(1);
				Game.player.addY(-1);
			}
		}
	}

	@Override
	public void run() {
		grav();

	}
}
