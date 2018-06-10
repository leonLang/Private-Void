package vvoid.Void.game;

import java.awt.Graphics;

import vvoid.init.main.Camera;
import vvoid.map.objects.EOArrey;

public class Player {
	public int cp;
	public int count;
	public boolean l, r;
	public boolean u, d;
	public boolean j;
	public boolean waitl, waitr, waitu, waitd;
	public String facing;
	public int x;
	public int y;
	public int XSolid;
	public int YSolid;
	public int width;
	public int height;
	public Shot[] shots;
	public static int ashots;
	public int sleep;
	int test =0,test1;
	public Gravity grav = new Gravity();
	public EOArrey eo = new EOArrey();
	public Player(int x, int y, int width, int height, String facing) {
		this.x = x;
		this.y = y;
		this.XSolid = x;
		this.YSolid = y;
		this.width = width;
		this.height = height;
		this.facing = facing;
		this.sleep = 1;
		this.count = 0;
		this.count = 0;
		this.cp = 0;

		this.l = false;
		this.r = false;
		this.j = false;

		
		
		this.ashots = 0;
		this.shots = new Shot[64];

		(new Thread(new Pgravity())).start();
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
		if (Player.ashots < shots.length) {
			shots[ashots] = shots[Player.ashots] = new Shot(getfacing(),this.x,this.y);
			ashots++;
		} else {
			System.arraycopy(shots, 1, shots, 0, shots.length - 1);
			shots[63] =  new Shot(getfacing(),this.x,this.y);
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
			eo.CollPlayer();
			facing = "left";
			while (l) {
				if (EOArrey.leftP == true) {
					waitl = true;
				} else if (waitl != true) {
					for (int i = 0; i < Camera.step; i++) {
						if (EOArrey.leftP != true) {
							Camera.addx(-1);
							Game.player.addX(1);
						}
					}
					try {
						Thread.sleep(sleep);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				waitl = false;
				try {
					Thread.sleep(sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public void MoveRight() {
			eo.CollPlayer();
			
			facing = "right";
			while (r) {
				if (EOArrey.rightP == true) {
					waitr = true;
				} else if (waitr != true) {
					for (int i = 0; i < Camera.step; i++) {
						if (EOArrey.rightP != true) {
							Camera.addx(1);
							Game.player.addX(-1);
						}
					}
					try {
						Thread.sleep(sleep);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				waitr = false;
				try {
					Thread.sleep(sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public void MoveUp() {
			eo.CollPlayer();
			facing = "up";
			while (u) {
				if (EOArrey.upP == true) {
					waitu = true;
				} else if (waitu != true) {
					for (int i = 0; i < Camera.step; i++) {
						if (EOArrey.upP != true) {
							Camera.addy(-1);
							Game.player.addY(1);
						}
					}
					try {
						Thread.sleep(sleep);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				waitu = false;
				try {
					Thread.sleep(sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public void MoveDown() {
			eo.CollPlayer();
			facing = "down";
			while (d) {
				if (EOArrey.downP == true) {
					waitd = true;
				} else if (waitd != true) {
					for (int i = 0; i < Camera.step; i++) {
						if (EOArrey.downP != true) {
							Camera.addy(1);
							Game.player.addY(-1);
						}
					}
					try {
						Thread.sleep(sleep);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				waitd = false;
				try {
					Thread.sleep(sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public void jump() {
			eo.CollPlayer();
			System.out.println("einmal");
			while (j) {
				if (count < 80) {
					eo.CollPlayer();
					cp = 0;
					count++;
					for (int i = 0; i < 5; i++) {
						if (EOArrey.upP != true) {
							Camera.addy(-1);
							Game.player.addY(1);
						}
					}
				} else {
					if (EOArrey.downP) {
						j = false;
						count = 0;
					}
				}
				try {
					Thread.sleep(sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int i = 0; i < 2; i++) {
				if (EOArrey.upP != true) {
					Camera.addy(-1);
					Game.player.addY(1);
				}
			}

		}

		@Override
		public void run() {
			//grav.Grav();
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
			case "j":
				jump();
				break;
			}
			Thread.currentThread().interrupt();
		}
	}

	private class Pgravity implements Runnable {
		int v = 1;
		int g = 1;
		int i = 0;

		private void gravity() {
			while (true) {
				if (EOArrey.downP != true) {
						for (int i = 0; i < v; i++) {
							if (EOArrey.downP != true) {
								Camera.addy(1);
								Game.player.addY(-1);
							}
						}
						i++;

						if (v < 10 && i <= 50 && cp < 5) {
							v += g;
							i = 0;
							cp++;
						}
						try {
							Thread.sleep(sleep);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					
					try {
						Thread.sleep(sleep);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//System.out.println("kaka");
			}
		}

		@Override
		public void run() {
			grav.Grav();
			
			
			//gravity();

		}
	}
}
