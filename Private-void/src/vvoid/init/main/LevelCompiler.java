package vvoid.init.main;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;

import pPrivate.Void.game.Enemie;
import pPrivate.Void.game.Objekt;

public class LevelCompiler {
	private String path;
	public static Image img;

	public static Enemie[] enemie = new Enemie[(int) Math.pow(2, 15)];
	public static int EnemieLenght = 0;
	public static Objekt[] objects = new Objekt[(int) Math.pow(2, 15)];
	public static int Objectlenght = 0;
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
						  		 convertD(st.substring(0, 2)),//ID
						  		 convertH(st.substring(3, 7)),//IDO
						  		 convertH(st.substring(8, 12)),//X-Coordinate
						  		 convertH(st.substring(13, 17)),//Y-Coordinate
						  		 convertD(st.substring(18, 21)),//Rotation
						  		 convertH(st.substring(22, 26))//TextureID
						  		 };
				   // System.out.println(st);
				    //System.out.println(Arrays.toString(Object));
					CreateObject(Object);
			  	}
		  	}
		  
		  } else {
			  System.out.println("this is not a .pll file");
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

	public void CreateObject(int[] Object) throws Exception {
		//System.out.println(Arrays.toString(Object));
		switch(Object[0]) {
		case 0:
			
			createBackground(Object[1]);
			break;
		case 1:
			createObject(Object[1],Object[2],Object[3],Object[4],Object[5]);
			break;
		case 2:
			createEnemie(Object[1],Object[2],Object[3],Object[4],Object[5]);
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
	
	private void createObject(int IDO, int x, int y, int rotation, int TextureID) {
		objects[Objectlenght] = new Objekt(IDO,x,y,rotation,TextureID);
		Objectlenght++;
	}
	private void createEnemie(int IDO, int x, int y, int rotation, int TextureID) {
		enemie[EnemieLenght] = new Enemie(IDO,x,y,rotation,TextureID);
		EnemieLenght++;
	}

}
