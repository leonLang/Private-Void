//Peter
package vvoid.Void.game;

import java.awt.Graphics;
import java.awt.Graphics2D;

import vvoid.images.SpriteSheet;
import vvoid.init.main.Camera;
import vvoid.init.main.LevelCompiler;
import vvoid.init.main.Main;

public class Game extends Thread{
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;
    public static Player player;
    public static Camera cam;
    public static LevelCompiler compiler;
    public static int x = 0;
    public static boolean move = false;
    public static SpriteSheet sheet;
    public static int leben = 3;
    public void run() {
    	sheet = new SpriteSheet();
        cam = new Camera(0, 0);
        player = new Player(WIDTH/2,HEIGHT/2-200,40,80,"left");
        compiler = new LevelCompiler(1);
    }
    public static void setup() {
        /*
         * Das JFrame immer als letztes initialisieren, da sonst Fehler auftreten. Die
         * werte fï¿½r Frame mï¿½ssen erst mit der Camera und der Play Klasse erstellt
         * diese klasse suckt
         * werden.
         */
    	System.out.println("jo");
        Main.loading = false;

    } 

    public static void draw(Graphics g) {
    	
        g.drawImage(LevelCompiler.getbackground(), 0, 0, WIDTH, HEIGHT, null);
        g.drawString("Leben:" + leben, 1100, 20);
        player.drawPlayer(g);
        Graphics g2d = (Graphics2D) g;
        g2d.translate(cam.getX(), cam.getY());
		for(int i = 0; i < Player.ashots;i++) {
			player.shots[i].draw(g);
		}
		for(int i = 0;i < LevelCompiler.EventLenght;i++) {
			LevelCompiler.event[i].drawEvent(g);
			
		}
        
        for (int i = 0; i < LevelCompiler.EnemieLenght; i++) {
            LevelCompiler.enemie[i].drawEnemie(g);
        }

        if (move = true)
            for (int i = 0; i < LevelCompiler.Objectlenght; i++) {
                LevelCompiler.objects[i].drawObjects(g);
            }
        g2d.translate(-cam.getX(), -cam.getY());

    }

}