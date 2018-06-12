package vvoid.map.objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import vvoid.Void.game.Game;
import vvoid.Void.game.SpriteSheet;
import vvoid.init.main.Main;
import vvoid.init.main.TextureSystem;

public class Objekt {
	public int x;
	public int y;
	private int width;
	private int height;
	private int TextureID;
	private int IDO;
	private int rotation;
	public EnemieMovement move = new EnemieMovement();
	//private SpriteSheet sheet = new SpriteSheet();
	private BufferedImage img;
	public EOArrey eo = new EOArrey();
	
	public Objekt(int[] data) {
			//sth = new Game();
		this.IDO = data[1];
		this.x = data[2];
		this.y = data[3];
		this.width = data[4];
		this.height = data[5];
		this.rotation = data[6];
		this.TextureID = data[7];
		//objectPos();
		//img = TextureSystem.textureSystem(TextureID);
		// EOArrey.Objekt(this.width, this.height, this.x, this.y);
		eo.objekt(width, height, x, y);
	}

	public void drawObjects(Graphics g) {
		
		
		for (int i = 1; i < 61; i++) {
			if(this.TextureID == i) {
				if(this.TextureID <= 20) {
					ft(Game.sheet.brD[i-1], g);
				}
					else if (this.TextureID <= 40) {
						ft(Game.sheet.brG[i-21], g);
					}
					else if (this.TextureID <= 60) {
						ft(Game.sheet.brR[i-41], g);
					}
				
			}
		}
		

	}
	public void ft(BufferedImage img,Graphics g) {
		g.drawImage(img, x, y, width, height, null);
	}

}
