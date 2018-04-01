package vvoid.init.main;

import javax.swing.JFrame;

public class Frame extends JFrame {

	private static final long serialVersionUID = 9019603114311641540L;

	public Frame(int WIDTH,int HEIGHT,String title,boolean Resizable) {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setTitle(title);
		setSize(WIDTH, HEIGHT);
		setResizable(Resizable);
		
	}


}
