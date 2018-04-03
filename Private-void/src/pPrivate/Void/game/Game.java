package pPrivate.Void.game;

import java.awt.Graphics;
import java.awt.Graphics2D;


import vvoid.init.main.Camera;
import vvoid.init.main.Collision;
import vvoid.init.main.Frame;
import vvoid.init.main.LevelCompiler;

public class Game {
	public static Player player;
	public static Camera cam;
	public static Enemie enemie;
	public static LevelCompiler compiler;
	public static int x = 0;
	public static void run() {
		//x++;
		//Collision.Collis(Objekte.x1, Objekte.y1, Objekte.E1Width, Objekte.E1Height, Objekte.x2, Objekte.y2, Objekte.E2Width, Objekte.E2Height);
	}
	public static void setup() {
		/*
		 * Das JFrame immer als letztes initialisieren, da sonst Fehler auftreten.
		 * Die werte für Frame müssen erst mit der Camera und der Play Klasse erstellt werden.
		 */
		cam = new Camera(0 ,0);
		player = new Player();
		enemie = new Enemie();
		compiler = new LevelCompiler();
		new Frame(1200, 800,"titel",true);
	}
	public static void draw(Graphics g) {
		g.drawImage(LevelCompiler.getbackground(), 0, 0, null);
		player.drawPlayer(g);
		Graphics g2d = (Graphics2D) g;
		g2d.translate(cam.getX(), cam.getY());
		for(int i = 0;i <= LevelCompiler.Objectlenght;i++) {
		//	LevelCompiler.objects[i].drawObjects(g);
		}
		for(int i = 0;i < LevelCompiler.EnemieLenght;i++) {
			//LevelCompiler.enemie[i].drawEnemie(g);
		}
		g2d.translate(-cam.getX(), -cam.getY());
		g.drawRect(100, 100, 100+x, 100);
		enemie.enemieType1(100, 100, g);
		
	}
	

}

