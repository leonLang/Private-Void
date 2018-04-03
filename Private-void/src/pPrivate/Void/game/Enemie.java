package pPrivate.Void.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemie {
	private static BufferedImage metroid;
	public Enemie() {
		try {
			metroid = ImageIO.read(getClass().getResourceAsStream("metroid.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void enemieType1(int x, int y, Graphics g) {
        g.drawRect(100, 100, 100, 100);
        g.drawImage(metroid,100,100,100,100,null);
    }

}
