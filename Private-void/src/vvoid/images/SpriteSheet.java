package vvoid.images;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private  BufferedImage br_grass, br_recolor, br, character;
	public DrawEnemie dE;
	public BufferedImage[] brD = new BufferedImage[100], brG = new BufferedImage[100], brR = new BufferedImage[100], sam = new BufferedImage[100];
	private int x, y;

	public SpriteSheet() {
		dE = new DrawEnemie();
		try {
			br_grass = ImageIO.read(getClass().getResourceAsStream("textures/br_grass.png"));
			// br_grass1 =
			// ImageIO.read(getClass().getResourceAsStream("textures/br_grass1.png"));
			br_recolor = ImageIO.read(getClass().getResourceAsStream("textures/br_recolor.png"));
			br = ImageIO.read(getClass().getResourceAsStream("textures/br.png"));
			character = ImageIO.read(getClass().getResourceAsStream("textures/samus.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 20; i++) {
			brD[i] = brdefault(x, y, 50, 50);
			brG[i] = grass(x, y, 50, 50);
			brR[i] = recolor(x, y, 50, 50);
			if (x == 200) {
				x = 0;
				y = y + 50;
			} else {
				x = x + 50;
			}

		}
		
		sam[0] = chare(190, 1010, 40, 45);
		sam[1] = chare(140, 1010, 40, 45);
		sam[2] = chare(90, 1010, 40, 45);
		sam[3] = chare(40, 1010, 40, 45);
		sam[4] = chare(240, 1010, 40, 45);
		sam[5] = chare(290, 1010, 40, 45);
		sam[6] = chare(340, 1010, 40, 45);
		sam[7] = chare(190, 308, 40, 45);
		sam[8] = chare(240, 308, 40, 45);
		sam[9] = chare(40, 308, 40, 45);
		sam[10] = chare(40, 503, 40, 45);
		
	}


	private BufferedImage grass(int x, int y, int width, int height) {
		return br_grass.getSubimage(x, y, width, height);
	}

	private BufferedImage recolor(int x, int y, int width, int height) {
		return br_recolor.getSubimage(x, y, width, height);
	}

	private BufferedImage brdefault(int x, int y, int width, int height) {
		return br.getSubimage(x, y, width, height);
	}

	private BufferedImage chare(int x, int y, int width, int height) {
		return character.getSubimage(x, y, width, height);
	}

}
