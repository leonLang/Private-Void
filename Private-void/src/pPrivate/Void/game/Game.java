package pPrivate.Void.game;

import java.awt.Graphics;

import vvoid.init.main.Frame;
import vvoid.init.main.LevelCompiler;

public class Game {
	public static int x = 0;
	public static void run() {
		x++;
	}
	public static void setup() {
		new Frame(1200, 800,"titel",true);
		new LevelCompiler();
	}
	public static void draw(Graphics g) {
		g.drawRect(100, 100, 100+x, 100);
		
	}
	

}
