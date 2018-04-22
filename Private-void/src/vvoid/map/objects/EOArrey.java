package vvoid.map.objects;

import vvoid.init.main.Collision;

public class EOArrey {
	public static int[] widthE = new int[10000], heightE = new int[10000], xE = new int[10000], yE = new int[10000];
	public static int[] widthO = new int[10000], heightO = new int[10000], xO = new int[10000], yO = new int[10000];
	public static int eAmount = -1, oAmount = -1;
	public static int zaehler,y1,x1;
	private Collision coll;
	private int zaehler1;
	private boolean test, testU, testO, testL,start = true;
	private boolean oben, unten, links, rechts, rL, uH, oR, lR;
	private int o1, o2, o3, r1,  test2;
	private int z7;
	public void EnemyS(int width, int height, int x, int y) {
		eAmount++;
		widthE[eAmount] = width - 2;
		heightE[eAmount] = height - 2;
		xE[eAmount] = x;
		yE[eAmount] = y;
		System.out.println(x);

	}

	public void EnemyR(int x, int y) {
		
		
		y1 = y;
		x1 = x;
		xE[zaehler] = x;
		yE[zaehler] = y;
		while (zaehler1 <= oAmount) {
			if (test2 == 0) {
				coll = new Collision(xE[zaehler], yE[zaehler], widthE[zaehler], heightE[zaehler], xO[zaehler1],
						yO[zaehler1], widthO[zaehler1], heightO[zaehler1]);

				if (coll.Coll1() == 1) {
					start = false;
				}

				if (lR == false) {
					if (coll.CollLinks() == 1) {
						test2 = 1;
						y1--;
						links = true;
						o3 = 0;
						lR = true;
						testL = true;

					} else {
						if (links == true) {
							o3++;
							// System.out.println("links");
							if (o3 >= oAmount + 1) {
								x1++;
								links = false;
							}
						}
					}
				}

				if (oR == false) {
					if (coll.CollOben() == 1) {
						test2 = 1;
						x1++;
						oben = true;
						o1 = 0;
						oR = true;
						testO = true;
					} else {
						if (oben == true) {
							o1++;
							// System.out.println("oben");
							if (o1 >= oAmount + 1) {
								y1++;
								oben = false;
							}
						}
					}
				}

				if (uH == false) {
					if (coll.CollUnten() == 1) {
						test2 = 1;
						x1--;
						unten = true;
						o2 = 0;
						uH = true;
						testU = true;
						// System.out.println("why");
					} else {
						if (unten == true) {
							o2++;
							if (o2 >= oAmount + 1) {
								y1--;
								System.out.println("unten");
								unten = false;
							}
						}
					}
				}
				if (uH == true) {
					if (coll.CollLinks() == 1) {
						test2 = 1;
						testU = false;
						System.out.println("uh");
						// x1++;
						y1++;
					}
				}
				// }
				if (rL == false) {
					if (coll.CollRechts() == 1) {
						test2 = 1;
						// System.out.println("rechts");
						y1++;
						rechts = true;
						r1 = 0;
						rL = true;
						test = true;
					} else {
						if (rechts == true) {
							r1++;
							if (r1 >= oAmount + 1) {
								x1--;
								// System.out.println("no");
								rechts = false;
							}

						}

					}

				}
				if (rL == true) {

					// System.out.println("joa");
					if (coll.CollOben() == 1) {
						test2 = 1;
						test = false;
						// System.out.println("unten12");
						y1 = y1 - 1;
						x1 = x1 + 1;
					}
				}

			}
			zaehler1++;
		}
		test2 = 0;
		if (test == true) {
			test = false;
		} else {
			rL = false;
		}
		if (testL == true) {
			testL = false;
		} else {
			lR = false;
		}
		if (testU == true) {
			testU = false;
		} else {
			uH = false;
		}
		if (testO == true) {
			testO = false;
		} else {
			oR = false;
		}

		if (start == true) {
			y1++;
		}

		zaehler1 = 0;
		if (zaehler >= eAmount - 1) {
			zaehler = 0;
		} else {
			zaehler++;
		}
		// zaehler1 = zA1;
		// Collision();

	}

	public void Objekt(int width, int height, int x, int y) {
		oAmount++;
		widthO[oAmount] = width;
		heightO[oAmount] = height;
		xO[oAmount] = x;
		yO[oAmount] = y;

	}

}
