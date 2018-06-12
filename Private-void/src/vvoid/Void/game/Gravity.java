package vvoid.Void.game;

import vvoid.init.main.Camera;
import vvoid.map.objects.EOArrey;

public class Gravity implements Runnable{
	public EOArrey eo = new EOArrey();
	int test = 0;

	public Gravity() {
	}

	
	public void grav() {
		while (test == 0) {
			eo.collPlayer();
			try {
				Thread.sleep(1);
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


	@Override
	public void run() {
		grav();
		
	}
}
