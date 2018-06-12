package vvoid.Void.game;

import java.awt.Graphics;
import vvoid.Void.collision.ShotColl;

public class Shot {
	public String direction;
	public int x;
	public int y;
	public int width;
	public int height;
	public ShotColl sC;

	public Shot(String getfacing, int x, int y) {
		this.direction = getfacing;
		this.x = x;
		this.y = y;
		width = 30;
		height = 30;
	}

	public void draw(Graphics g) {
		// eo.Shot(width, height, x, y);
		sC = new ShotColl(width, height, x, y);
		if (sC.shotColl() == false) {
			sC.shotColl();
			g.drawRect(x, y, width, height);
			calc();
		}
	}

	public void calc() {
		switch (this.direction) {
		case "right":
			x += 10;
			break;
		case "left":
			x -= 10;
			break;
		case "up":
			y -= 10;
			break;
		case "down":
			y += 10;
			break;
		}
	}
}
