package Metroid_Editor.edit.com;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Rect {

	public Rectangle rectangle;
	public int x;
	public int y;
	public int width;
	public int height;
	public int IDO;
	public int ID;
	public int TextureID;
	public int R;
	public Image src;
	public int ArrayNumberx;
	public int ArrayNumberY;

	public Rect(int x, int y, int width, int height) {
		rectangle = new Rectangle(width, height, x, y);
	}

	public void draw(Graphics g, int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.R = 0;
		g.drawRect(x, y, width, height);
		rectangle = new Rectangle(width, height, x, y);
		if (src != null) {
			g.drawImage(src, x, y, width, height, null);
		}
	}

	public void setObject(Image s, int IDO, int TID, int i, int o) {
		this.src = s;
		this.IDO = IDO;
		this.TextureID = TID;
		this.ArrayNumberx = i;
		this.ArrayNumberY = o;
	}

	public boolean coll(int Mx, int My) {
		if ((Mx > x) && (Mx < x + width)) {
			if ((My > y) && (My < y + height)) {
				return true;
			}
		}
		return false;
	}

	public void collremove(int Mx, int My) {
		if ((Mx > x) && (Mx < x + width)) {
			if ((My > y) && (My < y + height)) {
				src = null;
				this.IDO = 0;
				this.ID = 0;
				this.ArrayNumberx = 0;
				this.ArrayNumberY = 0;
			}
		}

	}

}
