package vvoid.init.main;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;

public class LevelCompiler {
	private String path;
	public static Image img;
	public LevelCompiler() {

		read();
	}

	public void read() {


		try {
		File file = new File("Level/level.pll");
		BufferedReader br = new BufferedReader(new FileReader(file));
		  String st = br.readLine();
		  if(st.contains("!pllDOCUMENT")) {
		  while ((st = br.readLine()) != null) {
			  if(st.contains("//") != true) {

				  int[] Object= {
						  		 convertB(st.substring(0, 2)),//ID
						  		 convertH(st.substring(3, 7)),//IDO
						  		 convertH(st.substring(8, 12)),//X-Coordinate
						  		 convertH(st.substring(13, 17)),//Y-Coordinate
						  		 convertD(st.substring(18, 21)),//Rotation
						  		 convertH(st.substring(22, 26))//TextureID
						  		 };
				    System.out.println(st);
				    System.out.println(Arrays.toString(Object));
					CreateObject(Object);
			  	}
		  	}
		  } else {
			  System.out.println("this is not a pll file");
		  }
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int convertH(String s) {
		int p = Integer.parseInt(s, 16);
		return p;
	}
	public int convertD(String s) {
		int p = Integer.parseInt(s, 10);
		return p;
	}
	public int convertB(String s) {
		int p = Integer.parseInt(s, 2);
		return p;
	}
	public void CreateObject(int[] Object) throws Exception {
		System.out.println(Arrays.toString(Object));
		switch(Object[0]) {
		case 0:
			System.out.println(0);
			createBackground(Object[1]);
			break;
		case 1:
			createObject(Object[1],Object[2],Object[3],Object[4],Object[5]);
			break;
		case 2:
			break;
		default:
			throw new Exception("The id of the Object is not avalible:" + Object[0]);
		}
	}
	
	private void  createBackground(int id) {
		this.path = "Background/background" + Integer.toString(id) + ".jpg";
		try {
			img = ImageIO.read(new File(this.path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(path);
	}
	public static Image getbackground() {
		return img;
	}
	
	private void createObject(int ID, int x, int y, int rotation, int TextureID) {
		
	}
	private void createEnemie() {
		
	}

}
