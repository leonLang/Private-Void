//Leon
/*
 * Normalerweise hätte Peter diese Klasse bzw. diesen Teil des Programms erledigt, doch er
 * war zu inkompetent eine einfache gravitation einzubauen, die nicht alles zur eskalation bringt.
 * Made by Peter
 */

package vvoid.Void.game;

import vvoid.Void.collision.PlayerColl;
import vvoid.init.main.Camera;

public class Gravity implements Runnable {
	private PlayerColl pC = new PlayerColl();
	private boolean loop;

	public Gravity() {
	}

	public void grav() {
		while (loop != true) {
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
