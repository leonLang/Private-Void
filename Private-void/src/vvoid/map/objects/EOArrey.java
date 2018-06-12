package vvoid.map.objects;

import vvoid.Void.game.Game;
import vvoid.Void.game.Player;
import vvoid.init.main.Collision;

public class EOArrey {

	public static int[] widthO = new int[10000];// width(blocks)
	public static int[] heightO = new int[10000];// height (blocks)
	public static int[] xO = new int[10000]; // x-position (blocks)
	public static int[] yO = new int[10000]; // y-postion (blocks)
	public static int[] widthE = new int[10000];// width(blocks)
	public static int[] heightE = new int[10000];// height (blocks)
	public static int[] xE = new int[10000]; // x-position (blocks)
	public static int[] yE = new int[10000]; // y-postion (blocks)
	public static int oAmount = -1, eAmount = -1; // number of blocks (-1 is for the array who starts with 0)
	private int counter, counterP, counterE, start;
	public int width, height, x, y, id; // get position and size from enemies
	public boolean up, right, down, left;
	private int time;
	private boolean direction = true;
	private boolean o, r, l; // If the enemy stands on mmore than one block, you have to make that he uses
								// only 1 block for collisiosn or he will bug
	public int oben, rechts, unten, links, test;
	public boolean shutdown;
	public static boolean leftP, rightP, downP, upP;
	public int linksP, rechtsP, untenP, obenP;
	public Collision coll;
	public Player pl;
	public static int destroy = 10000;

	public int richtung; // reihenfolge ist oben rechts unten links;

	public void enemyS(int width, int height, int x, int y, int id) {
		eAmount++;
		widthE[eAmount] = width;
		heightE[eAmount] = height;
		xE[eAmount] = x;
		yE[eAmount] = y;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.id = id;
	}

	public void updateE(int idE, int x, int y) {
		xE[idE] = x;
		yE[idE] = y;
	}

	public boolean shotColl(int x, int y, int width, int height) {
		counterE = eAmount;
		while (counterE >= 0) {
			coll = new Collision(x, y, width, height, xE[counterE], yE[counterE], widthE[counterE], heightE[counterE]);
			if (coll.Coll1() == true) {
				destroy = counterE;
				System.out.println(counterE);
				shutdown = true;
				counterE = -1;

			}
			counterE--;
		}
		if (shutdown == true) {
			return true;
		} else {
			return false;
		}
	}

	public void destroyE(int idE) {
		if (destroy < 9000) {
			if (idE == destroy) {
				x = 100000;
			}
		}
	}

	public void objekt(int width, int height, int x, int y) {
		oAmount++;
		widthO[oAmount] = width;
		heightO[oAmount] = height;
		xO[oAmount] = x;
		yO[oAmount] = y;

	}

	public void enemyR() {
		// System.out.println(Game.player.getY());

		/*
		 * Change widhtO to +3 so you can detect if enemy is right from the block in the
		 * start Change enemy width to 50 so you can detect if enemy is left from the
		 * block in the start Change heightO to +16 to detect the enemy under the block
		 */
		counter = oAmount; // for editing oAmount without change it
		o = false;
		r = false;
		l = false;
		while (counter >= 0) {
			if (id >= 5 && id <= 14 || id >= 18 && id <= 20 || id >= 23 && id <= 25) {
				coll = new Collision(this.x, this.y, this.width, this.height, xO[counter], yO[counter], widthO[counter],
						heightO[counter]);
				if (coll.CollRechts() == true) {
					direction = false;
					counter = -1;
				}
				if (coll.CollLinks() == true) {
					direction = true;
					counter = -1;
				}
				counter--;
			} else {
				// Only do this in the beginning
				if (start == 0) {
					coll = new Collision(this.x, this.y, this.width, this.height, xO[counter], yO[counter],
							widthO[counter], heightO[counter]);

					if (coll.Coll1() == true) {
						// Check if block has collision from above
						start = 1;
					} else {
						coll = new Collision(this.x, this.y, this.width, this.height, xO[counter], yO[counter],
								widthO[counter], heightO[counter] + 16);
						if (coll.Coll1() == true) {
							// Check if block has collision from below
							y = y - 16;
							start = 1;
						} else {
							coll = new Collision(this.x, this.y, 50, this.height, xO[counter], yO[counter],
									widthO[counter], heightO[counter]);
							if (coll.Coll1() == true) {
								// Check if block has collision from left
								x = x + 13;
								start = 1;

							} else {
								coll = new Collision(this.x, this.y, this.width, this.height, xO[counter], yO[counter],
										widthO[counter] + 3, heightO[counter]);
								if (coll.Coll1() == true) {

									x = x - 3;
									start = 1;
									// Check if block has collision from right
								} else {
									// y++;
									// if it has no Collision move 1pixel below
								}
							}
						}
					}
				}

				coll = new Collision(this.x, this.y, this.width, this.height, xO[counter], yO[counter], widthO[counter],
						heightO[counter]);
				counter--;

				if (coll.CollOben() == true) {
					/*
					 * when it moves right there are two possibilites first: move up next:move down
					 * you can only easily detect the collision up. To see if you have to move up
					 * you have to check if the now used Collision is over and then move one pixel
					 * down
					 */
					up = true;
					oben = 0;
					if (coll.CollLinks() == true) {
						y--;
						up = false;
						x = x - 2;
						oben = 0;
						// Only to check if if it goes up
					} else {
						if (o == false) {
							o = true;
							richtung = 0;
							x++;
						}
					}
					// the code checks, that he only moves down if the collision is over
				} else {
					oben++;
				}
				if (up == true) {

					if (oben >= oAmount * 3) {
						y = y + 1;
						up = false;
					}
				}

				if (coll.CollRechts() == true) {
					/*
					 * when it moves down there are two possibilites first: move right next:move
					 * left you can only easily detect the collision right. To see if you have to
					 * move left you have to check if the now used Collision is over and then move
					 * one pixel left
					 */
					right = true;
					rechts = 0;
					if (coll.CollOben() == true) {
						x++;
						y--;
						right = false;
						rechts = 0;
					} else {
						if (r == false) {
							richtung = 1;
							r = true;
							y++;
						}
					}

				} else {
					rechts++;
				}
				if (right == true) {
					if (rechts >= oAmount * 3) {
						x--;
						right = false;
					}
				}

				if (coll.CollUnten() == true) {
					/*
					 * when it moves left there are two possibilites first: move down next:up left
					 * you can only easily detect the collision down. To see if you have to move up
					 * you have to check if the now used Collision is over and then move one pixel
					 * up
					 */
					down = true;
					unten = 0;
					if (coll.CollRechts() == true) {
						y++;
						x++;
						down = false;
						unten = 0;
					} else {
						if (o == false) {
							o = true;
							richtung = 2;
							x--;
						}
					}

				} else {
					unten++;
				}
				if (down == true) {
					if (unten >= oAmount * 3) {
						y--;
						down = false;
					}
				}

				if (coll.CollLinks() == true) {
					left = true;
					links = 0;
					if (coll.CollUnten() == true) {
						links = 0;
						left = false;
						x--;
						y++;
					} else {
						if (l == false) {
							l = true;
							y--;
							richtung = 3;
						}
					}
				} else {
					links++;
				}
				if (left == true) {
					if (links >= oAmount * 3) {
						x++;
						left = false;
					}
				}
			}
		}
		if (id >= 5 && id <= 14 || id >= 18 && id <= 20 || id >= 23 && id <= 25) {
			if (direction != true) {
				x++;
			} else {
				x--;
			}
			counter = -1;
		}
	}

	public void tBack() {
		if (time <= 0) {

		} else {
			time--;
		}
	}

	public void eVSPl() {
		if (time <= 0) {
			coll = new Collision(Game.player.x, Game.player.y, Game.player.width, Game.player.height, x, y, width,
					height);
			if (coll.Coll1() == true) {
				Game.leben--;
				time = 120;
			}
		}
	}

	public void collPlayer() {
		counterP = oAmount; // for editing oAmount without change it
		while (counterP >= 0) {
			coll = new Collision(Game.player.x, Game.player.y, Game.player.width, Game.player.height, xO[counterP],
					yO[counterP], widthO[counterP], heightO[counterP]);
			if (coll.CollLinksP() == true) {
				counterP = 0;
				linksP = 1;
			} else {
				linksP = 0;
			}
			counterP--;
		}
		counterP = oAmount; // for editing oAmount without change it
		while (counterP >= 0) {
			coll = new Collision(Game.player.x, Game.player.y, Game.player.width, Game.player.height, xO[counterP],
					yO[counterP], widthO[counterP], heightO[counterP]);
			if (coll.CollObenP() == true) {
				counterP = 0;
				obenP = 1;
			} else {
				obenP = 0;
			}
			counterP--;
		}
		counterP = oAmount; // for editing oAmount without change it
		while (counterP >= 0) {
			coll = new Collision(Game.player.x, Game.player.y, Game.player.width, Game.player.height, xO[counterP],
					yO[counterP], widthO[counterP], heightO[counterP]);
			if (coll.CollRechtsP() == true) {
				counterP = 0;
				rechtsP = 1;
			} else {
				rechtsP = 0;
			}
			counterP--;
		}
		counterP = oAmount; // for editing oAmount without change it
		while (counterP >= 0) {
			coll = new Collision(Game.player.x, Game.player.y, Game.player.width, Game.player.height, xO[counterP],
					yO[counterP], widthO[counterP], heightO[counterP]);
			if (coll.CollUntenP() == true) {
				counterP = 0;
				untenP = 1;
			} else {
				untenP = 0;
			}
			counterP--;
		}

		if (linksP == 1) {
			leftP = true;
		} else {
			leftP = false;
		}
		if (rechtsP == 1) {
			rightP = true;
		} else {
			rightP = false;
		}
		if (untenP == 1) {
			downP = true;
		} else {
			downP = false;
		}
		if (obenP == 1) {
			upP = true;
		} else {
			upP = false;
		}
	}

	public boolean eventColl(int x, int y, int width, int height) {
		coll = new Collision(Game.player.x, Game.player.y, Game.player.width, Game.player.height, x, y, width, height);
		if (coll.Coll1() == true) {
			return true;
		} else {
			return false;
		}

	}

}