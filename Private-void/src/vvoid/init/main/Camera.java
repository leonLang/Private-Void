package vvoid.init.main;

public class Camera {
	static int x;
	int y;
	public Camera(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public static void add(int i) {
		x-= i;
	}

}
