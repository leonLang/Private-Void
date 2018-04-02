package vvoid.init.main;

public class Collision {
	public static void Collis(int Obj1Y,int Oby1X,int Obj1Width, int Obj1Height,int Obj2Y,int Oby2X,int Obj2Width, int Obj2Height) {
		if(Obj1Y>=Obj2Y-Obj2Height && Obj1Y+Obj1Height<=Obj2Y) {
				System.out.println("collision");
			}
		}
}
