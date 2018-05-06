package vvoid.Void.game;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import vvoid.init.main.Main;

public class Menue {
	private JButton[] b = new JButton[4];
	public static JProgressBar bar;
	public static int MenueNumber;

	public static JLabel l1;

	public Menue() {
		/*optional kann ein Hintergrund implementiert werden
		 * Ich empfehle kein JLabel zu nehmen
		 * ->Resultat davon ist eine Draw exception in DrawPanel 22;
		 * 
		 */
		
		
		MenueNumber = 1;
		b[1] = new JButton("Start Game");
		b[2] = new JButton("Load Game");
		b[3] = new JButton("Settings");

		l1 = new JLabel("Loading...");


		loading();
		for(int i = 1;i < b.length;i++) {
			b[i].setBackground(Color.gray);
		}
		b[1].setBackground(Color.YELLOW);

		// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

	}
	public void ChangeOption(int n, int m) {
		b[MenueNumber - m].setBackground(Color.gray);
		b[n].setBackground(Color.YELLOW);
	}

	public void drawMenue() {
		if (Main.menu) {
			try {
			Main.panel.add(b[1]);
			Main.panel.add(b[2]);
			Main.panel.add(b[3]);
			} catch(Exception e) {
				e.printStackTrace();
				try {
					Thread.sleep(50);
					Main.panel.add(b[1]);
					Main.panel.add(b[2]);
					Main.panel.add(b[3]);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public void loading() {
		bar = new JProgressBar(0, 100);
		bar.setVisible(false);
		l1.setVisible(false);
		bar.setValue(0);
		bar.setStringPainted(true);
		Main.panel.add(l1);
		Main.panel.add(bar);
	}

	public void loadinto() {
			Main.panel.remove(b[1]);
			Main.panel.remove(b[2]);
			Main.panel.remove(b[3]);
			bar.setVisible(true);
			l1.setVisible(true);
			Main.panel.repaint();
			Main.loading = true;
			Main.menu = false;
			(new Game()).start();

	}
}
