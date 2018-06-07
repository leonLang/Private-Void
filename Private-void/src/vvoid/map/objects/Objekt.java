package vvoid.map.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import vvoid.init.main.TextureSystem;

public class Objekt {
	public int x;
	public int y;
	private int width;
	private int height;
	private int TextureID;
	private int IDO;
	private int rotation;
	private BufferedImage img;
	public EOArrey eo = new EOArrey();

	public Objekt(int[] data) {
		this.IDO = data[1];
		this.x = data[2];
		this.y = data[3];
		this.width = data[4];
		this.height = data[5];
		this.rotation = data[6];
		this.TextureID = data[7];
		img = TextureSystem.textureSystem(TextureID);
		// EOArrey.Objekt(this.width, this.height, this.x, this.y);
		eo.Objekt(width, height, x, y);
	}

	public void drawObjects(Graphics g) {
		switch (this.IDO) {
		case 1:
			g.drawRect(x, y, width, height);
			g.drawImage(img, x, y, width, height, null);
			break;

		case 2:
			g.drawRect(x, y, width, height);
			break;
		}

	}
}
