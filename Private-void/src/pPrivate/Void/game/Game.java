package pPrivate.Void.game;

import java.awt.Graphics;

import vvoid.init.main.Frame;

public class Game {
	public static void run() {
		
	}
	public static void setup() {
		new Frame(800, 800,"titel",true);
	}
	public static void draw(Graphics g) {
		g.drawRect(100, 100, 100, 100);
		
	}
	

}
