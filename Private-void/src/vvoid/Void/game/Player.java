package vvoid.Void.game;

import java.awt.Graphics;

import vvoid.init.main.Camera;

public class Player {
	public boolean l;
	public boolean r;
	public String facing;
	public int x;
	public int y;
	public int width;
	public int height;
	
	public Player(int x, int y, int width, int height,String facing) {
		x = this.x;
		y = this.y;
		width = this.width;
		height = this.height;
		facing = this.facing;
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
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
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
