package vvoid.map.objects;

public class Event {
	public int IDO;
	public int x;
	public int y;
	public int width;
	public int height;
	public int TextureID;
	public Event(int[] data) {
		this.IDO = data[1];
		this.x = data[2];
		this.y = data[3];
		this.width = data[4];
		this.height = data[5];
		this.TextureID = data[6];
	}
}
