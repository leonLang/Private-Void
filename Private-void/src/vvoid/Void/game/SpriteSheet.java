package vvoid.Void.game;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private  BufferedImage metroid;
	private SpriteSheet sheet = new SpriteSheet();
	
	public SpriteSheet() {
		try {
			metroid = ImageIO.read(getClass().getResourceAsStream("textures/metroid.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Image crop(int x, int y, int width, int height) {
		return metroid.getSubimage(x, y, width, height);
	}
}
