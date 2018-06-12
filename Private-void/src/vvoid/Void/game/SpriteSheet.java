package vvoid.Void.game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private BufferedImage metroid, br_grass, br_recolor, br;
	public BufferedImage a1, a2, a3, a4, a5, a6, a7, a8, b1, b2, b3, b4, b5, b6, b7, b8, c1, c2, c3, c4, c5, c6, c7, c8,
			d1, d2, d3, d4, d5, d6, d7, d8;
	public BufferedImage e, f, g1, h, i, j1, j2, k1, k2, l1, l2, m1, m2, n1, n2;
	public BufferedImage o1, o2, o3, o4, o5, o6, o7, o8, p1, p2, p3, p4, p5, p6, p7, p8, q1, q2, q3, q4, q5, q6, q7, q8;
	public BufferedImage r1, r2, s1, s2, t1, t2;
	public BufferedImage u1, u2, u3, u4, u5, u6, u7, u8, v1, v2, v3, v4, v5, v6, v7, v8;
	public BufferedImage w1, w2, z, zz;
	public BufferedImage[] brD = new BufferedImage[100], brG = new BufferedImage[100], brR = new BufferedImage[100];
	private int x, y;

	public SpriteSheet() {
		try {
			metroid = ImageIO.read(getClass().getResourceAsStream("textures/metroid.png"));
			// br_column =
			// ImageIO.read(getClass().getResourceAsStream("textures/br_column.png"));
			br_grass = ImageIO.read(getClass().getResourceAsStream("textures/br_grass.png"));
			// br_grass1 =
			// ImageIO.read(getClass().getResourceAsStream("textures/br_grass1.png"));
			br_recolor = ImageIO.read(getClass().getResourceAsStream("textures/br_recolor.png"));
			br = ImageIO.read(getClass().getResourceAsStream("textures/br.png"));
			// character =
			// ImageIO.read(getClass().getResourceAsStream("textures/character.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 20; i++) {
			brD[i] = brdefault(x, y, 50, 50);
			brG[i] = grass(x, y, 50, 50);
			brR[i] = recolor(x, y, 50, 50);
			if (x == 200) {
				x = 0;
				y = y + 50;
			} else {
				x = x + 50;
			}

		}
		a1 = crop(9, 7, 15, 14);
		a2 = crop(27, 7, 16, 14);
		a3 = crop(45, 7, 16, 14);
		a4 = crop(60, 7, 16, 14);
		a5 = crop(75, 7, 16, 14);
		a6 = crop(93, 7, 16, 14);
		a7 = crop(111, 7, 16, 14);
		a8 = crop(128, 7, 16, 14);
		b1 = crop(145, 7, 15, 14);
		b2 = crop(163, 7, 16, 14);
		b3 = crop(181, 7, 16, 14);
		b4 = crop(196, 7, 16, 14);
		b5 = crop(211, 7, 16, 14);
		b6 = crop(229, 7, 16, 14);
		b7 = crop(247, 7, 16, 14);
		b8 = crop(264, 7, 16, 14);
		c1 = crop(281, 7, 16, 14);
		c2 = crop(299, 7, 16, 14);
		c3 = crop(317, 7, 16, 14);
		c4 = crop(332, 7, 16, 14);
		c5 = crop(347, 7, 16, 14);
		c6 = crop(365, 7, 16, 14);
		c7 = crop(383, 7, 16, 14);
		c8 = crop(400, 7, 16, 14);
		d1 = crop(417, 7, 16, 14);
		d2 = crop(435, 7, 16, 14);
		d3 = crop(453, 7, 16, 14);
		d4 = crop(468, 7, 16, 14);
		d5 = crop(483, 7, 16, 14);
		d6 = crop(501, 7, 16, 14);
		d7 = crop(519, 7, 16, 14);
		d8 = crop(536, 7, 16, 14);
		e = crop(13, 25, 18, 28);
		f = crop(53, 25, 18, 28);
		g1 = crop(91, 25, 18, 28);
		h = crop(128, 25, 18, 28);
		i = crop(166, 25, 18, 28);
		j1 = crop(212, 28, 25, 23);
		j2 = crop(238, 28, 25, 23);
		k1 = crop(264, 28, 25, 23);
		k2 = crop(290, 28, 25, 23);
		l1 = crop(316, 28, 25, 23);
		l2 = crop(342, 28, 25, 23);
		m1 = crop(368, 28, 25, 23);
		m2 = crop(394, 28, 25, 23);
		n1 = crop(508, 40, 23, 15);
		n2 = crop(527, 40, 23, 15);
		o1 = crop(31, 86, 15, 13);
		o2 = crop(49, 86, 15, 13);
		o3 = crop(68, 86, 13, 13);
		o4 = crop(86, 86, 13, 13);
		o5 = crop(103, 87, 15, 13);
		o6 = crop(121, 87, 15, 13);
		o7 = crop(139, 86, 13, 13);
		o8 = crop(157, 86, 13, 13);
		p1 = crop(175, 86, 15, 13);
		p2 = crop(193, 86, 15, 13);
		p3 = crop(212, 86, 13, 13);
		p4 = crop(230, 86, 13, 13);
		p5 = crop(246, 87, 15, 13);
		p6 = crop(265, 87, 15, 13);
		p7 = crop(285, 86, 13, 13);
		p8 = crop(303, 86, 13, 13);
		q1 = crop(319, 86, 15, 13);
		q2 = crop(337, 86, 15, 13);
		q3 = crop(357, 86, 13, 13);
		q4 = crop(375, 86, 13, 13);
		q5 = crop(392, 87, 15, 13);
		q6 = crop(410, 87, 15, 13);
		q7 = crop(429, 86, 13, 13);
		q8 = crop(447, 86, 13, 13);
		r1 = crop(237, 112, 26, 24);
		r2 = crop(263, 108, 26, 25);
		s1 = crop(341, 112, 26, 24);
		s2 = crop(367, 108, 26, 25);
		t1 = crop(445, 112, 26, 24);
		t2 = crop(471, 108, 26, 25);
		u1 = crop(0, 0, 1, 1);
		u2 = crop(0, 0, 1, 1);
		u3 = crop(0, 0, 1, 1);
		u4 = crop(0, 0, 1, 1);
		u5 = crop(0, 0, 1, 1);
		u6 = crop(0, 0, 1, 1);
		u7 = crop(0, 0, 1, 1);
		u8 = crop(0, 0, 1, 1);
		v1 = crop(0, 0, 1, 1);
		v2 = crop(0, 0, 1, 1);
		v3 = crop(0, 0, 1, 1);
		v4 = crop(0, 0, 1, 1);
		v5 = crop(0, 0, 1, 1);
		v6 = crop(0, 0, 1, 1);
		v7 = crop(0, 0, 1, 1);
		v8 = crop(0, 0, 1, 1);
		w1 = crop(168, 152, 15, 40);
		w2 = crop(168, 152, 15, 40);
		z = crop(200, 152, 15, 40);
		zz = crop(230, 152, 15, 40);
		a1 = crop(9, 7, 15, 14);
		a2 = crop(27, 7, 16, 14);
		a3 = crop(45, 7, 16, 14);
		a4 = crop(60, 7, 16, 14);
		a5 = crop(75, 7, 16, 14);
		a6 = crop(93, 7, 16, 14);
		a7 = crop(111, 7, 16, 14);
		a8 = crop(128, 7, 16, 14);
		b1 = crop(145, 7, 15, 14);
		b2 = crop(163, 7, 16, 14);
		b3 = crop(181, 7, 16, 14);
		b4 = crop(196, 7, 16, 14);
		b5 = crop(211, 7, 16, 14);
		b6 = crop(229, 7, 16, 14);
		b7 = crop(247, 7, 16, 14);
		b8 = crop(264, 7, 16, 14);
		c1 = crop(281, 7, 16, 14);
		c2 = crop(299, 7, 16, 14);
		c3 = crop(317, 7, 16, 14);
		c4 = crop(332, 7, 16, 14);
		c5 = crop(347, 7, 16, 14);
		c6 = crop(365, 7, 16, 14);
		c7 = crop(383, 7, 16, 14);
		c8 = crop(400, 7, 16, 14);
		d1 = crop(417, 7, 16, 14);
		d2 = crop(435, 7, 16, 14);
		d3 = crop(453, 7, 16, 14);
		d4 = crop(468, 7, 16, 14);
		d5 = crop(483, 7, 16, 14);
		d6 = crop(501, 7, 16, 14);
		d7 = crop(519, 7, 16, 14);
		d8 = crop(536, 7, 16, 14);
		e = crop(13, 25, 18, 28);
		f = crop(53, 25, 18, 28);
		g1 = crop(91, 25, 18, 28);
		h = crop(128, 25, 18, 28);
		i = crop(166, 25, 18, 28);
		j1 = crop(212, 28, 25, 23);
		j2 = crop(238, 28, 25, 23);
		k1 = crop(264, 28, 25, 23);
		k2 = crop(290, 28, 25, 23);
		l1 = crop(316, 28, 25, 23);
		l2 = crop(342, 28, 25, 23);
		m1 = crop(368, 28, 25, 23);
		m2 = crop(394, 28, 25, 23);
		n1 = crop(508, 40, 23, 15);
		n2 = crop(527, 40, 23, 15);
		o1 = crop(31, 86, 15, 13);
		o2 = crop(49, 86, 15, 13);
		o3 = crop(68, 86, 13, 13);
		o4 = crop(86, 86, 13, 13);
		o5 = crop(103, 87, 15, 13);
		o6 = crop(121, 87, 15, 13);
		o7 = crop(139, 86, 13, 13);
		o8 = crop(157, 86, 13, 13);
		p1 = crop(175, 86, 15, 13);
		p2 = crop(193, 86, 15, 13);
		p3 = crop(212, 86, 13, 13);
		p4 = crop(230, 86, 13, 13);
		p5 = crop(246, 87, 15, 13);
		p6 = crop(265, 87, 15, 13);
		p7 = crop(285, 86, 13, 13);
		p8 = crop(303, 86, 13, 13);
		q1 = crop(319, 86, 15, 13);
		q2 = crop(337, 86, 15, 13);
		q3 = crop(357, 86, 13, 13);
		q4 = crop(375, 86, 13, 13);
		q5 = crop(392, 87, 15, 13);
		q6 = crop(410, 87, 15, 13);
		q7 = crop(429, 86, 13, 13);
		q8 = crop(447, 86, 13, 13);
		r1 = crop(237, 112, 26, 24);
		r2 = crop(263, 108, 26, 25);
		s1 = crop(341, 112, 26, 24);
		s2 = crop(367, 108, 26, 25);
		t1 = crop(445, 112, 26, 24);
		t2 = crop(471, 108, 26, 25);
		u1 = crop(0, 0, 1, 1);
		u2 = crop(0, 0, 1, 1);
		u3 = crop(0, 0, 1, 1);
		u4 = crop(0, 0, 1, 1);
		u5 = crop(0, 0, 1, 1);
		u6 = crop(0, 0, 1, 1);
		u7 = crop(0, 0, 1, 1);
		u8 = crop(0, 0, 1, 1);
		v1 = crop(0, 0, 1, 1);
		v2 = crop(0, 0, 1, 1);
		v3 = crop(0, 0, 1, 1);
		v4 = crop(0, 0, 1, 1);
		v5 = crop(0, 0, 1, 1);
		v6 = crop(0, 0, 1, 1);
		v7 = crop(0, 0, 1, 1);
		v8 = crop(0, 0, 1, 1);
		w1 = crop(168, 152, 15, 40);
		w2 = crop(168, 152, 15, 40);
		z = crop(200, 152, 15, 40);
		zz = crop(230, 152, 15, 40);
		a1 = crop(9, 7, 15, 14);
		a2 = crop(27, 7, 16, 14);
		a3 = crop(45, 7, 16, 14);
		a4 = crop(60, 7, 16, 14);
		a5 = crop(75, 7, 16, 14);
		a6 = crop(93, 7, 16, 14);
		a7 = crop(111, 7, 16, 14);
		a8 = crop(128, 7, 16, 14);
		b1 = crop(145, 7, 15, 14);
		b2 = crop(163, 7, 16, 14);
		b3 = crop(181, 7, 16, 14);
		b4 = crop(196, 7, 16, 14);
		b5 = crop(211, 7, 16, 14);
		b6 = crop(229, 7, 16, 14);
		b7 = crop(247, 7, 16, 14);
		b8 = crop(264, 7, 16, 14);
		c1 = crop(281, 7, 16, 14);
		c2 = crop(299, 7, 16, 14);
		c3 = crop(317, 7, 16, 14);
		c4 = crop(332, 7, 16, 14);
		c5 = crop(347, 7, 16, 14);
		c6 = crop(365, 7, 16, 14);
		c7 = crop(383, 7, 16, 14);
		c8 = crop(400, 7, 16, 14);
		d1 = crop(417, 7, 16, 14);
		d2 = crop(435, 7, 16, 14);
		d3 = crop(453, 7, 16, 14);
		d4 = crop(468, 7, 16, 14);
		d5 = crop(483, 7, 16, 14);
		d6 = crop(501, 7, 16, 14);
		d7 = crop(519, 7, 16, 14);
		d8 = crop(536, 7, 16, 14);
		e = crop(13, 25, 18, 28);
		f = crop(53, 25, 18, 28);
		g1 = crop(91, 25, 18, 28);
		h = crop(128, 25, 18, 28);
		i = crop(166, 25, 18, 28);
		j1 = crop(212, 28, 25, 23);
		j2 = crop(238, 28, 25, 23);
		k1 = crop(264, 28, 25, 23);
		k2 = crop(290, 28, 25, 23);
		l1 = crop(316, 28, 25, 23);
		l2 = crop(342, 28, 25, 23);
		m1 = crop(368, 28, 25, 23);
		m2 = crop(394, 28, 25, 23);
		n1 = crop(508, 40, 23, 15);
		n2 = crop(527, 40, 23, 15);
		o1 = crop(31, 86, 15, 13);
		o2 = crop(49, 86, 15, 13);
		o3 = crop(68, 86, 13, 13);
		o4 = crop(86, 86, 13, 13);
		o5 = crop(103, 87, 15, 13);
		o6 = crop(121, 87, 15, 13);
		o7 = crop(139, 86, 13, 13);
		o8 = crop(157, 86, 13, 13);
		p1 = crop(175, 86, 15, 13);
		p2 = crop(193, 86, 15, 13);
		p3 = crop(212, 86, 13, 13);
		p4 = crop(230, 86, 13, 13);
		p5 = crop(246, 87, 15, 13);
		p6 = crop(265, 87, 15, 13);
		p7 = crop(285, 86, 13, 13);
		p8 = crop(303, 86, 13, 13);
		q1 = crop(319, 86, 15, 13);
		q2 = crop(337, 86, 15, 13);
		q3 = crop(357, 86, 13, 13);
		q4 = crop(375, 86, 13, 13);
		q5 = crop(392, 87, 15, 13);
		q6 = crop(410, 87, 15, 13);
		q7 = crop(429, 86, 13, 13);
		q8 = crop(447, 86, 13, 13);
		r1 = crop(237, 112, 26, 24);
		r2 = crop(263, 108, 26, 25);
		s1 = crop(341, 112, 26, 24);
		s2 = crop(367, 108, 26, 25);
		t1 = crop(445, 112, 26, 24);
		t2 = crop(471, 108, 26, 25);
		u1 = crop(0, 0, 1, 1);
		u2 = crop(0, 0, 1, 1);
		u3 = crop(0, 0, 1, 1);
		u4 = crop(0, 0, 1, 1);
		u5 = crop(0, 0, 1, 1);
		u6 = crop(0, 0, 1, 1);
		u7 = crop(0, 0, 1, 1);
		u8 = crop(0, 0, 1, 1);
		v1 = crop(0, 0, 1, 1);
		v2 = crop(0, 0, 1, 1);
		v3 = crop(0, 0, 1, 1);
		v4 = crop(0, 0, 1, 1);
		v5 = crop(0, 0, 1, 1);
		v6 = crop(0, 0, 1, 1);
		v7 = crop(0, 0, 1, 1);
		v8 = crop(0, 0, 1, 1);
		w1 = crop(168, 152, 15, 40);
		w2 = crop(168, 152, 15, 40);
		z = crop(200, 152, 15, 40);
		zz = crop(230, 152, 15, 40);
	}

	private BufferedImage crop(int x, int y, int width, int height) {
		return metroid.getSubimage(x, y, width, height);
	}

	private BufferedImage grass(int x, int y, int width, int height) {
		return br_grass.getSubimage(x, y, width, height);
	}

	private BufferedImage recolor(int x, int y, int width, int height) {
		return br_recolor.getSubimage(x, y, width, height);
	}

	private BufferedImage brdefault(int x, int y, int width, int height) {
		return br.getSubimage(x, y, width, height);
	}

	/*
	 * private BufferedImage chare(int x, int y, int width, int height) { return
	 * character.getSubimage(x, y, width, height); }
	 */

}
