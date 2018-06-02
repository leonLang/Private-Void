package vvoid.init.main;

public class Collision {
	
	private int Obj1Y,Obj1X,Obj1Width,Obj1Height,Obj2X,Obj2Y,Obj2Width,Obj2Height = 0;
	private int z1,z2,z3,z4;
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
	

	
		
		
		public int CollOben() {
			if(Obj1Y+Obj1Height>=Obj2Y && Obj2Y+Obj2Height-1>=Obj1Y && Obj1X+Obj1Width-1>=Obj2X && Obj2X+Obj2Width-1>=Obj1X) {
					z1=1;
					//System.out.println("klappti");
					return 1;
				}
			else {
				return 0;
			}
		
		}
		public int CollUnten() {
			if(Obj1Y+Obj1Height-1>=Obj2Y && Obj2Y+Obj2Height>=Obj1Y && Obj1X+Obj1Width-1>=Obj2X && Obj2X+Obj2Width-1>=Obj1X) {
					z1=1;
					//System.out.println("klappti");
					return 1;
				}
			else {
				return 0;
			}
		
		}
		public int CollLinks() {
			if(Obj1Y+Obj1Height-1>=Obj2Y && Obj2Y+Obj2Height-1>=Obj1Y && Obj1X+Obj1Width>=Obj2X && Obj2X+Obj2Width-1>=Obj1X) {
					z1=1;
					//System.out.println("klappti");
					return 1;
				}
			else {
				return 0;
			}
		
		}
		public int CollRechts() {
			if(Obj1Y+Obj1Height-1>=Obj2Y && Obj2Y+Obj2Height-1>=Obj1Y && Obj1X+Obj1Width-1>=Obj2X && Obj2X+Obj2Width>=Obj1X) {
					z1=1;
					//System.out.println("klappti");
					return 1;
				}
			else {
				return 0;
			}
		
		}
		public int CollObenP() {
			if(Obj1Y+Obj1Height+2>=Obj2Y && Obj2Y+Obj2Height-1>=Obj1Y && Obj1X+Obj1Width-1>=Obj2X && Obj2X+Obj2Width-1>=Obj1X) {
					z1=1;
					//System.out.println("klappti");
					return 1;
				}
			else {
				return 0;
			}
		
		}
		public int CollUntenP() {
			if(Obj1Y+Obj1Height-1>=Obj2Y && Obj2Y+Obj2Height+2>=Obj1Y && Obj1X+Obj1Width-1>=Obj2X && Obj2X+Obj2Width-1>=Obj1X) {
					z1=1;
					//System.out.println("klappti");
					return 1;
				}
			else {
				return 0;
			}
		
		}
		public int CollLinksP() {
			if(Obj1Y+Obj1Height-1>=Obj2Y && Obj2Y+Obj2Height-1>=Obj1Y && Obj1X+Obj1Width+1>=Obj2X && Obj2X+Obj2Width-1>=Obj1X) {
					z1=1;
					//System.out.println("klappti");
					return 1;
				}
			else {
				return 0;
			}
		
		}
		public int CollRechtsP() {
			if(Obj1Y+Obj1Height-1>=Obj2Y && Obj2Y+Obj2Height-1>=Obj1Y && Obj1X+Obj1Width-1>=Obj2X && Obj2X+Obj2Width+2
					>=Obj1X) {
					z1=1;
					//System.out.println("klappti");
					return 1;
				}
			else {
				return 0;
			}
		
		}
		public int Coll1() {
			if(this.Obj1Y+Obj1Height>=Obj2Y && Obj2Y+Obj2Height>=Obj1Y && Obj1X+Obj1Width>=Obj2X && Obj2X+Obj2Width>=Obj1X) {
					z1=1;
					//System.out.println("klappti");
					return 1;
				}
			else {
				return 0;
			}
		}
		public int Coll2() {
			if(Obj1Y+Obj1Height>=Obj2Y && Obj2Y+Obj2Height>=Obj1Y && Obj1X+Obj1Width>=Obj2X && Obj2X+Obj2Width+1>=Obj1X) {
					z1=1;
					//System.out.println("links");
					return 1;
				}
			else {
				return 0;
			}
		}
		public int Coll3() {
			if(Obj1Y+Obj1Height>=Obj2Y && Obj2Y+Obj2Height+1>=Obj1Y && Obj1X+Obj1Width>=Obj2X && Obj2X+Obj2Width>=Obj1X) {
					z1=1;
					//System.out.println("unten");
					return 1;
				}
			else {
				return 0;
			}
		
		}
		public int Coll4() {
			if(Obj1Y+Obj1Height>=Obj2Y && Obj2Y+Obj2Height-1>=Obj1Y && Obj1X+Obj1Width-1>=Obj2X && Obj2X+Obj2Width-1>=Obj1X) {
					z1=1;
					//System.out.println("klappti");
					return 1;
				}
			else {
				return 0;
			}
		
		}
		
		
}
