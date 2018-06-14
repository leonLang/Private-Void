//Peter
package vvoid.init.main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TextureSystem {
	static String TexturePath;
	static BufferedImage img;

	public static BufferedImage textureSystem(int tid) {
		TexturePath = "/textures/Objects/SObject+" + tid + ".jpg";
		try {
			img = ImageIO.read(ResourceLoader.load((TexturePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;

	}
}
