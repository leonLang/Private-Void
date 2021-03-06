//Peter
package vvoid.Void.game;

import java.awt.Graphics;

import vvoid.Void.collision.PlayerColl;
import vvoid.init.main.Camera;
import vvoid.init.main.LevelCompiler;

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
	int test = 0, test1;
	public Gravity grav = new Gravity();
	public PlayerColl pC = new PlayerColl();
	public Thread gt;
	private int test2, anim, anim1, time, time1;

	public Player(int x, int y, int width, int height, String facing) {
		this.x = x;
		this.y = y;
		this.XSolid = x;// Game.WIDTH/2;
		this.YSolid = y;// Game.HEIGHT/2;
		this.width = width;
		this.height = height;
		this.facing = facing;
		this.sleep = 1;
		this.count = 0;
		this.count = 0;
		this.cp = 0;

		setX(LevelCompiler.PX);
		setY(LevelCompiler.PY);

		this.l = false;
		this.r = false;
		this.j = false;

		ashots = 0;
		this.shots = new Shot[64];

		this.gt = new Thread(new Gravity());
		this.gt.start();

	}

	public void drawPlayer(Graphics g) {
		//diese einzelne Methode ist von Leon
		// System.out.println(x);
		if (test2 == 1) {
			g.drawImage(Game.sheet.dP.sam[9], this.XSolid, this.YSolid, this.width, this.height, null);
		} else if (test2 == 2) {
			g.drawImage(Game.sheet.dP.sam[10], this.XSolid, this.YSolid, this.width, this.height, null);
		} else if (test2 == 3) {
			if (anim <= 10) {
				g.drawImage(Game.sheet.dP.sam[4], this.XSolid, this.YSolid, this.width, this.height, null);
				anim++;
			} else if (anim <= 20) {
				g.drawImage(Game.sheet.dP.sam[5], this.XSolid, this.YSolid, this.width, this.height, null);
				anim++;
			} else if (anim <= 30) {
				time++;
				g.drawImage(Game.sheet.dP.sam[6], this.XSolid, this.YSolid, this.width, this.height, null);
				if (time >= 10) {
					anim = 0;
					time = 0;
				}
			}

		} else if (test2 == 4) {
			if (anim1 <= 10) {
				g.drawImage(Game.sheet.dP.sam[0], this.XSolid, this.YSolid, this.width, this.height, null);
				anim1++;
			} else if (anim1 <= 20) {
				g.drawImage(Game.sheet.dP.sam[1], this.XSolid, this.YSolid, this.width, this.height, null);
				anim1++;
			} else if (anim1 <= 30) {
				g.drawImage(Game.sheet.dP.sam[2], this.XSolid, this.YSolid, this.width, this.height, null);
				anim1++;
			} else if (anim1 <= 40) {
				time1++;
				g.drawImage(Game.sheet.dP.sam[3], this.XSolid, this.YSolid, this.width, this.height, null);
				if (time1 >= 10) {
					anim1 = 0;
					time1 = 0;
				}
			}
		} else {
			g.drawImage(Game.sheet.dP.sam[4], this.XSolid, this.YSolid, this.width, this.height, null);
		}
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
			shots[ashots] = shots[Player.ashots] = new Shot(getfacing(), this.x, this.y);
			ashots++;
		} else {
			System.arraycopy(shots, 1, shots, 0, shots.length - 1);
			shots[63] = new Shot(getfacing(), this.x, this.y);
		}
	}

	public void addX(int i) {
		this.x -= i;
	}

	public void addY(int i) {
		this.y -= i;
	}

	public void setX(int c) {
		System.out.println(c);
		if (c < 0) {
			for (int i = 0; i < Math.abs(c); i++) {
				Camera.addx(-1);
				addX(1);
			}
		} else {
			for (int i = 0; i < Math.abs(c); i++) {
				Camera.addx(1);
				addX(-1);
			}
		}
	}

	public void setY(int c) {
		System.out.println(c);
		if (c < 0) {
			for (int i = 0; i < Math.abs(c); i++) {
				Camera.addy(-1);
				addY(1);
			}
		} else {
			for (int i = 0; i < Math.abs(c); i++) {
				Camera.addx(1);
				addX(-1);
			}
		}

	}

	private class movment implements Runnable {
		private String c;

		public movment(String c) {
			this.c = c;
		}

		public void MoveLeft() {
			test2 = 4;
			pC.collPlayer();
			facing = "left";
			while (l) {
				if (PlayerColl.leftP == true) {
					waitl = true;
				} else if (waitl != true) {
					for (int i = 0; i < Camera.step; i++) {
						if (PlayerColl.leftP != true) {
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
			test2 = 3;
			pC.collPlayer();

			facing = "right";
			while (r) {
				if (PlayerColl.rightP == true) {
					waitr = true;
				} else if (waitr != true) {
					for (int i = 0; i < Camera.step; i++) {
						if (PlayerColl.rightP != true) {
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
			test2 = 1;
			pC.collPlayer();
			facing = "up";
			while (u) {
				if (PlayerColl.upP == true) {
					waitu = true;
				} else if (waitu != true) {
					for (int i = 0; i < Camera.step; i++) {
						if (PlayerColl.upP != true) {
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
			test2 = 2;
			pC.collPlayer();
			facing = "down";
			while (d) {
				if (PlayerColl.downP == true) {
					waitd = true;
				} else if (waitd != true) {
					for (int i = 0; i < Camera.step; i++) {
						if (PlayerColl.downP != true) {
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
			pC.collPlayer();
			while (j) {
				if (count < 80) {
					pC.collPlayer();
					cp = 0;
					count++;
					for (int i = 0; i < 5; i++) {
						pC.collPlayer();
						if (PlayerColl.upP != true) {
							Camera.addy(-1);
							Game.player.addY(1);
						}
					}
				} else {
					if (PlayerColl.downP) {
						j = false;
						count = 0;
					}
				}
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int i = 0; i < 2; i++) {
				if (PlayerColl.upP != true) {
					Camera.addy(-1);
					Game.player.addY(1);
				}
			}
			count = 0;
		}

		@Override
		public void run() {
			// grav.Grav();
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
}
