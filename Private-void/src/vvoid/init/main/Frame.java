package vvoid.init.main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import pPrivate.Void.game.DrawPanel;

public class Frame extends JFrame {
		


	public Frame(int WIDTH,int HEIGHT,String title,boolean Resizable) {
		 Main.panel = new DrawPanel();
		add(Main.panel);
		//get screen size
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWIDTH = (int) screen.getWidth();
		int screenHEIGHT = (int) screen.getHeight();
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(screenWIDTH/2-WIDTH/2,screenHEIGHT/2-HEIGHT/2);
		
		setTitle(title);
		setSize(WIDTH, HEIGHT);
		setResizable(Resizable);
		
	}


}
