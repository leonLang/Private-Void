package pPrivate.Void.game;

import java.awt.Graphics;

public class Enemie {
	private static SpriteSheet sheet = new SpriteSheet();
	public int x;
	private int zaehler;
	public int y;
	private int width;
	private int height;
	private int TextureID;
	private int IDO;	
	public Enemie(int IDO, int x, int y, int rotation, int TextureID) {
		this.x = x;
		this.y = y;
		this.TextureID = TextureID;
		this.IDO = IDO;
		size(IDO);
	}
	private void size(int IDO) {
		switch(IDO) {
		case 1:
			this.IDO = IDO;

			width = 100;
			height = 100;
			//System.out.println(Enemie.IDO);

			break;
		case 2:
			this.IDO = IDO;
			width = 100;
			height = 100;
			break;
			//feel free to add more Dimensions :)
		default:
			width = 0;
			height = 0;
		}
	}
	
	public void drawEnemie(Graphics g) {
		switch(this.IDO) {
		case 1:
			sh(g, 9, 7, 16, 14, 27, 7, 16, 14);
			break;
			
		case 2:
			sh(g, 25, 25, 25, 25, 50, 25, 25, 25);
			//noch en tanzendes Sprit als freude für dich morgen xD
			break;
		}
		
		
		
		if (this.IDO==2) {
			  g.drawRect(x, y, width, height);
		   //   g.drawImage(sheet.crop(25, 25, 25, 25),x,y,width,height,null);
		       
		}
	}
	
	public void sh(Graphics g, int x1, int y1, int w1, int h1, int x2, int y2, int w2, int h2) {
		EnemieMovement.movement(g, x1, y1, w1, h1, x2, y2,w2, h2, x, y, width, height);
	}

}
