package vvoid.init.main;

public class Camera {
	static float x;
	float y;
	public Camera(float x, float y) {
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
		x-= i;
	}

}
