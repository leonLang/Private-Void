package pPrivate.Void.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemie {
	private static SpriteSheet sheet;
	
	public Enemie() {
			sheet = new SpriteSheet();
		
	}
	public void enemieType1(int x, int y, Graphics g) {
        g.drawRect(100, 100, 100, 100);
        g.drawImage(sheet.crop(0, 0, 32, 32),100,100,100,100,null);
    }

}
