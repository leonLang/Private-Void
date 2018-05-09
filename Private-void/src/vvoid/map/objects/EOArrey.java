package vvoid.map.objects;

import vvoid.Void.game.Player;
import vvoid.init.main.Collision;

public class EOArrey {

	public static int[] widthO = new int[10000];// width(blocks)
	public static int[] heightO = new int[10000];// height (blocks)
	public static int[] xO = new int[10000]; // x-position (blocks)
	public static int[] yO = new int[10000]; // y-postion (blocks)
	public static int oAmount = -1; // number of blocks (-1 is for the array who starts with 0)
	public int counter, start, s1, s2;
	public int width, height, x, y; // get position and size from enemies
	public boolean up, right, down, left;
	public boolean o, r, u, l; // If the enemy stands on mmore than one block, you have to make that he uses
								// only 1 block for collisiosn or he will bug
	public int oben, rechts, unten, links;
	public Collision coll;
	public Player pl;
	

	public int richtung; // reihenfolge ist oben rechts unten links;

	public void EnemyS(int width, int height, int x, int y) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}

	public void Objekt(int width, int height, int x, int y) {
		oAmount++;
		widthO[oAmount] = width;
		heightO[oAmount] = height;
		xO[oAmount] = x;
		yO[oAmount] = y;
		System.out.println(oAmount);

	}

	public void EnemyR(int oben1) {
		System.out.println(pl.getY());
		/*
		 * Change widhtO to +3 so you can detect if enemy is right from the block in the
		 * start Change enemy width to 50 so you can detect if enemy is left from the
		 * block in the start Change heightO to +16 to detect the enemy under the block
		 */
		counter = oAmount; // for editing oAmount without change it
		o = false;
		r = false;
		u = false;
		l = false;
		while (counter >= 0) {

			// Only do this in the beginning
			if (start == 0) {
				coll = new Collision(this.x, this.y, this.width, this.height, xO[counter], yO[counter], widthO[counter],
						heightO[counter]);

				if (coll.Coll1() == 1) {
					// Check if block has collision from above
					start = 1;
				} else {
					coll = new Collision(this.x, this.y, this.width, this.height, xO[counter], yO[counter],
							widthO[counter], heightO[counter] + 16);
					if (coll.Coll1() == 1) {
						// Check if block has collision from below
						y = y - 16;
						start = 1;
					} else {
						coll = new Collision(this.x, this.y, 50, this.height, xO[counter], yO[counter], widthO[counter],
								heightO[counter]);
						if (coll.Coll1() == 1) {
							// Check if block has collision from left
							x = x + 13;
							start = 1;

						} else {
							coll = new Collision(this.x, this.y, this.width, this.height, xO[counter], yO[counter],
									widthO[counter] + 3, heightO[counter]);
							if (coll.Coll1() == 1) {

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

			if (coll.CollOben() == 1) {
				/*
				 * when it moves right there are two possibilites first: move up next:move down
				 * you can only easily detect the collision up. To see if you have to move up
				 * you have to check if the now used Collision is over and then move one pixel
				 * down
				 */
				up = true;
				oben = 0;
				if (coll.CollLinks() == 1) {
					System.out.println("why");
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

			if (coll.CollRechts() == 1) {
				/*
				 * when it moves down there are two possibilites first: move right next:move
				 * left you can only easily detect the collision right. To see if you have to
				 * move left you have to check if the now used Collision is over and then move
				 * one pixel left
				 */
				right = true;
				rechts = 0;
				if (coll.CollOben() == 1) {
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

			if (coll.CollUnten() == 1) {
				/*
				 * when it moves left there are two possibilites first: move down next:up left
				 * you can only easily detect the collision down. To see if you have to move up
				 * you have to check if the now used Collision is over and then move one pixel
				 * up
				 */
				down = true;
				unten = 0;
				if (coll.CollRechts() == 1) {
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

			if (coll.CollLinks() == 1) {
				left = true;
				links = 0;
				if (coll.CollUnten() == 1) {
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

}