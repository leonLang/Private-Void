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
		if (zaehler <= 50) {
			zaehler = zaehler +1;
		}
		else {
			zaehler=0;
		}
		if (this.IDO == 1) {
			if(zaehler > 25) {
        g.drawRect(x, y, width, height);
        g.drawImage(sheet.crop(9, 7, 16, 14),x,y,width,height,null);
       // g.drawImage(sheet.crop(0, 0, 32, 32),100,100,100,100,null);
			}
        if (zaehler < 25) {
            g.drawRect(x, y, width, height);
            g.drawImage(sheet.crop(27, 7, 16, 14),x,y,width,height,null);
       
		}
		}
	
		
		
		if (this.IDO==2) {
			  g.drawRect(x, y, width, height);
		      g.drawImage(sheet.crop(25, 25, 25, 25),x,y,width,height,null);
		       
		}
	}


}
