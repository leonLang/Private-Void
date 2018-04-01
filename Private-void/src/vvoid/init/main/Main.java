package vvoid.init.main;

import pPrivate.Void.game.Game;

public class Main {
	public static boolean running = false;
	public static void main(String[] args) {
		
	}
	public void loop() {
		while(running) {
		Game.draw();
		Game.run();
		}
	}

}
