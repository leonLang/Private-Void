package vvoid.Void.game;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private  BufferedImage metroid, br_column, br_grass,br_grass1,br_recolor,br,industrial;
	public SpriteSheet() {
		try {
			metroid = ImageIO.read(getClass().getResourceAsStream("textures/metroid.png"));
			br_column = ImageIO.read(getClass().getResourceAsStream("textures/br_column.png"));
			br_grass = ImageIO.read(getClass().getResourceAsStream("textures/br_grass.png"));
			br_grass1 = ImageIO.read(getClass().getResourceAsStream("textures/br_grass1.png"));
			br_recolor = ImageIO.read(getClass().getResourceAsStream("textures/br_recolor.png"));
			br = ImageIO.read(getClass().getResourceAsStream("textures/br.png"));
			industrial = ImageIO.read(getClass().getResourceAsStream("textures/industrial.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Image crop(int x, int y, int width, int height) {
		return metroid.getSubimage(x, y, width, height);
	}
	public Image column(int x, int y, int width, int height) {
		return br_column.getSubimage(x, y, width, height);
	}
	public Image grass(int x, int y, int width, int height) {
		return br_grass.getSubimage(x, y, width, height);
	}
	public Image grass1(int x, int y, int width, int height) {
		return br_grass1.getSubimage(x, y, width, height);
	}
	public Image recolor(int x, int y, int width, int height) {
		return br_recolor.getSubimage(x, y, width, height);
	}
	public Image brdefault(int x, int y, int width, int height) {
		return br.getSubimage(x, y, width, height);
	}
	public Image industria(int x, int y, int width, int height) {
		return industrial.getSubimage(x, y, width, height);
	}
}
