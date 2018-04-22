package vvoid.map.objects;

import java.awt.Graphics;
import vvoid.init.main.Collision;

public class Enemie {
	public EnemieMovement move = new EnemieMovement();
	public EOArrey eo = new EOArrey();
	public Collision coll,coll1;
	public static int[] widthA = new int[100];
	public int x;
	public static int zaehler,zaehler1;
	public int y;
	private int width;
	private int height;
	private int IDO;	
	public int zA;
	public Enemie(int[] data) {
		this.IDO = data[7];
		this.x = data[2];
		this.y = data[3];
		this.width = data[4]-2;
		this.height = data[5]-2;
		eo.EnemyS(width, height, x, y);
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
	eo.EnemyR(x,y);
	y= EOArrey.y1;
	x= EOArrey.x1;
		move.movement(g, x1, y1, w1, h1, x2, y2,w2, h2, x, y, width, height);
			}
	

}
