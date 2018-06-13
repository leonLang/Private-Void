package vvoid.Void.collision;

import vvoid.init.main.Collision;

public class ShotColl {

	private int width, height, x, y;
	private Collision coll;
	private int counterE, counterO;
	private boolean shutdown;
	public static int destroy = 10000;

	public ShotColl(int width, int height, int x, int y) {

		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}

	public boolean shotColl() {
		counterE = EnemieColl.eAmount;
		while (counterE >= 0) {
			coll = new Collision(x, y, width, height, EnemieColl.xE[counterE], EnemieColl.yE[counterE],
					EnemieColl.widthE[counterE], EnemieColl.heightE[counterE]);
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

	public boolean shotCollBlock() {
		counterO = ObjektColl.oAmount;
		while (counterO >= 0) {
			coll = new Collision(ObjektColl.xO[counterO], ObjektColl.yO[counterO], ObjektColl.widthO[counterO],
					ObjektColl.heightO[counterO], x, y,
					width, height);
			if (coll.Coll1() == true) {
				destroy = counterO;
				System.out.println(counterO);
				shutdown = true;
				counterO = -1;

			}
			counterO--;
		}
		if (shutdown == true) {
			return true;
		} else {
			return false;
		}
	}
}
