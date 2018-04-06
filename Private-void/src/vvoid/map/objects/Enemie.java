package vvoid.map.objects;

import java.awt.Graphics;

import vvoid.Void.game.SpriteSheet;

public class Enemie {
	private static SpriteSheet sheet = new SpriteSheet();
	public  int[] widthA;
	public int x;
	private int zaehler;
	public int y;
	private int width;
	private int height;
	private int TextureID;
	private int IDO;	
	public Enemie(int[] data) {
		this.IDO = data[1];
		this.x = data[2];
		this.y = data[3];
		this.width = data[4];
		this.height = data[5];
		this.TextureID = data[7];
	}

	public void drawEnemie(Graphics g) {
		widthA[1] =  this.width;
	//	System.out.println(widthA[1]);
		switch(this.IDO) {
				case 1:
					sh(g, 9, 7, 16, 14, 27, 7, 16, 14);
					break;
					
				case 2:
					sh(g, 25, 25, 25, 25, 50, 25, 25, 25);
					//noch en tanzendes Sprit als freude für dich morgen xD
					break;
		 		}
	}
	public void sh(Graphics g, int x1, int y1, int w1, int h1, int x2, int y2, int w2, int h2) {
		EnemieMovement.movement(g, x1, y1, w1, h1, x2, y2,w2, h2, x, y, width, height);
		}

}
