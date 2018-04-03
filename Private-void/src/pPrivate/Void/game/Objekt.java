package pPrivate.Void.game;

import java.awt.Graphics;

public class Objekt {
	private static int id;
	public int x;
	public int y;
	public int rotation;
	public int TextureID;
	public Objekt(int IDO, int x, int y, int rotation, int TextureID) {
		this.id = IDO;


	}
	private void checkID(int id) {

	}

	public void drawObjects(Graphics g) {
		System.out.println("geht");
		
	}
}
