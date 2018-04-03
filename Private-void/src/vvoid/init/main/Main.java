package vvoid.init.main;


import pPrivate.Void.game.Game;

public class Main{
	public static boolean running = true;
	public static boolean paused = false;
	   private static int fps = 60;
	   private static int frameCount = 0;
		public static DrawPanel panel;
	public static void main(String[] args) throws InterruptedException {
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
	               //updateGame();comment
	        		

	               lastUpdateTime += TIME_BETWEEN_UPDATES;
	               updateCount++;
	            }
	   
	            panel.repaint();


	            lastRenderTime = now;
	         
	            int thisSecond = (int) (lastUpdateTime / 1000000000);
	            if (thisSecond > lastSecondTime)
	            {
	              // System.out.println("NEW SECOND " + thisSecond + " " + frameCount);
	               fps = frameCount;
	               frameCount = 0;
	               lastSecondTime = thisSecond;
	            }
	         
	            while ( now - lastRenderTime < TARGET_TIME_BETWEEN_RENDERS && now - lastUpdateTime < TIME_BETWEEN_UPDATES)
	            {
	               Thread.yield();
	            
	               try {Thread.sleep(1);} catch(Exception e) {} 
	            
	               now = System.nanoTime();
	            }
	         }
	      }
	}

}
