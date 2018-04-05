package vvoid.Void.game;

import java.awt.Graphics;
import java.awt.Graphics2D;


import vvoid.init.main.Camera;
import vvoid.init.main.Frame;
import vvoid.init.main.LevelCompiler;

public class Game {
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 800;
	public static Player player;
	public static Camera cam;
	public static LevelCompiler compiler;
	public static int x = 0;
	public static boolean peter = true;
	public static void run() {
		//x++;
		//Collision.Collis(Objekte.x1, Objekte.y1, Objekte.E1Width, Objekte.E1Height, Objekte.x2, Objekte.y2, Objekte.E2Width, Objekte.E2Height);
	}
	public static void setup() {
		/*
		 * Das JFrame immer als letztes initialisieren, da sonst Fehler auftreten.
		 * Die werte für Frame müssen erst mit der Camera und der Play Klasse erstellt werden.
		 */
		compiler = new LevelCompiler();
		cam = new Camera(0 ,0);
		player = new Player();
		new Frame(WIDTH, HEIGHT,"titel",true);
	}
	public static void draw(Graphics g) {
			g.drawImage(LevelCompiler.getbackground(), 0, 0, WIDTH, HEIGHT, null);

		player.drawPlayer(g);
		Graphics g2d = (Graphics2D) g;
		g2d.translate(cam.getX(), cam.getY());

		for(int i = 0;i < LevelCompiler.EnemieLenght;i++) {
			LevelCompiler.enemie[i].drawEnemie(g);
		}
		for(int i = 0;i < LevelCompiler.Objectlenght;i++) {
			LevelCompiler.objects[i].drawObjects(g);
		}
		g2d.translate(-cam.getX(), -cam.getY());
		
	}
	

}

