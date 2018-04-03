package pPrivate.Void.game;

public class Enemy {
	int x2;
	int x3;
	int x4;
	public Enemy(int x1, int x2, int x3, int x4) {
		this.x2 = x2;
		this.x3 = x3;
		this.x4 = x4;
		createEnemie(x1);
	}
	private void createEnemie(int ID) {
		switch(ID) {
		case 1:
			enemieType1(this.x2, this.x3, this.x4);
			break;
			//usw.
		}
	}
	private void enemieType1(int x, int y, int textureId) {
		
	}

}
