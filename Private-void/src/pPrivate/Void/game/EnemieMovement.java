package pPrivate.Void.game;

import java.awt.Graphics;

public class EnemieMovement {
	static int zaehler =0;
	static int z1 = 100;
	private static SpriteSheet sheet = new SpriteSheet();
	
	public static void movement(Graphics g,int x1,int y1,int w1,int h1,int x2, int y2, int w2, int h2,int x,int y,int width,int height){
		if (zaehler <= z1) {
			zaehler = zaehler +1;
		}
		else {
			zaehler=0;
		}
		if(zaehler > z1/2) {
	        g.drawRect(x, y, width, height);
	        g.drawImage(sheet.crop(x1, y1, w1, h1),x,y,width,height,null);
	       // g.drawImage(sheet.crop(0, 0, 32, 32),100,100,100,100,null);
				}
	        if (zaehler <= z1/2) {
	            g.drawRect(x, y, width, height);
	            g.drawImage(sheet.crop(x2, y2, w2, h2),x,y,width,height,null);
	       
			}
			}
	}

