package vvoid.images;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Character {
	private BufferedImage character;
	public Character(int a1) {
		try {
			character = ImageIO.read(getClass().getResourceAsStream("textures/samus.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private BufferedImage chare(int x, int y, int width, int height) {
		return character.getSubimage(x, y, width, height);
	}
}
