package vvoid.init.main;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;

import vvoid.map.objects.Enemie;
import vvoid.map.objects.Event;
import vvoid.map.objects.Objekt;

public class LevelCompiler {
	private String path;
	public static BufferedImage img;

	public static Enemie[] enemie = new Enemie[(int) Math.pow(2, 15)];
	public static int EnemieLenght = 0;
	public static Objekt[] objects = new Objekt[(int) Math.pow(2, 15)];
	public static int Objectlenght = 0;
	public static Event[] event = new Event[(int) Math.pow(2,  15)];
	public static int EventLenght = 0;
	public LevelCompiler() {

		read();
	}

	public void read() {


		try {
		File file = new File("assats/Level/level.pll");
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(file));
		  String st = br.readLine();
		  if(st.contains("!pllDOCUMENT")) {
		  
		  while ((st = br.readLine()) != null) {
			  if(st.contains("//") != true) {

				  int[] Object= {
						  		 convertD(st.substring(0, 2)),//ID
						  		 convertH(st.substring(3, 7)),//IDO IDO means IDObject
						  		 convertH(st.substring(8, 12)),//X-Coordinate
						  		 convertH(st.substring(13, 17)),//Y-Coordinate
						  		 convertH(st.substring(18, 22)),//WIDTH
						  		 convertH(st.substring(23, 27)),//HEIGHT
						  		 convertD(st.substring(28, 31)),//Rotation
						  		 convertH(st.substring(32, 36)),//TextureID
						  		 };
				    //System.out.println(st);
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
			createObject(Object);
			break;
		case 2:
			createEnemie(Object);
			break;
		case 3:
			createEvent(Object);
			break;
		default:
			throw new Exception("The id of the Object is not avalible:" + Object[0]);
		}
	}
	
	private void  createBackground(int id) {
		this.path = "assats/Background/background" + Integer.toString(id) + ".jpg";
		try {
			img = ImageIO.read(new File(this.path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(path);
	}
	public static BufferedImage getbackground() {
		return img;
	}
	
	private void createObject(int[] data) {
		objects[Objectlenght] = new Objekt(data);
		Objectlenght++;
	}
	private void createEnemie(int[] data) {
		enemie[EnemieLenght] = new Enemie(data);//
		EnemieLenght++;
	}
	private void createEvent(int[] data) {
		event[EventLenght] = new Event(data);
		EventLenght++;
	};
		

}
