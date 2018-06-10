package vvoid.init.main;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import javax.imageio.ImageIO;

import vvoid.Void.game.Game;
import vvoid.Void.game.Menue;
import vvoid.map.objects.Enemie;
import vvoid.map.objects.Event;
import vvoid.map.objects.Objekt;

public class LevelCompiler {
	private String path;
	public static BufferedImage img;
	
	public static int PX;
	public static int PY;

	public static Enemie[] enemie = new Enemie[(int) Math.pow(2, 15)];
	public static int EnemieLenght = 0;
	public static Objekt[] objects = new Objekt[(int) Math.pow(2, 15)];
	public static int Objectlenght = 0;
	public static Event[] event = new Event[(int) Math.pow(2, 15)];
	public static int EventLenght = 0;
	private float count = 0;
	private float zahl = 0;
	private int lenght = 0;
	private int liness;


	public LevelCompiler() {

		liness = lines();
		zahl = liness/100;
		read();
	}
	public int lines() {
		try {
			InputStream file = ResourceLoader.load("/Level/level.pll");
				BufferedReader fr = new BufferedReader(new InputStreamReader(file));
				LineNumberReader lnr = new LineNumberReader(fr);
				int lines = 0;
				while (lnr.readLine() != null) {
					lines++;
				}
				lnr.close();
				return lines;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public void load() {
		if(1/zahl < 1) {
			count += 1/zahl;
		}
		if(1/zahl >= 1 || count >= 1) {
			lenght++;
			count = 0;
		}
		Menue.bar.setValue(lenght);
		Main.panel.repaint();
	}

	public void read() {
		try {
			InputStream file = ResourceLoader.load(("/Level/level.pll"));
			BufferedReader br = new BufferedReader(new InputStreamReader(file));
			String st = br.readLine();
			if (st.contains("!pllDOCUMENT")) {
				System.out.println("lines" + lines());
				st = br.readLine();
				System.out.println("ID: " + st.substring(st.lastIndexOf(":") + 1, st.lastIndexOf(";")));
				st = br.readLine();
				PX = (Integer.parseInt(st.substring(1,st.lastIndexOf("Y"))));
				PY = (Integer.parseInt(st.substring(st.lastIndexOf("Y") + 1,st.lastIndexOf(";"))));
				
				
				while ((st = br.readLine()) != null) {
					if (st.contains("//") != true) {

						int[] Object = { 
								convertD(st.substring(0, st.lastIndexOf("x"))), // ID
								convertH(st.substring(st.lastIndexOf("x") + 1, st.lastIndexOf("-"))), // IDO IDO means
																										// IDObject
								convertH(st.substring(st.lastIndexOf("-") + 1, st.lastIndexOf("y"))), // X-Coordinate
								convertH(st.substring(st.lastIndexOf("y") + 1, st.lastIndexOf("w"))), // Y-Coordinate
								convertH(st.substring(st.lastIndexOf("w") + 1, st.lastIndexOf("h"))), // WIDTH
								convertH(st.substring(st.lastIndexOf("h") + 1, st.lastIndexOf("r"))), // HEIGHT
								convertD(st.substring(st.lastIndexOf("r") + 1, st.lastIndexOf("t"))), // Rotation
								convertH(st.substring(st.lastIndexOf("t") + 1, st.lastIndexOf(";"))),// TextureID
						};
						CreateObject(Object);
					}
					load();
				}
				Main.panel.remove(Menue.bar);
				Main.panel.remove(Menue.l1);
				Game.setup();

			} else {
				System.out.println("this is not a .pll file");
			}
		} catch (Exception e) {
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
		switch (Object[0]) {
		case 0:
			if (Object[1] != 0) {
				createBackground(Object[1]);
			}
			break;
		case 1:
			createObject(Object);
			break;
		case 2:
			// soft object;
			break;
		case 3:
			createEnemie(Object);
			break;
		case 4:
			createEvent(Object);
			break;
		default:
			throw new Exception("The id of the Object is not avalible:" + Object[0]);
		}
	}

	private void createBackground(int id) {
		System.out.println("testest");
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
