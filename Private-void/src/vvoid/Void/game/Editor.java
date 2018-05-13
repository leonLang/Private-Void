package vvoid.Void.game;



public class Editor implements Runnable{
		public Editor() {
			
		}
		public void create() throws Exception{
				Process ps = Runtime.getRuntime().exec(new String[] {"java", "-jar", "Metroid-editor.jar"});
					ps.waitFor();
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
