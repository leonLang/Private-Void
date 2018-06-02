package Metroid_Editor.edit.com;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Enemie extends JLabel implements MouseListener {

	private static final long serialVersionUID = 1L;
	public String s;
	public int IDO;
	public int ID = 1;
	public int TextureID;

	public Enemie(String text, int IDO, int TextureID) {
		this.setText(text);
		addMouseListener(this);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.s = text;
		this.IDO = IDO;
		this.TextureID = TextureID;
	}
	public void setObject() {
		String Path = "/textures/Enemies/" + s +".jpg";
		Editor.IDO = this.IDO;
		Editor.ID = TextureID;
		Editor.TextureID = TextureID;
		try {
			Editor.SelectedObject = ImageIO.read(ResourceLoader.load(Path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		Editor.clicked = true;	
		setObject();
		
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

