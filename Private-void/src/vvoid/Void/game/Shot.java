package vvoid.Void.game;

import java.awt.Graphics;

import vvoid.Void.collision.EOArrey;

public class Shot {
	public String direction;
	public int x;
	public int y;
	public int width;
	public int height;
	public EOArrey eo = new EOArrey();

	public Shot(String getfacing, int x, int y) {
		this.direction = getfacing;
		this.x = x;
		this.y = y;
		width = 30;
		height = 30;
	}

	public void draw(Graphics g) {
		// eo.Shot(width, height, x, y);
		if (eo.shotColl(x, y, width, height) == false) {
			eo.shotColl(x, y, width, height);
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
