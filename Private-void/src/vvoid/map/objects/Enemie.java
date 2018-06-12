package vvoid.map.objects;

import java.awt.Graphics;
import java.awt.Image;

import vvoid.Void.game.Game;
import vvoid.init.main.Collision;

public class Enemie {
	public EnemieMovement move = new EnemieMovement();
	public EOArrey eo = new EOArrey();
	public Collision coll, coll1;
	public int idE;
	public static int[] widthA = new int[100];
	public static int id = -1;
	public int x, y, width, height; // postition and size from the enemy
	private int IDO;
	public int zA;

	public Enemie(int[] data) {
		id++;
		idE = id;
		this.IDO = data[7];
		this.x = data[2] + 3;
		this.y = data[3] + 16;
		this.width = data[4] - 16;
		this.height = data[5] - 16;
		eo.enemyS(width, height, x, y, IDO);
		move.test();
	}

	public void drawEnemie(Graphics g) {
		eo.tBack();
		eo.eVSPl();
		switch (this.IDO) {
		case 1:
			direction(g, Game.sheet.a1, Game.sheet.a2, Game.sheet.a3, Game.sheet.a4, Game.sheet.a5, Game.sheet.a6,
					Game.sheet.a7, Game.sheet.a8);
			break;

		case 2:
			direction(g, Game.sheet.b1, Game.sheet.b2, Game.sheet.b3, Game.sheet.b4, Game.sheet.b5, Game.sheet.b6,
					Game.sheet.b7, Game.sheet.b8);
			break;

		case 3:
			direction(g, Game.sheet.c1, Game.sheet.c2, Game.sheet.c3, Game.sheet.c4, Game.sheet.c5, Game.sheet.c6,
					Game.sheet.c7, Game.sheet.c8);
			break;

		case 4:
			direction(g, Game.sheet.d1, Game.sheet.d2, Game.sheet.d3, Game.sheet.d4, Game.sheet.d5, Game.sheet.d6,
					Game.sheet.d7, Game.sheet.d8);
			// bis hierhin sind Krabbelviecher
			break;

		case 5:
			sh(g, Game.sheet.e, Game.sheet.e);
			break;

		case 6:
			sh(g, Game.sheet.f, Game.sheet.f);
			break;

		case 7:
			sh(g, Game.sheet.g1, Game.sheet.g1);
			break;

		case 8:
			sh(g, Game.sheet.h, Game.sheet.h);
			break;

		case 9:
			sh(g, Game.sheet.i, Game.sheet.i);
			// bis hierhin sind die hässlichen Flug Dinger
			break;

		case 10:
			sh(g, Game.sheet.j1, Game.sheet.j2);
			break;

		case 11:
			sh(g, Game.sheet.k1, Game.sheet.k2);
			break;

		case 12:
			sh(g, Game.sheet.l1, Game.sheet.l2);
			break;

		case 13:
			sh(g, Game.sheet.m1, Game.sheet.m2);
			break;

		case 14:
			sh(g, Game.sheet.n1, Game.sheet.n2);
			// weitere flug Dinger
			break;

		case 15:
			direction(g, Game.sheet.o1, Game.sheet.o2, Game.sheet.o3, Game.sheet.o4, Game.sheet.o5, Game.sheet.o6,
					Game.sheet.o7, Game.sheet.o8);
			break;

		case 16:
			direction(g, Game.sheet.p1, Game.sheet.p2, Game.sheet.p3, Game.sheet.p4, Game.sheet.p5, Game.sheet.p6,
					Game.sheet.p7, Game.sheet.p8);
			break;

		case 17:
			direction(g, Game.sheet.q1, Game.sheet.q2, Game.sheet.q3, Game.sheet.q4, Game.sheet.q5, Game.sheet.q6,
					Game.sheet.q7, Game.sheet.q8);
			// die schnecken kommen
			break;

		case 18:
			sh(g, Game.sheet.r1, Game.sheet.r2);
			break;

		case 19:
			sh(g, Game.sheet.s1, Game.sheet.s2);
			break;

		case 20:
			sh(g, Game.sheet.t1, Game.sheet.t2);
			// weitere Flugdinger
			break;

		case 21:
			direction(g, Game.sheet.u1, Game.sheet.u2, Game.sheet.u3, Game.sheet.u4, Game.sheet.u5, Game.sheet.u6,
					Game.sheet.u7, Game.sheet.u8);
			break;

		case 22:
			direction(g, Game.sheet.v1, Game.sheet.v2, Game.sheet.v3, Game.sheet.v4, Game.sheet.v5, Game.sheet.v6,
					Game.sheet.v7, Game.sheet.v8);
			// zwei Bodenkrabbler
			break;

		case 23:
			sh(g, Game.sheet.w1, Game.sheet.w2);
			break;

		case 24:
			sh(g, Game.sheet.z, Game.sheet.z);
			break;

		case 25:
			sh(g, Game.sheet.zz, Game.sheet.zz);
			// drei Seepferde
			break;
		}
	}

	public void sh(Graphics g, Image a1, Image a2) {
		eo.enemyR();
		eo.destroyE(idE);
		x = eo.x;
		y = eo.y;
		eo.updateE(idE, x, y);
		move.movement(g, a1, a2, x, y, width, height);
	}

	private void direction(Graphics g, Image e1, Image e2, Image e3, Image e4, Image e5, Image e6, Image e7, Image e8) {
		eo.destroyE(idE);
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
}
