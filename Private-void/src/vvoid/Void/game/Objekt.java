package vvoid.Void.game;

import java.awt.Graphics;

import vvoid.init.main.TextureSystem;

public class Objekt {
	public int x;
	public int y;
	private int width;
	private int height;
	private int TextureID;
	private int IDO;

	public Objekt(int IDO, int x, int y,int width, int height, int rotation, int TextureID) {
		this.x = x;
		this.y = y;
		this.IDO = IDO;
		this.TextureID = TextureID;
		this.width = width;
		this.height = height;
	}
	
	public void drawObjects(Graphics g) {
		if(IDO == 1) {
		g.drawRect(x, y, width, height);
		g.drawImage(TextureSystem.TextureSystem(TextureID), x, y, width, height, null);
		} else if(IDO == 2) {
			g.drawRect(x, y, width, height);
		}

	}
}
