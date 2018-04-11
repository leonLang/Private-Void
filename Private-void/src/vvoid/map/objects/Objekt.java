package vvoid.map.objects;

import java.awt.Graphics;

import vvoid.init.main.TextureSystem;

public class Objekt {
	public int x;
	public int y;
	private int width;
	private int height;
	private int TextureID;
	private int IDO;
	private int rotation;

	public Objekt(int[] data) {
		this.IDO = data[1];
		this.x = data[2];
		this.y = data[3];
		this.width = data[4];
		this.height = data[5];
		this.rotation = data[6];
		this.TextureID = data[7];
		//EOArrey.Objekt(this.width, this.height, this.x, this.y);
	}
	
	public void drawObjects(Graphics g) {
		if(IDO == 1) {
		//g.drawRect(x, y, width, height);
		g.drawImage(TextureSystem.textureSystem(TextureID), x, y, width, height, null);
		} else if(IDO == 2) {
			g.drawRect(x, y, width, height);//
		}

	}
}
