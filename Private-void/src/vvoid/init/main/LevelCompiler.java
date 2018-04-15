package vvoid.init.main;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
		InputStream file = ResourceLoader.load(("/Level/level.pll"));
		BufferedReader br = new BufferedReader(new InputStreamReader(file));
		  String st = br.readLine();
		  if(st.contains("!pllDOCUMENT")) {
		  
		  while ((st = br.readLine()) != null) {
			  if(st.contains("//") != true) {

				  int[] Object= {
						  		 convertD(st.substring(0, st.lastIndexOf("x"))),//ID
						  		 convertH(st.substring(st.lastIndexOf("x") + 1, st.lastIndexOf("-"))),//IDO IDO means IDObject
						  		 convertH(st.substring(st.lastIndexOf("-") + 1, st.lastIndexOf("y"))),//X-Coordinate
						  		 convertH(st.substring(st.lastIndexOf("y") + 1, st.lastIndexOf("w"))),//Y-Coordinate
						  		 convertH(st.substring(st.lastIndexOf("w") + 1, st.lastIndexOf("h"))),//WIDTH
						  		 convertH(st.substring(st.lastIndexOf("h") + 1, st.lastIndexOf("r"))),//HEIGHT
						  		 convertD(st.substring(st.lastIndexOf("r") + 1, st.lastIndexOf("t"))),//Rotation
						  		 convertH(st.substring(st.lastIndexOf("t") + 1, st.lastIndexOf(";"))),//TextureID
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
			if(Object[1] != 0 && Object[2] != 0) {
			createBackground(Object[1]);
			}
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
		this.path = "/Background/background+" + Integer.toString(id) + ".jpg";
		try {
			img = ImageIO.read(ResourceLoader.load((this.path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
