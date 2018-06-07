package vvoid.init.main;

public class Camera {
	static int x;
	static int y;
	public static final int step = 5;

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

	public static void addx(int i) {
		x -= i;
	}
	public static void addy(int i) {
		y -= i;
	}

}
