package pPrivate.Void.game;

import java.awt.Graphics;
import java.awt.Graphics2D;

import vvoid.init.main.Camara;
import vvoid.init.main.Frame;

public class Game {
	public static Player player;
	public static Camara cam;
	public static int x = 0;
	public static void run() {
		//x++;
		Camara.add(1);
	}
	public static void setup() {
		new Frame(1200, 800,"titel",true);
		player = new Player();
		cam = new Camara(0 ,0);
	}
	public static void draw(Graphics g) {
		Player.drawPlayer(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(cam.getX(), cam.getY());
		g.drawRect(100, 100, 100+x, 100);
		
	}
	

}
