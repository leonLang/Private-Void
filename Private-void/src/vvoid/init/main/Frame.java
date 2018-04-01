package vvoid.init.main;

import javax.swing.JFrame;

public class Frame extends JFrame {
	public Frame(int WIDTH,int HEIGHT,String title,boolean Resizable) {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setTitle(title);
		setSize(WIDTH, HEIGHT);
		setResizable(Resizable);
		
	}


}
