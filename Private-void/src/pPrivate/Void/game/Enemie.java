package pPrivate.Void.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemie {
	private static SpriteSheet sheet = new SpriteSheet();
	public int x;
	public int y;
	private int width;
	private int height;
	private int TextureID;

	
	public Enemie(int IDO, int x, int y, int rotation, int TextureID) {
		this.x = x;
		this.y = y;
		this.TextureID = TextureID;
		größe(IDO);
	}
	private void größe(int IDO) {
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

	public void drawEnemie(Graphics g) {
        g.drawRect(x, y, width, height);
       // g.drawImage(sheet.crop(0, 0, 32, 32),100,100,100,100,null);
		
	}

}
