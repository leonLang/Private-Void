package vvoid.init.main;

public class Camara {
	static float x;
	float y;
	public Camara(float x, float y) {
		this.x = x;
		this.y = y;
	}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	public static void add(int i) {
		x+= i;
	}

}
