package vvoid.Void.collision;

import vvoid.Void.game.Game;
import vvoid.init.main.Collision;

public class EnemieColl {

	private Collision coll;
	private int oben, rechts, unten, links;
	private int counter, start, time;
	public boolean up, right, down, left;
	private boolean direction = true;
	private boolean o, r, l; // If the enemy stands on more than one block, you have to make that he uses
								// only 1 block for collision or he will bug
	public int width, height, x, y, id; // get position and size from enemies
	public int richtung; // reihenfolge ist oben rechts unten links;
	public static int[] widthE = new int[10000];// width(blocks)
	public static int[] heightE = new int[10000];// height (blocks)
	public static int[] xE = new int[10000]; // x-position (blocks)
	public static int[] yE = new int[10000]; // y-postion (blocks)
	public static int eAmount = -1; // number of blocks (-1 is for the array who starts with 0)

	
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

	public void enemyR() {
		// System.out.println(Game.player.getY());

		/*
		 * Change widhtO to +3 so you can detect if enemy is right from the block in the
		 * start Change enemy width to 50 so you can detect if enemy is left from the
		 * block in the start Change heightO to +16 to detect the enemy under the block
		 */
		counter = ObjektColl.oAmount; // for editing oAmount without change it
		o = false;
		r = false;
		l = false;
		while (counter >= 0) {
			if (id >= 5 && id <= 14 || id >= 18 && id <= 20 || id >= 23 && id <= 25) {
				coll = new Collision(this.x, this.y, this.width, this.height, ObjektColl.xO[counter],
						ObjektColl.yO[counter], ObjektColl.widthO[counter], ObjektColl.heightO[counter]);
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
					coll = new Collision(this.x, this.y, this.width, this.height, ObjektColl.xO[counter],
							ObjektColl.yO[counter], ObjektColl.widthO[counter], ObjektColl.heightO[counter]);

					if (coll.Coll1() == true) {
						// Check if block has collision from above
						start = 1;
					} else {
						coll = new Collision(this.x, this.y, this.width, this.height, ObjektColl.xO[counter],
								ObjektColl.yO[counter], ObjektColl.widthO[counter], ObjektColl.heightO[counter] + 16);
						if (coll.Coll1() == true) {
							// Check if block has collision from below
							y = y - 16;
							start = 1;
						} else {
							coll = new Collision(this.x, this.y, 50, this.height, ObjektColl.xO[counter],
									ObjektColl.yO[counter], ObjektColl.widthO[counter], ObjektColl.heightO[counter]);
							if (coll.Coll1() == true) {
								// Check if block has collision from left
								x = x + 13;
								start = 1;

							} else {
								coll = new Collision(this.x, this.y, this.width, this.height, ObjektColl.xO[counter],
										ObjektColl.yO[counter], ObjektColl.widthO[counter] + 3,
										ObjektColl.heightO[counter]);
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

				coll = new Collision(this.x, this.y, this.width, this.height, ObjektColl.xO[counter],
						ObjektColl.yO[counter], ObjektColl.widthO[counter], ObjektColl.heightO[counter]);
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

					if (oben >= ObjektColl.oAmount * 3) {
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
					if (rechts >= ObjektColl.oAmount * 3) {
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
					if (unten >= ObjektColl.oAmount * 3) {
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
					if (links >= ObjektColl.oAmount * 3) {
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

	public void updateE(int idE, int x, int y) {
		xE[idE] = x;
		yE[idE] = y;
	}

	public void destroyE(int idE) {
		if (ShotColl.destroy < 9000) {
			if (idE == ShotColl.destroy) {
				x = 100000;
			}
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

}