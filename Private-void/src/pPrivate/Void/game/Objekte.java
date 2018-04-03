package pPrivate.Void.game;

import java.awt.Graphics;
import java.util.Arrays;

public class Objekte {
	public static int E1Width=200;
	public static int E1Height=200;
	public static int E2Width=200;
	public static int E2Height=200;
	public static int x1=300;
	public static int y1=202;
	public static int x2=200;
	public static int y2=202;
	
	public static void enemy1(int x, int y,Graphics g) {
		g.drawRect(x1, y1, E1Width, E1Height);
	}
	public static void enemy2(int x,int y, Graphics g) {
		g.drawRect(x2, y2, E2Width, E2Height);
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
