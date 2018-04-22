package vvoid.Void.game;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private  BufferedImage metroid;

	
	public SpriteSheet() {
		try {
			metroid = ImageIO.read(getClass().getResourceAsStream("metroid.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("zu oft");
	}
	
	public Image crop(int x, int y, int width, int height) {
		System.out.println("zu oft");
		return metroid.getSubimage(x, y, width, height);
	}
}
