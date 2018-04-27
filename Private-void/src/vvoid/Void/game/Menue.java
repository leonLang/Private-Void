package vvoid.Void.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import vvoid.init.main.Main;

public class Menue implements ActionListener {
	private JButton b1;
	private JButton b2;
	private JButton b3;
	public static JProgressBar bar;

	public static JLabel l1;

	public Menue() {
		b1 = new JButton("Start Game");
		b2 = new JButton("Load Game");
		b3 = new JButton("Settings");

		b1.addActionListener(this);

		l1 = new JLabel("Loading...");

		loading();

		// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

	}

	public void drawMenue() {
		if (Main.menu) {
			Main.panel.add(b1);
			Main.panel.add(b2);
			Main.panel.add(b3);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			b1.removeActionListener(this);;
			Main.panel.remove(b1);
			Main.panel.remove(b2);
			Main.panel.remove(b3);
			bar.setVisible(true);
			l1.setVisible(true);
			Main.panel.repaint();
			Main.loading = true;
			Main.menu = false;
			(new Game()).start();

		} else {
		}

	}
}
