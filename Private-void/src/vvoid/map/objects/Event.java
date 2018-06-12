package vvoid.map.objects;

import java.awt.Graphics;

import vvoid.init.main.LevelCompiler;

public class Event {
	public int ID;
	public int x;
	public int y;
	public int width;
	public int height;
	public int TPID;
	public EOArrey eo;

	public Event(int[] data) {
		this.ID = data[1];
		this.x = data[2];
		this.y = data[3];
		this.width = data[4];
		this.height = data[5];
		this.TPID = data[6];
		this.eo = new EOArrey();
	}
	public void drawEvent(Graphics g) {
		g.drawRect(this.x, this.y, this.width, this.height);
		if(eo.EventColl(this.x, this.y, this.width, this.height)) {
			executeEvent();
		}
	}
	public void executeEvent() {
		switch(ID) {
		case 1:
			System.out.println("ich bin hier");
			for(int i = 0;i < LevelCompiler.Objectlenght;i++) {
				LevelCompiler.objects[i] = null;
			}
			for(int i = 0;i < LevelCompiler.EventLenght;i++) {
				LevelCompiler.event[i] = null;
				
			}
			for(int i = 0;i < LevelCompiler.EventLenght;i++) {
				LevelCompiler.event[i] = null;
				
			}
			LevelCompiler.EnemieLenght = 0;
			LevelCompiler.EventLenght = 0;
			LevelCompiler.Objectlenght = 0;
			new LevelCompiler(2);
			break;
		case 2:
			break;
			default:
				
		}
	}
}
