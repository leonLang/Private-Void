//peter
package vvoid.init.main;

public class Camera {
	static int x;
	static int y;
	public static final int step = 1;

	public Camera(int x, int y) {
		Camera.x = x;
		Camera.y = y;
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
