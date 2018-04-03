package vvoid.init.main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TextureSystem {
	String s;
	BufferedImage img;
	public TextureSystem(int tid) {
		s = "texture" + tid + ".jpg";
		
		try {
			img = ImageIO.read(new File(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
