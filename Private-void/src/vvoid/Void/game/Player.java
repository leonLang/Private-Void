package vvoid.Void.game;

import java.awt.Graphics;

import vvoid.init.main.Camera;

public class Player {
	public boolean l;
	public boolean r;
	public String facing;
	
	public Player() {
		facing = "left";
		new Pgravity();
	}

	public void drawPlayer(Graphics g) {
		g.drawRect(200, 200, 100, 100);
	}

	public void Move(String c) {
		(new Thread(new movment(c))).start();
	}
	public String getfacing() {
		return facing;
	}
	public void UP() {
		
	}
	public void DOWN() {
		
	}

	private class movment implements Runnable {
		private String c;

		public movment(String c) {
			this.c = c;
		}

		public void MoveLeft() {
			facing = "left";
			while (l) {
				Camera.addx(-10);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public void MoveRight() {
			facing ="right";
			while (r) {
				Camera.addx(10);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		@Override
		public void run() {
			switch (c) {
			case "l":
				MoveLeft();
				break;
			case "r":
				MoveRight();
				break;
			}
			Thread.currentThread().interrupt();
		}
	}
	private class Pgravity {
		
	}
}
