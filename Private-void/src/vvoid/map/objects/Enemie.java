package vvoid.map.objects;

import java.awt.Graphics;
import java.awt.Image;

import vvoid.Void.game.SpriteSheet;
import vvoid.init.main.Collision;

public class Enemie {
	public EnemieMovement move = new EnemieMovement();
	public EOArrey eo = new EOArrey();
	public Collision coll,coll1;
	private  SpriteSheet sheet = new SpriteSheet();
	public static int[] widthA = new int[100];
	public int x;
	private Image c,d,e,f;
	public static int zaehler,zaehler1;
	public int y;
	private int width;
	private int height;
	private int IDO;	
	public int zA;
	public Enemie(int[] data) {
		spritePos();
		this.IDO = data[7];
		this.x = data[2]+3;
		this.y = data[3]+16;
		this.width = data[4]-16;
		this.height = data[5]-16;
		eo.EnemyS(width, height, x, y);
		move.test();
	}

	public void drawEnemie(Graphics g) {
		
		switch(this.IDO) {
				case 1:
					sh(g,c,d);
					break;
					
				case 2:
					sh(g,e,f);
					break;
		 		}
	}
	
	
	public void sh(Graphics g, Image a1, Image a2) {
	
	eo.EnemyR(x,y);
	y= EOArrey.y1;
	x= EOArrey.x1;
		move.movement(g,a1,a2, x, y, width, height);
			}
	private void spritePos() {
		c = sheet.crop(9, 7, 16, 14);
		d = sheet.crop(27, 7, 16, 14);
		e = sheet.crop(25, 25, 25, 25);
		f = sheet.crop(50, 25, 25, 25);
	}

}
