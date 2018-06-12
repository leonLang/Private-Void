package Metroid_Editor.edit.com;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel extends JPanel implements ActionListener  {
	private String TempS;
	private String lid;
	JButton Size1;
	JLabel Info;
	JLabel Info2;
	JTextField SizeInput;
	JTextField LevelIDP;

	private static final long serialVersionUID = 1L;
	public Panel() {
		Size1 = new JButton("Submit");
		Size1.addActionListener(this);
		SizeInput = new JTextField("12x12");
		Info = new JLabel("Map Size");
		LevelIDP = new JTextField("1");
		Info2 = new JLabel("MapID");
		LevelIDP.setSize(200, 60);
		
		StartInfo();
	}
	public void StartInfo() {
		this.add(Info);
		this.add(Size1);
		this.add(SizeInput);
		this.add(Info2);
		this.add(LevelIDP);
	}
	public void convertDimensions() {
		TempS = SizeInput.getText();
		int StringLenght = TempS.length();
		Editor.ProjectWidth = Integer.parseInt(TempS.substring(0, TempS.lastIndexOf("x")));
		Editor.ProjectHeight = Integer.parseInt(TempS.substring(TempS.lastIndexOf("x") +1, StringLenght));
	}
	@Override
	public void actionPerformed (ActionEvent e) {
		convertDimensions();
		lid = LevelIDP.getText();
		Editor.LID = Integer.parseInt(lid);
		Editor.LevelID = lid;
		if(e.getSource() == this.Size1) {
			if(TempS == null) {
				JOptionPane.showMessageDialog(null, "Bitte gültige Werte eingeben", "Warning", JOptionPane.ERROR_MESSAGE);
			}else {
			/*sehr unschön wie ich finde aber geht leider nicht anders
			 *	Java weigert sich JPanel.remove(Component) zu benutzen selbes mit JFrame
			 *Auch repaint hat nicht funktioniert 
			 *--> Lösung:
			 *Neues JFrame mit gewünschten optionen erstellen altes Löschen
			 */
			JOptionPane.showMessageDialog(null, "Size " + TempS + "and ID: " + lid + "is now used","Information",JOptionPane.WARNING_MESSAGE);
			Main.frame.dispose();
			new Editor();
			}
			
		}
	}

}
