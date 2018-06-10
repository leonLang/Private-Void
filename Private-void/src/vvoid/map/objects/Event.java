package vvoid.map.objects;

import java.awt.Graphics;

public class Event {
	public int ID;
	public int x;
	public int y;
	public int width;
	public int height;
	public int TextureID;

	public Event(int[] data) {
		this.ID = data[1];
		this.x = data[2];
		this.y = data[3];
		this.width = data[4];
		this.height = data[5];
		this.TextureID = data[6];
	}
	public void drawEvent(Graphics g) {
		g.drawRect(this.x, this.y, this.width, this.height);
		if(true) {
			executeEvent();
		}
	}
	public void executeEvent() {
		switch(ID) {
		case 1:
			break;
		case 2:
			break;
			default:
				
		}
	}
}
