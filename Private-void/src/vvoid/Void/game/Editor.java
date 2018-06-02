package vvoid.Void.game;

import Metroid_Editor.edit.com.Main;

public class Editor implements Runnable{
		public Editor() {
			
		}
		public void create() throws Exception {
			new Main();
				/*Process ps = Runtime.getRuntime().exec(new String[] {"java", "-jar", "Metroid-editor.jar"});
					ps.waitFor();
					*/
		}
		@Override
		public void run() {
			try {
				create();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
}
