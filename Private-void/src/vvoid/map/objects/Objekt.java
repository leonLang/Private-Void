package vvoid.map.objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import vvoid.Void.game.Game;
import vvoid.Void.game.SpriteSheet;
import vvoid.init.main.TextureSystem;

public class Objekt {
	public int x;
	public int y;
	private int width;
	private int height;
	private int TextureID;
	private int IDO;
	private int rotation;
	private Image o1,o2,o3,o4,o5,o6,o7,o8,e;
	public EnemieMovement move = new EnemieMovement();
	//private SpriteSheet sheet = new SpriteSheet();
	private BufferedImage img;
	public EOArrey eo = new EOArrey();

	public Objekt(int[] data) {
		this.IDO = data[1];
		this.x = data[2];
		this.y = data[3];
		this.width = data[4];
		this.height = data[5];
		this.rotation = data[6];
		this.TextureID = data[7];
		objectPos();
		img = TextureSystem.textureSystem(TextureID);
		// EOArrey.Objekt(this.width, this.height, this.x, this.y);
		eo.Objekt(width, height, x, y);
	}

	public void drawObjects(Graphics g) {
		
		switch (this.TextureID) {
		case 0:
			g.drawImage(e, x, y, width, height, null);
			//g.drawRect(x, y, width, height);
			//g.drawImage(img, x, y, width, height, null);
			break;

		case 1:
			System.out.println("hi13");
			//g.drawImage(sheet.crop(9, 7, 15, 14), x, y, width, height, null);
			g.drawRect(x, y, width, height);
			break;
			
		case 2:
			g.drawImage(e, x, y, width, height, null);
		}

	}
	private void objectPos(){
		e = Game.sheet.crop(13, 25, 18, 28);
	}
	public void sh(Graphics g, Image a1, Image a2) {
		eo.EnemyR();
		eo.CollPlayer();
		x = eo.x;
		y = eo.y;
		// y = EOArrey.y1;
		// x = EOArrey.x1;
		move.movement(g, a1, a2, x, y, width, height);
	}

}
