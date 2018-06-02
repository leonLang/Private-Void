package Metroid_Editor.edit.com;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JLabel;

public class Background extends JLabel implements MouseListener{

	private static final long serialVersionUID = 1L;
	public String s;
	public int ID;

	public Background(String text, int IDO, int ID) {
		this.ID = ID;
		this.setText(text);
		addMouseListener(this);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.s = text;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//
		Editor.clicked = true;
		//
			try {
				Editor.Background(s,ID);
			} catch (IOException e1) {
				e1.printStackTrace();
				}
			
		Editor.clicked = false;
		}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
