package vvoid.map.objects;

import java.awt.Graphics;
import java.awt.Image;

import vvoid.Void.game.Game;
import vvoid.Void.game.SpriteSheet;
import vvoid.init.main.Camera;
import vvoid.init.main.Collision;

public class Enemie {
	public EnemieMovement move = new EnemieMovement();
	public EOArrey eo = new EOArrey();
	public Collision coll, coll1;
	public static int[] widthA = new int[100];
	public int x, y, width, height; // postition and size from the enemy
	private Image a1, a2, a3, a4, a5, a6, a7, a8, b1, b2, b3, b4, b5, b6, b7, b8, c1, c2, c3, c4, c5, c6, c7, c8, d1,
			d2, d3, d4, d5, d6, d7, d8;
	private Image e, f, g1, h, i, j1, j2, k1, k2, l1, l2, m1, m2, n1, n2;
	private Image o1, o2, o3, o4, o5, o6, o7, o8, p1, p2, p3, p4, p5, p6, p7, p8, q1, q2, q3, q4, q5, q6, q7, q8;
	private Image r1, r2, s1, s2, t1, t2;
	private Image u1, u2, u3, u4, u5, u6, u7, u8, v1, v2, v3, v4, v5, v6, v7, v8;
	private Image w1, w2, z, zz;
	private int testi;

	
	private int IDO;
	public int zA;

	public Enemie(int[] data) {
		spritePos();
		this.IDO = data[7];
		this.x = data[2] + 3;
		this.y = data[3] + 16;
		this.width = data[4] - 16;
		this.height = data[5] - 16;
		eo.EnemyS(width, height, x, y, IDO);
		System.out.println("hi");
		move.test();
	}

	public void drawEnemie(Graphics g) {
		/*if(testi == 3 ) {
		Camera.addy(1);
		Game.player.addY(-1);
		testi=0;
		}
		else {
			testi++;
		}
		*/
		switch (this.IDO) {
		case 1:
			direction(g, a1, a2, a3, a4, a5, a6, a7, a8);
			break;

		case 2:
			direction(g, b1, b2, b3, b4, b5, b6, b7, b8);
			break;

		case 3:
			direction(g, c1, c2, c3, c4, c5, c6, c7, c8);
			break;

		case 4:
			direction(g, d1, d2, d3, d4, d5, d6, d7, d8);
			// bis hierhin sind Krabbelviecher
			break;

		case 5:
			sh(g, e, e);
			break;

		case 6:
			sh(g, f, f);
			break;

		case 7:
			sh(g, g1, g1);
			break;

		case 8:
			sh(g, h, h);
			break;

		case 9:
			sh(g, i, i);
			// bis hierhin sind die hässlichen Flug Dinger
			break;

		case 10:
			sh(g, j1, j2);
			break;

		case 11:
			sh(g, k1, k2);
			break;

		case 12:
			sh(g, l1, l2);
			break;

		case 13:
			sh(g, m1, m2);
			break;

		case 14:
			sh(g, n1, n2);
			// weitere flug Dinger
			break;

		case 15:
			direction(g, o1, o2, o3, o4, o5, o6, o7, o8);
			break;

		case 16:
			direction(g, p1, p2, p3, p4, p5, p6, p7, p8);
			break;

		case 17:
			direction(g, q1, q2, q3, q4, q5, q6, q7, q8);
			// die schnecken kommen
			break;

		case 18:
			sh(g, r1, r2);
			break;

		case 19:
			sh(g, s1, s2);
			break;

		case 20:
			sh(g, t1, t2);
			// weitere Flugdinger
			break;

		case 21:
			direction(g, u1, u2, u3, u4, u5, u6, u7, u8);
			break;

		case 22:
			direction(g, v1, v2, v3, v4, v5, v6, v7, v8);
			// zwei Bodenkrabbler
			break;

		case 23:
			sh(g, w1, w2);
			break;

		case 24:
			sh(g, z, z);
			break;

		case 25:
			sh(g, zz, zz);
			// drei Seepferde
			break;
		}
	}

	public void sh(Graphics g, Image a1, Image a2) {
		eo.EnemyR();
		//eo.CollPlayer();
		x = eo.x;
		y = eo.y;
		// y = EOArrey.y1;
		// x = EOArrey.x1;
		move.movement(g, a1, a2, x, y, width, height);
	}

	private void direction(Graphics g, Image e1, Image e2, Image e3, Image e4, Image e5, Image e6, Image e7, Image e8) {
		if (eo.richtung == 0) {
			sh(g, e1, e2);
		}
		if (eo.richtung == 1) {
			sh(g, e3, e4);
		}
		if (eo.richtung == 2) {
			sh(g, e5, e6);
		}
		if (eo.richtung == 3) {
			sh(g, e7, e8);
		}
	}

	private void spritePos() {
		a1 = Game.sheet.crop(9, 7, 15, 14);
		a2 = Game.sheet.crop(27, 7, 16, 14);
		a3 = Game.sheet.crop(45, 7, 16, 14);
		a4 = Game.sheet.crop(60, 7, 16, 14);
		a5 = Game.sheet.crop(75, 7, 16, 14);
		a6 = Game.sheet.crop(93, 7, 16, 14);
		a7 = Game.sheet.crop(111, 7, 16, 14);
		a8 = Game.sheet.crop(128, 7, 16, 14);
		b1 = Game.sheet.crop(145, 7, 15, 14);
		b2 = Game.sheet.crop(163, 7, 16, 14);
		b3 = Game.sheet.crop(181, 7, 16, 14);
		b4 = Game.sheet.crop(196, 7, 16, 14);
		b5 = Game.sheet.crop(211, 7, 16, 14);
		b6 = Game.sheet.crop(229, 7, 16, 14);
		b7 = Game.sheet.crop(247, 7, 16, 14);
		b8 = Game.sheet.crop(264, 7, 16, 14);
		c1 = Game.sheet.crop(281, 7, 16, 14);
		c2 = Game.sheet.crop(299, 7, 16, 14);
		c3 = Game.sheet.crop(317, 7, 16, 14);
		c4 = Game.sheet.crop(332, 7, 16, 14);
		c5 = Game.sheet.crop(347, 7, 16, 14);
		c6 = Game.sheet.crop(365, 7, 16, 14);
		c7 = Game.sheet.crop(383, 7, 16, 14);
		c8 = Game.sheet.crop(400, 7, 16, 14);
		d1 = Game.sheet.crop(417, 7, 16, 14);
		d2 = Game.sheet.crop(435, 7, 16, 14);
		d3 = Game.sheet.crop(453, 7, 16, 14);
		d4 = Game.sheet.crop(468, 7, 16, 14);
		d5 = Game.sheet.crop(483, 7, 16, 14);
		d6 = Game.sheet.crop(501, 7, 16, 14);
		d7 = Game.sheet.crop(519, 7, 16, 14);
		d8 = Game.sheet.crop(536, 7, 16, 14);
		e = Game.sheet.crop(13, 25, 18, 28);
		f = Game.sheet.crop(53, 25, 18, 28);
		g1 =Game.sheet.crop(91, 25, 18, 28);
		h = Game.sheet.crop(128, 25, 18, 28);
		i = Game.sheet.crop(166, 25, 18, 28);
		j1 = Game.sheet.crop(212, 28, 25, 23);
		j2 = Game.sheet.crop(238, 28, 25, 23);
		k1 = Game.sheet.crop(264, 28, 25, 23);
		k2 = Game.sheet.crop(290, 28, 25, 23);
		l1 = Game.sheet.crop(316, 28, 25, 23);
		l2 = Game.sheet.crop(342, 28, 25, 23);
		m1 = Game.sheet.crop(368, 28, 25, 23);
		m2 = Game.sheet.crop(394, 28, 25, 23);
		n1 = Game.sheet.crop(508, 40, 23, 15);
		n2 = Game.sheet.crop(527, 40, 23, 15);
		o1 = Game.sheet.crop(31, 86, 15, 13);
		o2 = Game.sheet.crop(49, 86, 15, 13);
		o3 = Game.sheet.crop(68, 86, 13, 13);
		o4 = Game.sheet.crop(86, 86, 13, 13);
		o5 = Game.sheet.crop(103, 87, 15, 13);
		o6 = Game.sheet.crop(121, 87, 15, 13);
		o7 = Game.sheet.crop(139, 86, 13, 13);
		o8 = Game.sheet.crop(157, 86, 13, 13);
		p1 = Game.sheet.crop(175, 86, 15, 13);
		p2 = Game.sheet.crop(193, 86, 15, 13);
		p3 = Game.sheet.crop(212, 86, 13, 13);
		p4 = Game.sheet.crop(230, 86, 13, 13);
		p5 = Game.sheet.crop(246, 87, 15, 13);
		p6 =Game.sheet.crop(265, 87, 15, 13);
		p7 = Game.sheet.crop(285, 86, 13, 13);
		p8 = Game.sheet.crop(303, 86, 13, 13);
		q1 = Game.sheet.crop(319, 86, 15, 13);
		q2 = Game.sheet.crop(337, 86, 15, 13);
		q3 = Game.sheet.crop(357, 86, 13, 13);
		q4 = Game.sheet.crop(375, 86, 13, 13);
		q5 = Game.sheet.crop(392, 87, 15, 13);
		q6 = Game.sheet.crop(410, 87, 15, 13);
		q7 =Game.sheet.crop(429, 86, 13, 13);
		q8 = Game.sheet.crop(447, 86, 13, 13);
		r1 = Game.sheet.crop(237, 112, 26, 24);
		r2 = Game.sheet.crop(263, 108, 26, 25);
		s1 = Game.sheet.crop(341, 112, 26, 24);
		s2 = Game.sheet.crop(367, 108, 26, 25);
		t1 = Game.sheet.crop(445, 112, 26, 24);
		t2 = Game.sheet.crop(471, 108, 26, 25);
		u1 = Game.sheet.crop(0, 0, 1, 1);
		u2 = Game.sheet.crop(0, 0, 1, 1);
		u3 = Game.sheet.crop(0, 0, 1, 1);
		u4 = Game.sheet.crop(0, 0, 1, 1);
		u5 = Game.sheet.crop(0, 0, 1, 1);
		u6 = Game.sheet.crop(0, 0, 1, 1);
		u7 = Game.sheet.crop(0, 0, 1, 1);
		u8 = Game.sheet.crop(0, 0, 1, 1);
		v1 = Game.sheet.crop(0, 0, 1, 1);
		v2 = Game.sheet.crop(0, 0, 1, 1);
		v3 = Game.sheet.crop(0, 0, 1, 1);
		v4 = Game.sheet.crop(0, 0, 1, 1);
		v5 = Game.sheet.crop(0, 0, 1, 1);
		v6 = Game.sheet.crop(0, 0, 1, 1);
		v7 = Game.sheet.crop(0, 0, 1, 1);
		v8 = Game.sheet.crop(0, 0, 1, 1);
		w1 = Game.sheet.crop(168, 152, 15, 40);
		w2 = Game.sheet.crop(168, 152, 15, 40);
		z = Game.sheet.crop(200, 152, 15, 40);
		zz = Game.sheet.crop(230, 152, 15, 40);
	}

}
