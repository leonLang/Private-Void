package vvoid.Void.game;

import java.awt.Graphics;
import java.awt.Graphics2D;

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

    public void run() {
        compiler = new LevelCompiler();
    }
    public static void setup() {
        /*
         * Das JFrame immer als letztes initialisieren, da sonst Fehler auftreten. Die
         * werte fï¿½r Frame mï¿½ssen erst mit der Camera und der Play Klasse erstellt
         * diese klasse suckt
         * werden.
         */
        cam = new Camera(0, 0);
        player = new Player();
        Main.loading = false;
    } 

    public static void draw(Graphics g) {
        g.drawImage(LevelCompiler.getbackground(), 0, 0, WIDTH, HEIGHT, null);
        player.drawPlayer(g);
        Graphics g2d = (Graphics2D) g;
        g2d.translate(cam.getX(), cam.getY());

        for (int i = 0; i < LevelCompiler.EnemieLenght; i++) {
            LevelCompiler.enemie[i].drawEnemie(g);
            LevelCompiler.enemie[i].drawEnemie(g);
        }

        if (move = true)
            for (int i = 0; i < LevelCompiler.Objectlenght; i++) {
                LevelCompiler.objects[i].drawObjects(g);
            }
        g2d.translate(-cam.getX(), -cam.getY());

    }

}