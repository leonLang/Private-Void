package vvoid.init.main;

import java.io.InputStream;

public final class ResourceLoader {

	public static InputStream load(String path) {
		InputStream input = ResourceLoader.class.getResourceAsStream(path);
		if (input == null) {
			System.out.println("fehler");
		}
		return input;
	}

}
