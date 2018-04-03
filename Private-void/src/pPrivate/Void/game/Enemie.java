package pPrivate.Void.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemie {
	private static SpriteSheet sheet = new SpriteSheet();
	
	public Enemie(int IDO, int x, int y, int rotation, int TextureID) {
		
	}
	public void enemieType1(int x, int y, Graphics g) {

    }

	public void drawEnemie(Graphics g) {
        g.drawRect(100, 100, 200, 100);
        g.drawImage(sheet.crop(0, 0, 32, 32),100,100,100,100,null);
		
	}

}
