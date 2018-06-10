package vvoid.Void.game;

import vvoid.init.main.Camera;
import vvoid.map.objects.EOArrey;

public class Gravity {
	int test = 0;

	public Gravity() {
	}

	public void Grav() {
		while (test == 0) {
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (EOArrey.downP == true) {

			} else {
				Camera.addy(1);
				Game.player.addY(-1);
			}
		}
	}
}
