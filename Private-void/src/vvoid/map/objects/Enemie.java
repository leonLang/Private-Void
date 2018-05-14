package vvoid.map.objects;

import java.awt.Graphics;
import java.awt.Image;

import vvoid.Void.game.Game;
import vvoid.Void.game.SpriteSheet;
import vvoid.init.main.Collision;

public class Enemie {
	public EnemieMovement move = new EnemieMovement();
	public EOArrey eo = new EOArrey();
	public Collision coll, coll1;
	private SpriteSheet sheet = new SpriteSheet();
	public static int[] widthA = new int[100];
	public int x, y, width, height; // postition and size from the enemy
	private Image c, d, e, f;
	private Image a1,a2, a3, a4, a5,a6,a7,a8;
	public static int zaehler, zaehler1;

	private int IDO;
	public int zA;

	public Enemie(int[] data) {
		spritePos();
		this.IDO = data[7];
		this.x = data[2] + 3;
		this.y = data[3] + 16;
		this.width = data[4] - 16;
		this.height = data[5] - 16;
		eo.EnemyS(width, height, x, y);
		move.test();
	}

	public void drawEnemie(Graphics g) {
		//System.out.println(Game.player.x);
		switch (this.IDO) {
		case 1:
			direction(g, a1, a2, a3, a4, a5, a6, a7, a8);
			break;

		case 2:
			sh(g, e, f);
			break;
		}
	}

	public void sh(Graphics g, Image a1, Image a2) {
		eo.EnemyR(0);
		eo.CollPlayer();
		x = eo.x;
		y = eo.y;
		// y = EOArrey.y1;
		// x = EOArrey.x1;
		move.movement(g, a1, a2, x, y, width, height);
	}

	private void direction(Graphics g, Image e1, Image e2, Image e3, Image e4, Image e5, Image e6, Image e7, Image e8) {
		if (eo.richtung == 0) {
			sh(g,e1,e2);
		}
		if (eo.richtung == 1) {
			sh(g,e3,e4);
		}
		if (eo.richtung == 2) {
			sh(g,e5,e6);
		}
		if (eo.richtung == 3) {
			sh(g,e7,e8);
		}
	}

	private void spritePos() {
		c = sheet.crop(9, 7, 16, 14);
		d = sheet.crop(27, 7, 16, 14);
		e = sheet.crop(25, 25, 25, 25);
		f = sheet.crop(50, 25, 25, 25);
		
		a1 = sheet.crop(9, 7, 15, 14);
		a2 = sheet.crop(27, 7, 16, 14);
		a3 = sheet.crop(45, 7, 16, 14);
		a4 = sheet.crop(60, 7, 16, 14);
		a5 = sheet.crop(75, 7, 16, 14);
		a6 = sheet.crop(93, 7, 16, 14);
		a7 = sheet.crop(111, 7, 16, 14);
		a8 = sheet.crop(128, 7, 16, 14);
	}

}