package pPrivate.Void.game;

import java.awt.Graphics;

public class Enemie {
	public static int E1Width=200;
	public static int E1Height=200;
	public static int x2;
	public static int x3;
	public static int x4;
	public Enemie(int x1, int x2, int x3, int x4) {
		this.x2 = x2;
		this.x3 = x3;
		this.x4 = x4;
		createEnemie(x1);
	}
	public static void createEnemie(int ID) {
		switch(ID) {
		case 1:
			x2= 105;
			x3=200;
			x4=1;
			break;
			//usw.
		case 2:
			x2=100;
			x3=150;
			x4=2;
			break;
		}
	}
	public static void enemieType1(int x, int y, int textureid, Graphics g) {
		g.drawRect(x, y, E1Width, E1Height);

	}
	public static void enemieType2(int x, int y, int textureid, Graphics g) {
		g.drawRect(x, y, E1Width, E1Height);

	}

}


