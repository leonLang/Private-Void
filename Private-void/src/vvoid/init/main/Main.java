package vvoid.init.main;

import pPrivate.Void.game.Game;

public class Main {
	public static boolean running = true;
	public static boolean paused = false;
	   private static int fps = 60;
	   private static int frameCount = 0;
	public static void main(String[] args) {
		Game.setup();
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
	      
	      while (running)
	      {
	         double now = System.nanoTime();
	         int updateCount = 0;
	         
	         if (!paused)
	         {
	            while( now - lastUpdateTime > TIME_BETWEEN_UPDATES && updateCount < MAX_UPDATES_BEFORE_RENDER )
	            {
	               //updateGame();
	               lastUpdateTime += TIME_BETWEEN_UPDATES;
	               updateCount++;
	            }
	   
	              float interpolation = Math.min(1.0f, (float) ((now - lastUpdateTime) / TIME_BETWEEN_UPDATES) );
	          //  drawGame(interpolation);
            	Game.draw();
        		Game.run();

        		System.out.println("hu");

	            lastRenderTime = now;
	         
	            //Update the frames we got.
	            int thisSecond = (int) (lastUpdateTime / 1000000000);
	            if (thisSecond > lastSecondTime)
	            {
	               System.out.println("NEW SECOND " + thisSecond + " " + frameCount);
	               fps = frameCount;
	               frameCount = 0;
	               lastSecondTime = thisSecond;
	            }
	         
	            //Yield until it has been at least the target time between renders. This saves the CPU from hogging.
	            while ( now - lastRenderTime < TARGET_TIME_BETWEEN_RENDERS && now - lastUpdateTime < TIME_BETWEEN_UPDATES)
	            {
	               Thread.yield();
	            
	               //This stops the app from consuming all your CPU. It makes this slightly less accurate, but is worth it.
	               //You can remove this line and it will still work (better), your CPU just climbs on certain OSes.
	               //FYI on some OS's this can cause pretty bad stuttering. Scroll down and have a look at different peoples' solutions to this.
	               try {Thread.sleep(1);} catch(Exception e) {} 
	            
	               now = System.nanoTime();
	            }
	         }
	      }
	      
		/*while(running) {
		Game.draw();
		Game.run();
		}
		*/
	}

}
