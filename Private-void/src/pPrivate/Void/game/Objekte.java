package pPrivate.Void.game;

import java.awt.Graphics;

public class Objekte {
	public static int E1Width=100;
	public static int E1Height=150;
	public static int E2Width=100;
	public static int E2Height=150;
	public static void enemy1(int x, int y,Graphics g) {
		g.drawRect(x, y, E1Width, E1Height);
	}
	public static void enemy2(int x,int y, Graphics g) {
		g.drawRect(x, y, E2Width, E2Height);
	}
}
