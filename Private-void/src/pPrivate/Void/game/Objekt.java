package pPrivate.Void.game;

import java.awt.Graphics;

public class Objekt {
	public int x;
	public int y;
	private int width;
	private int height;
	private int TextureID;

	public Objekt(int IDO, int x, int y, int rotation, int TextureID) {
		this.x = x;
		this.y = y;
		this.TextureID = TextureID;
		size(IDO);
	}
	private void size(int IDO) {
		switch(IDO) {
		case 1:
			width = 100;
			height = 100;
			break;
		case 2:
			width = 100;
			height = 200;
			break;
			//feel free to add more Dimensions :)
		default:
			width = 0;
			height = 0;
		}
	}
	public void drawObjects(Graphics g) {
		g.drawRect(x, y, width, height);
	}
}
