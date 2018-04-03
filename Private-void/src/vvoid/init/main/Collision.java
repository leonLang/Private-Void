package vvoid.init.main;

import pPrivate.Void.game.Objekte;

public class Collision {
	
	public static boolean Collis(int Obj1X,int Obj1Y,int Obj1Width, int Obj1Height,int Obj2X,int Obj2Y,int Obj2Width, int Obj2Height) {
		if(Obj1Y+Obj1Height>=Obj2Y && Obj2Y+Obj2Height>=Obj1Y  && Obj1X+Obj1Width>=Obj2X && Obj2X+Obj2Width>Obj1X) {
				//System.out.println("collision");
				return true;
			}
		else {
		return false;
		}
		}
}
