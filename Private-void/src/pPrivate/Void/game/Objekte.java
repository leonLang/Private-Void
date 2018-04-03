package pPrivate.Void.game;

import java.awt.Graphics;
import java.util.Arrays;

public class Objekte {
	public static int E1Width=200;
	public static int E1Height=100;
	public static int E2Width=200;
	public static int E2Height=1000;
	public static void enemy1(int x, int y,Graphics g) {
		g.drawRect(x, y, E1Width, E1Height);
	}
	public static void enemy2(int x,int y, Graphics g) {
		g.drawRect(x, y, E2Width, E2Height);
	}
	public static void CreateObject(int[] Object) {
		System.out.println(Arrays.toString(Object));
		switch(Object[0]) {
		case 0:
			System.out.println(0);
			break;
		case 1:
			break;
		default:
			break;
		}
	}
}
