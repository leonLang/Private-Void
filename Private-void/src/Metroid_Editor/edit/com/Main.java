//peter
package Metroid_Editor.edit.com;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import vvoid.images.SpriteSheet;

public class Main {
	public static JFrame frame;
	public static SpriteSheet sheet;
	Panel panel;
	public Main() {
		sheet = new SpriteSheet();
		Toolkit.getDefaultToolkit();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel = new Panel();
		frame();
	}
	public void frame() {
		frame = new JFrame("Metroid Editor");
		frame.setSize(200, 200);
		frame.setVisible(true);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
