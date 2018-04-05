package vvoid.init.main;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TextureSystem {
	static String TexturePath;
	static BufferedImage img;
	public static BufferedImage TextureSystem(int tid) {
		TexturePath = "assats/textures/Objects/texture" + tid + ".jpg";
		
		try {
			img = ImageIO.read(new File(TexturePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
		
		
	}
}
