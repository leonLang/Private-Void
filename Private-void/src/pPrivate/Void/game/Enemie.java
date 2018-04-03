package pPrivate.Void.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemie {
	private static BufferedImage metroid;
	private static SpriteSheet sheet;
	
	public Enemie() {
		try {
			metroid = ImageIO.read(getClass().getResourceAsStream("metroid.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void enemieType1(int x, int y, Graphics g) {
		sheet = new SpriteSheet(metroid);
        g.drawRect(100, 100, 100, 100);
        g.drawImage(sheet.crop(0, 0, 32, 32),100,100,100,100,null);
    }

}
