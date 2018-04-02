package pPrivate.Void.game;

import java.awt.Graphics;
import java.awt.Graphics2D;


import vvoid.init.main.Camera;
import vvoid.init.main.Collision;
import vvoid.init.main.Frame;

public class Game {
	//public static Player player;
	public static Camera cam;
	public static Player player;
	public static int x = 0;
	public static void run() {
		//x++;
		Collision.Collis(200, 200, Objekte.E1Width, Objekte.E1Height, 200, 100, Objekte.E2Width, Objekte.E2Height);
	}
	public static void setup() {
		player = new Player();
		new Frame(1200, 800,"titel",true);

		cam = new Camera(0 ,0);
	}
	public static void draw(Graphics g) {
		Player.drawPlayer(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(cam.getX(), cam.getY());
		g.drawRect(100, 100, 100+x, 100);
		
	}
	

}
