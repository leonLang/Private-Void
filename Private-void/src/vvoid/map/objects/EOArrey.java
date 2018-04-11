package vvoid.map.objects;

import vvoid.init.main.Collision;

public class EOArrey {
	public  int[] widthE = new int[10000];
	public  int[] heightE = new int[10000];
	public  int[] xE = new int[10000];
	public  int[] yE = new int[10000];
	public  int[] widthO = new int[10000];
	public  int[] heightO = new int[10000];
	public  int[] xO = new int[10000];
	public  int[] yO = new int[10000];
	public  int[] col = new int[10000];
	public  int zA;
	public  int zA1;
	public  int zaehler;
	public  int zaehler1;
	public  int zaehler2;
	public  int x,y;
	public  boolean test=false;
	public  void EnemyS(int width, int height, int x, int y) {
		widthE[zA] = width;
		heightE[zA] = height;
		xE[zA] = x;
		yE[zA] = y;

		zA++;
		
	}

	public  void  EnemyR(int x, int y) {
		xE[zaehler] =x;
		yE[zaehler] =y;
		if (zaehler >= zA-1) {
		zaehler = 0;
	}
	else {
		zaehler++;
	}
	zaehler1 = zA1;
	Collision();
	}
	
	public  void Objekt(int width, int height, int x, int y){
		widthO[zA1] = width;
		heightO[zA1] = height;
		xO[zA1] = x;
		yO[zA1] = y;
		System.out.println(heightO[zA1]);
		zA1++;
	}
	
	public  void Collision() {
		while (zaehler1 > 1) {
			zaehler1--;
		if (Collision.Collis(xE[zaehler], yE[zaehler],widthE[zaehler], heightE[zaehler], xO[zaehler2], yO[zaehler2], widthO[zaehler2], heightO[zaehler2]) == true) {
			System.out.println("colli");
			yE[zaehler] = 700;
			System.out.println(zaehler1);
			test=true;
			col[zaehler1] = 1;
		}
		else {
			col[zaehler1] = 0;
			test=false;
			System.out.println("störe");
		}
		zaehler2++;
	}
		zaehler1 =0;
		zaehler2 =0;

	}
}
