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
	public Collision coll,coll1,coll2,coll3,coll4;
	public static int eAmount = -1, oAmount = -1;
	public  int[] col = new int[10000];
	public  int zA;
	public  int zA1;
	public int c1 = 5,c2 = -5,c3 = 5,c4 =-5;
	public  static int zaehler;
	public  int zaehler1, zaehler4,zaehler5,zaehler3,z1;
	public  int h11,h12,h21,h22,h13,h14,h15;
	public  int zaehler2;
	public  boolean test=false;
	public static int y13,x13;
	public boolean start = true;
	public  void EnemyS(int width, int height, int x, int y) {
		eAmount++;
		widthE[eAmount] = width;
		heightE[eAmount] = height;
		xE[eAmount] = x;
		yE[eAmount] = y;
		zA++;
		System.out.println(x);
		
	}

	public  void  EnemyR(int x, int y) {
		y13 =y;
		x13 = x;
		xE[zaehler] =x;
		yE[zaehler] =y;
		while (zaehler1<= oAmount) {
		coll = new Collision(xE[zaehler], yE[zaehler], widthE[zaehler], heightE[zaehler], xO[zaehler1], yO[zaehler1], widthO[zaehler1],heightO[zaehler1]);
	
		/*if (yE[zaehler]+heightE[zaehler]+4 >= yO[zaehler1] && yE[zaehler]+heightE[zaehler]-4 <= yO[zaehler1]) {
		}
		if(yE[zaehler]-5 >= yO[zaehler1]+ heightO[zaehler1] && yE[zaehler]+5 <= yO[zaehler1]+ heightO[zaehler1] ) {
			
		}
		if (xE[zaehler]+5 >= xO[zaehler1]+widthO[zaehler1] && xE[zaehler]-5 <= xO[zaehler1]+widthO[zaehler1]) {
			
		}
		*/
		if (hallo() == 1 ) {
			System.out.println("coll");
			start=false;
			/*y13 = y13 -1;
			zaehler5 =1;
			x13++;
			zaehler3=0;
			//System.out.println("alles");
			zaehler1 = 1000000;
			h11 =0;
			h12=0;
			z1=0;
			h14=0;
			*/
		}
		/*else {
			z1++;
			if (z1 >=5) {
				
			if (hallo1() == 1) {
				//System.out.println("links");
				h11=1;
				h12=0;
				h14=1;
			}
			if(h14 == 1) {
			if (hallo3()==1) {
				h13=0;
				System.out.println("es kommt was");
				h14=0;
			}
			else {
				h13=1;
			}
			}
			if (h13==1 && h12>=2) {
				x13--;
				h13=0;
				
			}
			
			if (hallo2() ==1 ) {
				h21=1;
				//h11=0;
				//h12=0;
				h22=0;
				//x13--;
				
				System.out.println("unten");
			}
		}*/
		zaehler1++;
		}
	
		if(start == true) {
			y13++;
		}
		
		/*if (hallo() == false && zaehler4 ==1) {
			zaehler3++;
			if(zaehler3 >=10) {
			x13--;
			}
		} */
		
		
		
		
		if(h11==1) {
			h12++;
		}
		
		if(h21==1) {
			h22++;
			System.out.println(h22);
		}
		if (h12 >=2) {
			
			x13--;
			y13--;
		}
		if (h22 >=2) {
			h11=0;
			h12=0;
			//x13--;
			y13--;
		}
		if (zaehler5==1){
			zaehler3 = zaehler3+1;
			//System.out.println(zaehler3);
		}
		if (zaehler3 >=4) {
			//y13--;
			//x13--;
			
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
	public int hallo() {
		//coll.Coll2();
		if (coll.Coll1() == 1) {
			return 1;
		}
		else {
			return 0;
		}
		
	}
	public int hallo1() {
		//die linke seite der Collision
		if (coll.Coll2() == 1) {
			return 1;
		}
		else {
			return 0;
		}
		
	}
	public int hallo2() {
		//die untere seite der Collision
		if (coll.Coll3() == 1) {
			return 1;
		}
		else {
			return 0;
		}
		
	}
	public int hallo3() {
		//die untere seite der Collision
		if (coll.Coll4() == 1) {
			return 1;
		}
		else {
			return 0;
		}
		
	}
	
	public  void Objekt(int width, int height, int x, int y){
		oAmount++;
		widthO[oAmount] = width;
		heightO[oAmount] = height;
		xO[oAmount] = x;
		yO[oAmount] = y;
		
	}
	
	
}
