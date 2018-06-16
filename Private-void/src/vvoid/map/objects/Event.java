//Peter
package vvoid.map.objects;

import java.awt.Graphics;

import vvoid.Void.collision.EventColl;
import vvoid.Void.game.Game;
import vvoid.init.main.LevelCompiler;

public class Event {
	public int ID;
	public int x;
	public int y;
	public int width;
	public int height;
	public int TPID;
	public EventColl eC;

	public Event(int[] data) {
		this.ID = data[1];
		this.x = data[2];
		this.y = data[3];
		this.width = data[4];
		this.height = data[5];
		this.TPID = data[7];
		this.eC = new EventColl(width,height,x,y);
	}
	public void drawEvent(Graphics g) {
		g.drawRect(this.x, this.y, this.width, this.height);
		eC = new EventColl(width,height,x,y);
		if(eC.eventColl()) {
			executeEvent();
		}
		
	}
	public void executeEvent() {
		switch(ID) {
		case 1:
			for(int i = 0;i < LevelCompiler.Objectlenght;i++) {
				LevelCompiler.objects[i] = null;
			}
			for(int i = 0;i < LevelCompiler.EventLenght;i++) {
				LevelCompiler.event[i] = null;
				
			}
			for(int i = 0;i < LevelCompiler.EventLenght;i++) {
				LevelCompiler.event[i] = null;
				
			}
			Game.player.j = false;
			Game.player.r = false;
			LevelCompiler.EnemieLenght = 0;
			LevelCompiler.EventLenght = 0;
			LevelCompiler.Objectlenght = 0;
			new LevelCompiler(TPID);
			break;
		case 2:
			break;
			default:
				
		}
	}
}
