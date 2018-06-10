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
		eo.Objekt(width, height, x, y);
	}

	public void drawObjects(Graphics g) {
		
		for (int i = 1; i < 21; i++) {
			if(this.TextureID == i) {
				ft(Game.sheet.brD[i-1], g);
			}
		}
		/*switch (this.TextureID) {
		
		case 1:
			ft(Game.sheet.brD[0], g);
			break;
			
		case 2:
			ft(Game.sheet.brD[1],g);
			
		case 3:
			ft(Game.sheet.brD[2], g);
			break;
			
		case 4:
			ft(Game.sheet.brD[3],g);
			
		case 5:
			ft(Game.sheet.brD[4], g);
			break;
			
		case 6:
			ft(Game.sheet.brD[5],g);
			
		case 7:
			ft(Game.sheet.brD[6], g);
			break;
			
		case 8:
			ft(Game.sheet.brD[7],g);
			
		case 9:
			ft(Game.sheet.brD[8], g);
			break;
			
		case 10:
			ft(Game.sheet.brD[9],g);
			
		case 11:
			ft(Game.sheet.brD[10], g);
			break;
			
		case 12:
			ft(Game.sheet.brD[11],g);
			
		case 13:
			ft(Game.sheet.brD[12], g);
			break;
			
		case 14:
			ft(Game.sheet.brD[13],g);
			
		case 15:
			ft(Game.sheet.brD[14], g);
			break;
			
		case 16:
			ft(Game.sheet.brD[15],g);
			
		case 17:
			ft(Game.sheet.brD[16], g);
			break;
			
		case 18:
			ft(Game.sheet.brD[17],g);
			
		case 19:
			ft(Game.sheet.brD[18], g);
			break;
			
		case 20:
			ft(Game.sheet.brD[19],g);
		}*/

	}
	public void ft(BufferedImage img,Graphics g) {
		g.drawImage(img, x, y, width, height, null);
	}

}
