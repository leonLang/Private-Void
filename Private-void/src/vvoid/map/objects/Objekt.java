//Peter & Leon
package vvoid.map.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import vvoid.Void.collision.ObjektColl;
import vvoid.Void.game.Game;

public class Objekt {
	private int width, height, x, y;
	private int TextureID;
	public ObjektColl oC;

	public Objekt(int[] data) {
		this.x = data[2];
		this.y = data[3];
		this.width = data[4];
		this.height = data[5];
		this.TextureID = data[7];
		oC = new ObjektColl(width, height, x, y);
	}

	public void drawObjects(Graphics g) {

		for (int i = 1; i < 61; i++) {
			if (this.TextureID == i) {
				if (this.TextureID <= 20) {
					ft(Game.sheet.dO.brD[i - 1], g);
				} else if (this.TextureID <= 40) {
					ft(Game.sheet.dO.brG[i - 21], g);
				} else if (this.TextureID <= 60) {
					ft(Game.sheet.dO.brR[i - 41], g);
				}

			}
		}

	}

	private void ft(BufferedImage img, Graphics g) {
		g.drawImage(img, x, y, width, height, null);
	}

}
