package vvoid.Void.game;

import Metroid_Editor.edit.com.Main;

public class Editor implements Runnable{
		public Editor() {
			
		}
		public void create() throws Exception {
			new Main();
			/*
			 * Editor wird nicht mehr als externe jar, sondern als neue klasse direckt erstellt.
			 * Editor kann bei bedarf optimiert werden, ist aber nicht von nöten.
			 */
			
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
