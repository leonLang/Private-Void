package vvoid.map.objects;

import java.awt.Graphics;
import java.awt.Image;
import vvoid.Void.game.SpriteSheet;
import vvoid.init.main.Collision;

public class Enemie {
	public EnemieMovement move = new EnemieMovement();
	public EOArrey eo = new EOArrey();
	public Collision coll, coll1;
	private SpriteSheet sheet = new SpriteSheet();
	public static int[] widthA = new int[100];
	public int x, y, width, height; // postition and size from the enemy
	private Image a1, a2, a3, a4, a5, a6, a7, a8, b1, b2, b3, b4, b5, b6, b7, b8, c1, c2, c3, c4, c5, c6, c7, c8, d1,
			d2, d3, d4, d5, d6, d7, d8;
	private Image e, f, g1, h, i, j1, j2, k1, k2, l1, l2, m1, m2, n1, n2;
	private Image o1, o2, o3, o4, o5, o6, o7, o8, p1, p2, p3, p4, p5, p6, p7, p8, q1, q2, q3, q4, q5, q6, q7, q8;
	private Image r1, r2, s1,s2, t1,t2;
	private Image u1, u2, u3, u4, u5, u6, u7, u8, v1, v2, v3, v4, v5, v6, v7, v8;
	private Image w1,w2, z, zz;
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
		eo.EnemyS(width, height, x, y, IDO);
		move.test();
	}

	public void drawEnemie(Graphics g) {
		
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
		eo.CollPlayer();
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
		a1 = sheet.crop(9, 7, 15, 14);
		a2 = sheet.crop(27, 7, 16, 14);
		a3 = sheet.crop(45, 7, 16, 14);
		a4 = sheet.crop(60, 7, 16, 14);
		a5 = sheet.crop(75, 7, 16, 14);
		a6 = sheet.crop(93, 7, 16, 14);
		a7 = sheet.crop(111, 7, 16, 14);
		a8 = sheet.crop(128, 7, 16, 14);
		b1 = sheet.crop(145, 7, 15, 14);
		b2 = sheet.crop(163, 7, 16, 14);
		b3 = sheet.crop(181, 7, 16, 14);
		b4 = sheet.crop(196, 7, 16, 14);
		b5 = sheet.crop(211, 7, 16, 14);
		b6 = sheet.crop(229, 7, 16, 14);
		b7 = sheet.crop(247, 7, 16, 14);
		b8 = sheet.crop(264, 7, 16, 14);
		c1 = sheet.crop(281, 7, 16, 14);
		c2 = sheet.crop(299, 7, 16, 14);
		c3 = sheet.crop(317, 7, 16, 14);
		c4 = sheet.crop(332, 7, 16, 14);
		c5 = sheet.crop(347, 7, 16, 14);
		c6 = sheet.crop(365, 7, 16, 14);
		c7 = sheet.crop(383, 7, 16, 14);
		c8 = sheet.crop(400, 7, 16, 14);
		d1 = sheet.crop(417, 7, 16, 14);
		d2 = sheet.crop(435, 7, 16, 14);
		d3 = sheet.crop(453, 7, 16, 14);
		d4 = sheet.crop(468, 7, 16, 14);
		d5 = sheet.crop(483, 7, 16, 14);
		d6 = sheet.crop(501, 7, 16, 14);
		d7 = sheet.crop(519, 7, 16, 14);
		d8 = sheet.crop(536, 7, 16, 14);
		e = sheet.crop(13, 25, 18, 28);
		f = sheet.crop(53, 25, 18, 28);
		g1 = sheet.crop(91, 25, 18, 28);
		h = sheet.crop(128, 25, 18, 28);
		i = sheet.crop(166, 25, 18, 28);
		j1 = sheet.crop(212, 28, 25, 23);
		j2 = sheet.crop(238, 28, 25, 23);
		k1 = sheet.crop(264, 28, 25, 23);
		k2 = sheet.crop(290, 28, 25, 23);
		l1 = sheet.crop(316, 28, 25, 23);
		l2 = sheet.crop(342, 28, 25, 23);
		m1 = sheet.crop(368, 28, 25, 23);
		m2 = sheet.crop(394, 28, 25, 23);
		n1 = sheet.crop(508, 40, 23, 15);
		n2 = sheet.crop(527, 40, 23, 15);
		o1 = sheet.crop(31, 86, 15, 13);
		o2 = sheet.crop(49, 86, 15, 13);
		o3 = sheet.crop(68, 86, 13, 13);
		o4 = sheet.crop(86, 86, 13, 13);
		o5 = sheet.crop(103, 87, 15, 13);
		o6 = sheet.crop(121, 87, 15, 13);
		o7 = sheet.crop(139, 86, 13, 13);
		o8 = sheet.crop(157, 86, 13, 13);
		p1 = sheet.crop(175, 86, 15, 13);
		p2 = sheet.crop(193, 86, 15, 13);
		p3 = sheet.crop(212, 86, 13, 13);
		p4 = sheet.crop(230, 86, 13, 13);
		p5 = sheet.crop(246, 87, 15, 13);
		p6 = sheet.crop(265, 87, 15, 13);
		p7 = sheet.crop(285, 86, 13, 13);
		p8 = sheet.crop(303, 86, 13, 13);
		q1 = sheet.crop(319, 86, 15, 13);
		q2 = sheet.crop(337, 86, 15, 13);
		q3 = sheet.crop(357, 86, 13, 13);
		q4 = sheet.crop(375, 86, 13, 13);
		q5 = sheet.crop(392, 87, 15, 13);
		q6 = sheet.crop(410, 87, 15, 13);
		q7 = sheet.crop(429, 86, 13, 13);
		q8 = sheet.crop(447, 86, 13, 13);
		r1 = sheet.crop(237, 112, 26, 24);
		r2 = sheet.crop(263, 108, 26, 25);
		s1 = sheet.crop(341, 112, 26, 24);
		s2 = sheet.crop(367, 108, 26, 25);
		t1 = sheet.crop(445, 112, 26, 24);
		t2 = sheet.crop(471, 108, 26, 25);
		u1 = sheet.crop(0, 0, 1, 1);
		u2 = sheet.crop(0, 0, 1, 1);
		u3 = sheet.crop(0, 0, 1, 1);
		u4 = sheet.crop(0, 0, 1, 1);
		u5 = sheet.crop(0, 0, 1, 1);
		u6 = sheet.crop(0, 0, 1, 1);
		u7 = sheet.crop(0, 0, 1, 1);
		u8 = sheet.crop(0, 0, 1, 1);
		v1 = sheet.crop(0, 0, 1, 1);
		v2 = sheet.crop(0, 0, 1, 1);
		v3 = sheet.crop(0, 0, 1, 1);
		v4 = sheet.crop(0, 0, 1, 1);
		v5 = sheet.crop(0, 0, 1, 1);
		v6 = sheet.crop(0, 0, 1, 1);
		v7 = sheet.crop(0, 0, 1, 1);
		v8 = sheet.crop(0, 0, 1, 1);
		w1 = sheet.crop(168, 152, 15, 40);
		w2 = sheet.crop(168, 152, 15, 40);
		z = sheet.crop(200, 152, 15, 40);
		zz = sheet.crop(230, 152, 15, 40);
	}

}
