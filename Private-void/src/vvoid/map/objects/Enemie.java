//Leon
package vvoid.map.objects;

import java.awt.Graphics;
import java.awt.Image;

import vvoid.Void.collision.EnemieColl;
import vvoid.Void.game.Game;

public class Enemie {
	private EnemieMovement move = new EnemieMovement();
	private EnemieColl eo = new EnemieColl();
	private int idE;
	private int x, y, width, height; // postition and size from the enemy
	private int IDO;
	public static int id = -1;

	public Enemie(int[] data) {
		id++;
		idE = id;
		this.IDO = data[7];
		this.x = data[2] + 3;
		this.y = data[3] + 16;
		this.width = data[4] - 16;
		this.height = data[5] - 16;
		eo.enemyS(width, height, x, y, IDO);
	}

	public void drawEnemie(Graphics g) {
		eo.tBack();
		eo.eVSPl();
		switch (this.IDO) {
		case 1:
			direction(g, Game.sheet.dE.a1, Game.sheet.dE.a2, Game.sheet.dE.a3, Game.sheet.dE.a4, Game.sheet.dE.a5, Game.sheet.dE.a6,
					Game.sheet.dE.a7, Game.sheet.dE.a8);
			break;

		case 2:
			direction(g, Game.sheet.dE.b1, Game.sheet.dE.b2, Game.sheet.dE.b3, Game.sheet.dE.b4, Game.sheet.dE.b5, Game.sheet.dE.b6,
					Game.sheet.dE.b7, Game.sheet.dE.b8);
			break;

		case 3:
			direction(g, Game.sheet.dE.c1, Game.sheet.dE.c2, Game.sheet.dE.c3, Game.sheet.dE.c4, Game.sheet.dE.c5, Game.sheet.dE.c6,
					Game.sheet.dE.c7, Game.sheet.dE.c8);
			break;

		case 4:
			direction(g, Game.sheet.dE.d1, Game.sheet.dE.d2, Game.sheet.dE.d3, Game.sheet.dE.d4, Game.sheet.dE.d5, Game.sheet.dE.d6,
					Game.sheet.dE.d7, Game.sheet.dE.d8);
			// bis hierhin sind Krabbelviecher
			break;

		case 5:
			sh(g, Game.sheet.dE.e, Game.sheet.dE.e);
			break;

		case 6:
			sh(g, Game.sheet.dE.f, Game.sheet.dE.f);
			break;

		case 7:
			sh(g, Game.sheet.dE.g1, Game.sheet.dE.g1);
			break;

		case 8:
			sh(g, Game.sheet.dE.h, Game.sheet.dE.h);
			break;

		case 9:
			sh(g, Game.sheet.dE.i, Game.sheet.dE.i);
			// bis hierhin sind die hässlichen Flug Dinger
			break;

		case 10:
			sh(g, Game.sheet.dE.j1, Game.sheet.dE.j2);
			break;

		case 11:
			sh(g, Game.sheet.dE.k1, Game.sheet.dE.k2);
			break;

		case 12:
			sh(g, Game.sheet.dE.l1, Game.sheet.dE.l2);
			break;

		case 13:
			sh(g, Game.sheet.dE.m1, Game.sheet.dE.m2);
			break;

		case 14:
			sh(g, Game.sheet.dE.n1, Game.sheet.dE.n2);
			// weitere flug Dinger
			break;

		case 15:
			direction(g, Game.sheet.dE.o1, Game.sheet.dE.o2, Game.sheet.dE.o3, Game.sheet.dE.o4, Game.sheet.dE.o5, Game.sheet.dE.o6,
					Game.sheet.dE.o7, Game.sheet.dE.o8);
			break;

		case 16:
			direction(g, Game.sheet.dE.p1, Game.sheet.dE.p2, Game.sheet.dE.p3, Game.sheet.dE.p4, Game.sheet.dE.p5, Game.sheet.dE.p6,
					Game.sheet.dE.p7, Game.sheet.dE.p8);
			break;

		case 17:
			direction(g, Game.sheet.dE.q1, Game.sheet.dE.q2, Game.sheet.dE.q3, Game.sheet.dE.q4, Game.sheet.dE.q5, Game.sheet.dE.q6,
					Game.sheet.dE.q7, Game.sheet.dE.q8);
			// die schnecken kommen
			break;

		case 18:
			sh(g, Game.sheet.dE.r1, Game.sheet.dE.r2);
			break;

		case 19:
			sh(g, Game.sheet.dE.s1, Game.sheet.dE.s2);
			break;

		case 20:
			sh(g, Game.sheet.dE.t1, Game.sheet.dE.t2);
			// weitere Flugdinger
			break;

		case 21:
			direction(g, Game.sheet.dE.u1, Game.sheet.dE.u2, Game.sheet.dE.u3, Game.sheet.dE.u4, Game.sheet.dE.u5, Game.sheet.dE.u6,
					Game.sheet.dE.u7, Game.sheet.dE.u8);
			break;

		case 22:
			direction(g, Game.sheet.dE.v1, Game.sheet.dE.v2, Game.sheet.dE.v3, Game.sheet.dE.v4, Game.sheet.dE.v5, Game.sheet.dE.v6,
					Game.sheet.dE.v7, Game.sheet.dE.v8);
			// zwei Bodenkrabbler
			break;

		case 23:
			sh(g, Game.sheet.dE.w1, Game.sheet.dE.w2);
			break;

		case 24:
			sh(g, Game.sheet.dE.z, Game.sheet.dE.z);
			break;

		case 25:
			sh(g, Game.sheet.dE.zz, Game.sheet.dE.zz);
			// drei Seepferde
			break;
		}
	}

	private void sh(Graphics g, Image a1, Image a2) {
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
