package vvoid.Void.collision;

public class ObjektColl {
	public static int[] widthO = new int[10000];// width(blocks)
	public static int[] heightO = new int[10000];// height (blocks)
	public static int[] xO = new int[10000]; // x-position (blocks)
	public static int[] yO = new int[10000]; // y-postion (blocks)
	public static int oAmount = -1;

	public ObjektColl(int width, int height, int x, int y) {
		oAmount++;
		widthO[oAmount] = width;
		heightO[oAmount] = height;
		xO[oAmount] = x;
		yO[oAmount] = y;
	}
}
