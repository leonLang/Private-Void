package vvoid.map.objects;

public class EOArrey {
	public static int[] widthE = new int[10000];
	public static int[] heightE = new int[10000];
	public static int[] xE = new int[10000];
	public static int[] yE = new int[10000];
	public static int[] widthO = new int[10000];
	public static int[] heightO = new int[10000];
	public static int[] xO = new int[10000];
	public static int[] yO = new int[10000];
	public static int zA;



	public static void Enemy(int width, int height, int x, int y) {
		widthE[zA] = width;
		heightE[zA] = height;
		xE[zA] = x;
		yE[zA] = y;

		System.out.println(xE[zA]);
		System.out.println(zA);
		zA++;
		
	}
}
