package vvoid.images;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	public DrawEnemie dE;
	public DrawPlayer dP;
	public DrawObjekt dO;
	public BufferedImage[] brD = new BufferedImage[100], brG = new BufferedImage[100], brR = new BufferedImage[100];

	public SpriteSheet() {
		dE = new DrawEnemie();
		dP = new DrawPlayer();
		dO = new DrawObjekt();

	}

}
