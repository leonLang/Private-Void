package vvoid.map.objects;

import java.awt.Graphics;

import vvoid.Void.game.SpriteSheet;
import vvoid.init.main.Collision;

public class Enemie {
	public EnemieMovement move = new EnemieMovement();
	public EOArrey eo = new EOArrey();
	private boolean test = true;
	public Collision coll,coll1;
	private static SpriteSheet sheet = new SpriteSheet();
	public static int[] widthA = new int[100];
	public int x;
	public static int zaehler,zaehler1;
	public int y;
	private int width;
	private int height;
	private int TextureID;
	private int IDO;	
	public int zA;
	public Enemie(int[] data) {
		this.IDO = data[7];
		this.x = data[2];
		this.y = data[3];
		this.width = data[4];
		this.height = data[5];
		this.TextureID = data[7];
		eo.EnemyS(width, height, x, y);
		//EOArrey.EnemyS(this.width, this.height, this.x, this.y);
	}

	public void drawEnemie(Graphics g) {
		
		switch(this.IDO) {
				case 1:
					sh(g, 9, 7, 16, 14, 27, 7, 16, 14);
					break;
					
				case 2:
					sh(g, 25, 25, 25, 25, 50, 25, 25, 25);
					break;
		 		}
	}
	
	
	public void sh(Graphics g, int x1, int y1, int w1, int h1, int x2, int y2, int w2, int h2) {
	//y=y+1;
	eo.EnemyR(x,y);
	y= EOArrey.y1;
	x= EOArrey.x1;
	//System.out.println(EOArrey.y13);
	//EOArrey.EnemyR(x, y);
	/*if(EOArrey.test==true) {
		System.out.println(EOArrey.zA1);
		
	}
	if(EOArrey.col[2] == 1) {
		y=y+1;
		x=x+1;
	}
	*/
		move.movement(g, x1, y1, w1, h1, x2, y2,w2, h2, x, y, width, height);
			}
	

}
