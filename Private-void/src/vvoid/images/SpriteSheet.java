//Leon
package vvoid.images;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	public DrawEnemie dE;
	public DrawPlayer dP;
	public DrawObjekt dO;

	public SpriteSheet() {
		dE = new DrawEnemie();
		dP = new DrawPlayer();
		dO = new DrawObjekt();

	}

}
