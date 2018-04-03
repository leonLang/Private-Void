package vvoid.init.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import pPrivate.Void.game.Objekte;

public class LevelCompiler {
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
						  		 convertB(st.substring(0, 2)),
						  		 convertH(st.substring(3, 7)),
						  		 convertH(st.substring(8, 12)),
						  		 convertH(st.substring(13, 17)),
						  		 convertD(st.substring(18, 21)),
						  		 convertH(st.substring(22, 26))
						  		 };
				    System.out.println(st);
				    System.out.println(Arrays.toString(Object));
					Objekte.CreateObject(Object);
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

}
