package vvoid.init.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LevelCompiler {
	public static int hex = 0x55;
	public LevelCompiler() {
		print();
		read();
	}
	public void print() {
		System.out.println(hex);
	}
	public void read() {
		try {
		File file = new File("/Private-void/src/Level/level.pll");
		BufferedReader br = new BufferedReader(new FileReader(file));
		  String st;
		  while ((st = br.readLine()) != null)
		    System.out.println(st);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
