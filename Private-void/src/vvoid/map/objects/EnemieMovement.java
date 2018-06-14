//Leon
package vvoid.map.objects;

import java.awt.Graphics;
import java.awt.Image;

public class EnemieMovement {
	private int zaehler = 0;
	private int z1 = 50;
	public Image c, d;

	public void movement(Graphics g, Image a1, Image a2, int x, int y, int width, int height) {

		// a1 steht für animation 1
		if (zaehler <= z1) {
			zaehler = zaehler + 1;
		} else {
			zaehler = 0;
		}
		if (zaehler > z1 / 2) {
			g.drawImage(a1, x, y, width, height, null);

		}
		if (zaehler <= z1 / 2) {
			g.drawImage(a2, x, y, width, height, null);

		}
	}
}
