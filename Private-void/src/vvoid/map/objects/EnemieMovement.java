package vvoid.map.objects;

import java.awt.Graphics;
import java.awt.Image;

import vvoid.Void.game.SpriteSheet;

public class EnemieMovement {
	public int zaehler =0;
	static int z1 = 25;
	private  SpriteSheet sheet = new SpriteSheet();
	public Image c,d;
	public void test() {
		c = sheet.crop(9, 7, 17, 14);
		d = sheet.crop(27, 7, 16, 14);
	}
	public  void movement(Graphics g,Image a1,Image a2,int x,int y,int width,int height){
		//a1 steht für animation 1
		if (zaehler <= z1) {
		zaehler = zaehler +1;
		}
		else {
			zaehler=0;
		}
		if(zaehler > z1/2) {
	       // g.drawRect(x, y, width, height);
	        g.drawImage(a1,x,y,width,height,null);
	        
	       // g.drawImage(sheet.crop(0, 0, 32, 32),100,100,100,100,null);
				}
	        if (zaehler <= z1/2) {
	           // g.drawRect(x, y, width, height);
	g.drawImage(a2,x,y,width,height,null);
	       
			}
			}
		}