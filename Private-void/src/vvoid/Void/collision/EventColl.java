//Leon
package vvoid.Void.collision;

import vvoid.Void.game.Game;
import vvoid.init.main.Collision;

public class EventColl {
	private int width, height, x, y;
	private Collision coll;

	public EventColl(int width, int height, int x, int y) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}


	public boolean eventColl() {
		coll = new Collision(Game.player.x, Game.player.y, Game.player.width, Game.player.height, x, y, width, height);
		if (coll.Coll1() == true) {
			return true;
		} else {
			return false;
		}

	}
}
