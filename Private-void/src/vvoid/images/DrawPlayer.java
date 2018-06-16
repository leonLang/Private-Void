package vvoid.images;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DrawPlayer {
	private BufferedImage character;
	public BufferedImage[] sam = new BufferedImage[100];
	public DrawPlayer() {
		try {
			character = ImageIO.read(getClass().getResourceAsStream("textures/samus.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	private BufferedImage chare(int x, int y, int width, int height) {
		return character.getSubimage(x, y, width, height);
	}
}
