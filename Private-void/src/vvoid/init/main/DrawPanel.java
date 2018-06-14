//Peter & Leon
package vvoid.init.main;

import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JPanel;

import vvoid.Void.game.Game;

public class DrawPanel extends JPanel {
	private static final long serialVersionUID = -7664245199454481726L;

	public DrawPanel() {
	}

	@Override
	public void paintComponent(Graphics g) {
		Toolkit.getDefaultToolkit();
		super.paintComponent(g);
		if(Main.menu != true && Main.loading != true) {
		Game.draw(g);
	//	System.out.println("draw");
		} else {
			try {
			Main.menue.drawMenue();
			} catch(Exception e) {
				e.printStackTrace();
				
			}
			
		}
		
	}

}