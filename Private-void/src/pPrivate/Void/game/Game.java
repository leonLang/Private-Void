package pPrivate.Void.game;

import java.awt.Graphics;
import java.awt.Graphics2D;


import vvoid.init.main.Camera;
import vvoid.init.main.Collision;
import vvoid.init.main.Frame;
import vvoid.init.main.LevelCompiler;

public class Game {
	//public static Player player;
	public static Camera cam;
	public static Player player;
	public static LevelCompiler compiler;
	public static int x = 0;
	public static void run() {
		//x++;
		Collision.Collis(Objekte.x1, Objekte.y1, Objekte.E1Width, Objekte.E1Height, Objekte.x2, Objekte.y2, Objekte.E2Width, Objekte.E2Height);
	}
	public static void setup() {
		compiler = new LevelCompiler();
		for(int i = 0;i < LevelCompiler.Objectlenght;i++) {
			System.out.println(LevelCompiler.objects[i]);
		}
		player = new Player();
		new Frame(1200, 800,"titel",true);

		cam = new Camera(0 ,0);
	}
	public static void draw(Graphics g) {
		g.drawImage(LevelCompiler.getbackground(), 0, 0, null);
		Player.drawPlayer(g);
		Objekt.drawObjects(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(cam.getX(), cam.getY());
		g.drawRect(100, 100, 100+x, 100);
		
	}
	

}

