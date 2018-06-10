package Metroid_Editor.edit.com;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Grid extends JPanel implements KeyListener, MouseWheelListener, MouseListener {
	public int konst = 50 / 2;
	public Image background;
	public double scale = 1;
	public int TransX = 0;
	public int TransY = 0;
	public int backgroundID = 0;
	public Rect[][] rect = new Rect[Editor.ProjectHeight][Editor.ProjectWidth];
	JLabel Scale;
	JProgressBar progress;

	private static final long serialVersionUID = 1L;

	public Grid() {
		progress = new JProgressBar(0, 100);
		progress.setValue(0);
		progress.setStringPainted(true);
		progress.setVisible(false);
		Editor.saveState = 0;
		Scale = new JLabel();
		this.setFocusable(true);
		addMouseWheelListener(this);
		addMouseListener(this);
		addKeyListener(this);
		this.add(Scale);
		this.add(progress);

		for (int i = 0; i < Editor.ProjectHeight; i++) {
			for (int o = 0; o < Editor.ProjectWidth; o++) {
				rect[i][o] = new Rect(0, 0, (int) (50 * scale), (int) (50 * scale));
			}
		}
	}

	public void save(int s) {
		if (s >= 100) {
			progress.setVisible(false);
		} else {
			progress.setVisible(true);
		}
		progress.setValue(s);
		repaint();
	}

	public void setBackground(Image img) {
		this.background = img;
		repaint();

	}

	public int getRectIDO(int i, int o) {
		int s = rect[i][o].IDO;
		return s;
	}

	public int getRectID(int i, int o) {
		int s = rect[i][o].ID;
		return Integer.parseInt(Integer.toHexString(s));
	}

	public String getRectX(int i, int o) {
		int s = (int) (rect[i][o].x / scale) * 2;
		return Integer.toHexString(s);
	}

	public String getRectY(int i, int o) {
		int s = (int) (rect[i][o].y / scale) * 2;
		return Integer.toHexString(s);
	}

	public String getRectW(int i, int o) {
		int s = (int) (rect[i][o].width / scale) * 2;
		return Integer.toHexString(s);
	}

	public String getRectH(int i, int o) {
		int s = (int) (rect[i][o].height / scale) * 2;
		return Integer.toHexString(s);
	}

	public int getRectR(int i, int o) {
		int s = (int) (rect[i][o].R);
		return s;
	}

	public String getRectT(int i, int o) {
		int s = (int) (rect[i][o].TextureID);
		return Integer.toHexString(s);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x = 0;
		int y = 0;
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(TransX, TransY);
		if (background != null) {
			g.drawImage(background, 0, 0, Editor.ProjectWidth * (int) (konst * scale),
					Editor.ProjectHeight * (int) (konst * scale), null);
		}
		for (int i = 0; i < Editor.ProjectHeight; i++) {
			for (int o = 0; o < Editor.ProjectWidth; o++) {
				rect[i][o].draw(g, x, y, (int) (konst * scale), (int) (konst * scale));
				x += konst * scale;
			}
			y += konst * scale;
			x = 0;
		}
		g2d.translate(-TransX, -TransY);
		Scale.setText("Scale: " + Math.round(scale * 10d) / 10d);
		Toolkit.getDefaultToolkit();

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		int notches = e.getWheelRotation();
		if (notches < 0) {
			scale = scale * 2;
			repaint();
		} else if (notches > 0) {
			if (scale >= 2)
				scale = scale / 2;
			repaint();
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			TransX -= konst * scale;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			TransX += konst * scale;

		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			TransY -= konst * scale;

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			TransY += konst * scale;

		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {

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
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			for (int i = 0; i < Editor.ProjectHeight; i++) {
				for (int o = 0; o < Editor.ProjectWidth; o++) {
					if (rect[i][o].coll(e.getX() - TransX, e.getY() - TransY)) {
						if (Editor.SelectedObject != null) {
							rect[i][o].setObject(Editor.SelectedObject, Editor.IDO, Editor.TextureID, i, o);
						}
						Editor.clicked = false;
					}
				}
			}
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			for (int i = 0; i < Editor.ProjectHeight; i++) {
				for (int o = 0; o < Editor.ProjectWidth; o++) {
					rect[i][o].collremove(e.getX() - TransX, e.getY() - TransY);
				}
			}
		}
		repaint();

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
