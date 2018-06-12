package vvoid.Void.collision;

import vvoid.init.main.Collision;

public class ShotColl {

	private int width, height, x, y;
	private Collision coll;
	private int counterE;
	private boolean shutdown;
	public static int destroy = 10000;

	public ShotColl(int width, int height, int x, int y) {

		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}

	public boolean shotColl() {
		counterE = EOArrey.eAmount;
		while (counterE >= 0) {
			coll = new Collision(x, y, width, height, EOArrey.xE[counterE], EOArrey.yE[counterE],
					EOArrey.widthE[counterE], EOArrey.heightE[counterE]);
			if (coll.Coll1() == true) {
				destroy = counterE;
				System.out.println(counterE);
				shutdown = true;
				counterE = -1;

			}
			counterE--;
		}
		if (shutdown == true) {
			return true;
		} else {
			return false;
		}
	}
}
