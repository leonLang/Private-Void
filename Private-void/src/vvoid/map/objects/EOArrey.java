package vvoid.map.objects;

import vvoid.init.main.Collision;

public class EOArrey {
	public static int[] widthE = new int[10000];
	public static int[] heightE = new int[10000];
	public static int[] xE = new int[10000];
	public static int[] yE = new int[10000];
	public static int[] widthO = new int[10000];
	public static int[] heightO = new int[10000];
	public static int[] xO = new int[10000];
	public static int[] yO = new int[10000];
	public static int zA;
	public static int zA1;
	public static int zaehler;
	public static int zaehler1;
	public static int zaehler2;
	public static boolean test=false;
	public static void EnemyS(int width, int height, int x, int y) {
		widthE[zA] = width;
		heightE[zA] = height;
		xE[zA] = x;
		yE[zA] = y;

		zA++;
		
	}
	public static void EnemyR(int x, int y) {
		EOArrey.xE[zaehler] =x;
		EOArrey.yE[zaehler] =y;
		if (zaehler >= EOArrey.zA-1) {
		zaehler = 0;
	}
	else {
		zaehler++;
	}
	zaehler1 = zA1;
	Collision();
	}
	
	public static void Objekt(int width, int height, int x, int y){
		widthO[zA1] = width;
		heightO[zA1] = height;
		xO[zA1] = x;
		yO[zA1] = y;
		System.out.println(heightO[zA1]);
		zA1++;
	}
	
	public static void Collision() {
		while (zaehler1 > 0) {
			zaehler1--;
		if (Collision.Collis(EOArrey.xE[zaehler], EOArrey.yE[zaehler],EOArrey.widthE[zaehler], EOArrey.heightE[zaehler], EOArrey.xO[zaehler2], EOArrey.yO[zaehler2], EOArrey.widthO[zaehler2], EOArrey.heightO[zaehler2]) == true) {
			System.out.println("colli");
			EOArrey.yE[zaehler] = 700;
			System.out.println(zaehler);
			test = true;
		}
		else {
			test=false;
		}
		zaehler2++;
	}
		zaehler1 =0;
		zaehler2 =0;

	}
}
