package Metroid_Editor.edit.com;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

import vvoid.Void.game.Game;

public class ObjectSolid extends JLabel implements MouseListener{

	private static final long serialVersionUID = 1L;
	public String s;
	public int IDO;
	public int ID = 1;
	public int TextureID;

	public ObjectSolid(String text, int IDO, int TextureID) {
		this.setText(text);
		addMouseListener(this);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.s = text;
		this.IDO = IDO;
		this.TextureID = TextureID;
	}
	public void setObject() {
		String Path = "/textures/Objects/" + s +".jpg";
		Editor.IDO = this.IDO;
		Editor.ID = ID;
		Editor.TextureID = TextureID;
		for (int i = 1; i < 61; i++) {
			if(Editor.TextureID == i) {
				if(Editor.TextureID <= 20) {
					Editor.SelectedObject = Main.sheet.brD[i];
				}
					else if (Editor.TextureID <= 40) {
						Editor.SelectedObject = Main.sheet.brG[i-20];
					}
					else if (Editor.TextureID <= 60) {
						Editor.SelectedObject = Main.sheet.brR[i-40];
					}
				
			}
		}
		//Editor.SelectedObject = ImageIO.read(ResourceLoader.load(Path));
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
