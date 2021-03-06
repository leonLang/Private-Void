//Leon
package vvoid.init.main;

import vvoid.Void.game.Control;
import vvoid.Void.game.Game;
import vvoid.Void.game.Menue;

public class Main {
	//Modified from: http://www.java-gaming.org/index.php?topic=24220.0
	public static boolean running = true;
	public static boolean paused = false;
	public static boolean menu = true;
	public static boolean loading = false;
	public static DrawPanel panel;
	public static Menue menue;
	public static Frame mainframe;
	public static Control control;

	public static void main(String[] args) throws InterruptedException {
		control = new Control();
		mainframe = new Frame(Game.WIDTH, Game.HEIGHT, "titel", true);
		menue = new Menue();
		loop();

	}

	public static void loop() {
		final double GAME_HERTZ = 30.0;
		final double TIME_BETWEEN_UPDATES = 1000000000 / GAME_HERTZ;
		final int MAX_UPDATES_BEFORE_RENDER = 5;
		double lastUpdateTime = System.nanoTime();
		double lastRenderTime = System.nanoTime();
		final double TARGET_FPS = 60;
		final double TARGET_TIME_BETWEEN_RENDERS = 1000000000 / TARGET_FPS;
		int lastSecondTime = (int) (lastUpdateTime / 1000000000);

		while (running) {
			double now = System.nanoTime();
			int updateCount = 0;

			if (!paused) {
				while (now - lastUpdateTime > TIME_BETWEEN_UPDATES && updateCount < MAX_UPDATES_BEFORE_RENDER) {

					lastUpdateTime += TIME_BETWEEN_UPDATES;
					updateCount++;
				}
				try {
					panel.repaint();
				} catch (Exception e) {
					// TODO: handle exception
				}

				lastRenderTime = now;

				int thisSecond = (int) (lastUpdateTime / 1000000000);
				if (thisSecond > lastSecondTime) {
					lastSecondTime = thisSecond;
				}

				while (now - lastRenderTime < TARGET_TIME_BETWEEN_RENDERS
						&& now - lastUpdateTime < TIME_BETWEEN_UPDATES) {
					Thread.yield();

					try {
						Thread.sleep(1);
					} catch (Exception e) {
					}

					now = System.nanoTime();
				}
			}
		}
	}

}
