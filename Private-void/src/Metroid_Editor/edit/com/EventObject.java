package Metroid_Editor.edit.com;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class EventObject extends JLabel implements MouseListener{

	private static final long serialVersionUID = 1L;
	public String s;
	public int IDO;
	public int ID = 1;
	public int TextureID = 0;

	public EventObject(String text, int IDO, int ID) {
		this.setText(text);
		addMouseListener(this);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.s = text;
		this.IDO = IDO;
		this.ID = ID;
		
	}
	public void setObject() {
		Editor.IDO = this.IDO;
		Editor.ID = ID;
		try {
			Editor.SelectedObject = ImageIO.read(ResourceLoader.load("/textures/Objects/Event.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Editor.clicked = true;	
		setObject();
		Editor.LID = this.TextureID;
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
