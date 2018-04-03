package pPrivate.Void.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemie {
	public static String pipeO = "metroid.png";
	private static BufferedImage pipe1;
	public static int E1Width=200;
	public static int E1Height=200;
	public static int x2;
	public static int x3;
	public static int x4;
	
	public Enemie() {
		try {
			pipe1 = ImageIO.read(getClass().getResourceAsStream(pipeO));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//this.x2 = x2;
		//this.x3 = x3;
		//this.x4 = x4;	
	}
	public static void createEnemie(int ID,Graphics g,int x, int y) {
		x2= x;
		x3 =y;
		switch(ID) {
		case 1:
			enemieType1(x2, x3, g);
			break;
			//usw.1
		case 2:
			enemieType2(x2, x3,  g);
			break;
		}
	}
	public static void enemieType1(int x, int y, Graphics g) {
		g.drawRect(x, y, E1Width, E1Height);
		g.drawImage(pipe1,100,100,100,100,null);
	}
	public static void enemieType2(int x, int y, Graphics g) {
		g.drawRect(x, y, E1Width, E1Height);

	}
//0
}


