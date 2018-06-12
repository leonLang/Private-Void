package vvoid.Void.collision;

import vvoid.Void.game.Game;
import vvoid.init.main.Collision;

public class PlayerColl {
	private int counterP;
	private Collision coll;
	private int linksP, rechtsP, untenP, obenP;
	public static boolean leftP, rightP, downP, upP;

	public void collPlayer() {
		counterP = ObjektColl.oAmount; // for editing oAmount without change it
		while (counterP >= 0) {
			coll = new Collision(Game.player.x, Game.player.y, Game.player.width, Game.player.height,
					ObjektColl.xO[counterP], ObjektColl.yO[counterP], ObjektColl.widthO[counterP],
					ObjektColl.heightO[counterP]);
			if (coll.CollLinksP() == true) {
				counterP = 0;
				linksP = 1;
			} else {
				linksP = 0;
			}
			counterP--;
		}
		counterP = ObjektColl.oAmount; // for editing oAmount without change it
		while (counterP >= 0) {
			coll = new Collision(Game.player.x, Game.player.y, Game.player.width, Game.player.height,
					ObjektColl.xO[counterP], ObjektColl.yO[counterP], ObjektColl.widthO[counterP],
					ObjektColl.heightO[counterP]);
			if (coll.CollObenP() == true) {
				counterP = 0;
				obenP = 1;
			} else {
				obenP = 0;
			}
			counterP--;
		}
		counterP = ObjektColl.oAmount; // for editing oAmount without change it
		while (counterP >= 0) {
			coll = new Collision(Game.player.x, Game.player.y, Game.player.width, Game.player.height,
					ObjektColl.xO[counterP], ObjektColl.yO[counterP], ObjektColl.widthO[counterP],
					ObjektColl.heightO[counterP]);
			if (coll.CollRechtsP() == true) {
				counterP = 0;
				rechtsP = 1;
			} else {
				rechtsP = 0;
			}
			counterP--;
		}
		counterP = ObjektColl.oAmount; // for editing oAmount without change it
		while (counterP >= 0) {
			coll = new Collision(Game.player.x, Game.player.y, Game.player.width, Game.player.height,
					ObjektColl.xO[counterP], ObjektColl.yO[counterP], ObjektColl.widthO[counterP],
					ObjektColl.heightO[counterP]);
			if (coll.CollUntenP() == true) {
				counterP = 0;
				untenP = 1;
			} else {
				untenP = 0;
			}
			counterP--;
		}

		if (linksP == 1) {
			leftP = true;
		} else {
			leftP = false;
		}
		if (rechtsP == 1) {
			rightP = true;
		} else {
			rightP = false;
		}
		if (untenP == 1) {
			downP = true;
		} else {
			downP = false;
		}
		if (obenP == 1) {
			upP = true;
		} else {
			upP = false;
		}
	}
}
