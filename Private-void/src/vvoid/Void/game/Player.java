package vvoid.Void.game;

import java.awt.Graphics;

import vvoid.init.main.Camera;
import vvoid.map.objects.EOArrey;

public class Player {
	public boolean l,r;
	public boolean u,d;
	public String facing;
	public int x;
	public int y;
	public int XSolid;
	public int YSolid;
	public int width;
	public int height;
	public Shot[] shots;
	public static int ashots;

	public Player(int x, int y, int width, int height, String facing) {
		this.x = x;
		this.y = y;
		this.XSolid = x;
		this.YSolid = y;
		this.width = width;
		this.height = height;
		this.facing = facing;

		this.l = false;
		this.r = false;
		
		this.ashots = 0;
		this.shots = new Shot[64];

		//(new Thread(new Pgravity())).start();
	}

	public void drawPlayer(Graphics g) {
		g.drawRect(this.XSolid, this.YSolid, this.width, this.height);
		// System.out.println(x);
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
	public void shoot() {
		if(Player.ashots < shots.length) {
		shots[Player.ashots] = new Shot(getfacing());
		}
	}

	public void addX(int i) {
		this.x -= i;
	}

	public void addY(int i) {
		this.y -= i;
	}

	private class movment implements Runnable {
		private String c;

		public movment(String c) {
			this.c = c;
		}

		public void MoveLeft() {

			facing = "left";
			while (l) {
				if (EOArrey.leftP == true) {
					// namen sind jetzt auf englisch
					// früher linksP jetzt leftP
					l = false;
				} else {
					Camera.addx(-Camera.step);
					Game.player.addX(Camera.step);
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (EOArrey.rightP == true) {
				}

			}
		}

		public void MoveRight() {
			facing = "right";
			while (r) {
				if (EOArrey.rightP == true) {
					r = false;
				} else {
					Camera.addx(Camera.step);
					Game.player.addX(-Camera.step);
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		public void MoveUp() {
			facing = "up";
			while (u) {
				if (EOArrey.upP == true) {
					u = false;
				} else {
					Camera.addy(-Camera.step);
					Game.player.addY(Camera.step);
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		public void MoveDown() {
			facing = "down";
			while (d) {
				if (EOArrey.downP == true) {
					d = false;
				} else {
					Camera.addy(Camera.step);
					Game.player.addY(-Camera.step);
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		public void jump() {
			
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
			case "u":
				MoveUp();
				break;
			case "d":
				MoveDown();
				break;
			}
			Thread.currentThread().interrupt();
		}
	}

	private class Pgravity implements Runnable {

		private void gravity() {
			while (EOArrey.downP != true) {
				Camera.addy(Camera.step);
				Game.player.addY(-Camera.step);
				
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			gravity();

		}

		@Override
		public void run() {
			gravity();

		}
	}
}
