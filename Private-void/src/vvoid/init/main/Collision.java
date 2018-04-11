package vvoid.init.main;

public class Collision {
	
	private int Obj1Y,Obj1X,Obj1Width,Obj1Height,Obj2X,Obj2Y,Obj2Width,Obj2Height = 0;
	
	public Collision(int Obj1X,int Obj1Y,int Obj1Width, int Obj1Height,int Obj2X,int Obj2Y,int Obj2Width, int Obj2Height){
		this.Obj1Y = Obj1Y;
		this.Obj1X = Obj1X;
		this.Obj1Width = Obj1Width;
		this.Obj1Height = Obj1Height;
		this.Obj2Y = Obj2Y;
		this.Obj2X = Obj2X;
		this.Obj2Width = Obj2Width;
		this.Obj2Height = Obj2Height;
		
	}
	
	public static boolean Collis(int Obj1X,int Obj1Y,int Obj1Width, int Obj1Height,int Obj2X,int Obj2Y,int Obj2Width, int Obj2Height) {
		if(Obj1Y+Obj1Height>=Obj2Y && Obj2Y+Obj2Height>=Obj1Y  && Obj1X+Obj1Width>=Obj2X && Obj2X+Obj2Width>Obj1X) {
				//System.out.println("collision");
				return true;
			}
	
		
		else {
		return false;
		}
		}
		public boolean Coll() {
			if(this.Obj1Y+Obj1Height>=Obj2Y && Obj2Y+Obj2Height>=Obj1Y  && Obj1X+Obj1Width>=Obj2X && Obj2X+Obj2Width>Obj1X) {
					//System.out.println("collision");
					return true;
				}
			else {
				return false;
			}
		}
}
