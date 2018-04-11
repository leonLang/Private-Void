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
	public Collision coll,coll1;
	public static int eAmount = -1, oAmount = -1;
	public  int[] col = new int[10000];
	public  int zA;
	public  int zA1;
	public  static int zaehler;
	public  int zaehler1;
	public  int zaehler2;
	public  boolean test=false;
	public static int y13,x13;
	public  void EnemyS(int width, int height, int x, int y) {
		eAmount++;
		widthE[eAmount] = width;
		heightE[eAmount] = height;
		xE[eAmount] = x;
		yE[eAmount] = y;
		zA++;
		
	}

	public  void  EnemyR(int x, int y) {
		y13 =y;
		x13 = x;
		xE[zaehler] =x;
		yE[zaehler] =y;
		while (zaehler1<= oAmount) {
		coll = new Collision(xE[zaehler], yE[zaehler], widthE[zaehler], heightE[zaehler], xO[zaehler1], yO[zaehler1], widthO[zaehler1],heightO[zaehler1]);
		
		if (hallo() == true ) {
			y13 = y13 -1;
			x13++;
			zaehler1 = 1000000;
			
		}
		zaehler1++;
	
		}
		zaehler1 =0;
		if (zaehler >= eAmount-1) {
		zaehler = 0;
	}
	else {
		zaehler++;
	}
	//zaehler1 = zA1;
	//Collision();
	}
	public boolean hallo() {

		if (coll.Coll() == true) {
			return true;
		}
		else {
			return false;
		}
		
	}
	public  void Objekt(int width, int height, int x, int y){
		oAmount++;
		widthO[oAmount] = width;
		heightO[oAmount] = height;
		xO[oAmount] = x;
		yO[oAmount] = y;
		
	}
	
	public  void Collision() {
		while (zaehler1 > 1) {
			zaehler1--;
		if (Collision.Collis(xE[zaehler], yE[zaehler],widthE[zaehler], heightE[zaehler], xO[zaehler2], yO[zaehler2], widthO[zaehler2], heightO[zaehler2]) == true) {
			yE[zaehler] = 700;
			test=true;
			col[zaehler1] = 1;
		}
		else {
			col[zaehler1] = 0;
			test=false;
			}
		zaehler2++;
	}
		zaehler1 =0;
		zaehler2 =0;

	}
}
