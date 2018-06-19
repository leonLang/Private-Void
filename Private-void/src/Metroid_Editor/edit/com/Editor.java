//Peter
package Metroid_Editor.edit.com;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Editor implements ActionListener{
	private static double width;
	private static double height;
	public static int ProjectWidth;
	public static int ProjectHeight;
	public static JFrame Openingframe;
	public static String LevelID;
	public static int LevelIDR;
	public static int LID;
	public static int R;
	
	private JPanel editor;
	private JSplitPane splitPane;
	public static Grid displayPanel;
	private JPanel optionPanel;
	private JScrollPane scroll;
	
	private JMenuBar Menue;
	private JMenu file;
	private JMenu help;
	
	private JMenuItem save;
	private JMenuItem addID;
	private JMenuItem removeID;
	
	private Dimension screenSize;
	
	
	
	public static boolean clicked = false;

	
	//JLabel options
	public static int BackgroundLenght = 10;
	public static int ObjectSolidLenght = 60;
	public static int ObjectSoftLenght = 1;
	public static int EnemieLenght = 25;
	public static int  EventLenght = 1;
	
	private Background[] background = new Background[BackgroundLenght];
	private ObjectSolid[] solid = new ObjectSolid[ObjectSolidLenght];
	private ObjectSoft[] soft = new ObjectSoft[ObjectSoftLenght];
	private Enemie[] enemie = new Enemie[EnemieLenght];
	private EventObject[] event = new EventObject[EventLenght];
	
	public static BufferedImage SelectedObject;
	public static int IDO;
	public static int ID;
	public static int TextureID;
	public static int saveState;
	
	public static int PX;
	public static int PY;
	

	
	
	public Editor() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = screenSize.getWidth();
		height = screenSize.getHeight()-50;
		init();
		createFrame();
	}
	public void init() {
		//init options
	/*	background[0] = new Background("background+1",0,1);
		background[1] = new Background("background+2",0,2);
		solid[0] = new ObjectSolid("SObject+1",1,1);
		solid[1] = new ObjectSolid("SObject+2",1,2);
		soft[0] = new ObjectSoft("SObject+1",2,1);
		*/
		for(int i = 0;i < EventLenght;i++) {
			event[i] = new EventObject("Event+" + (int) (i + 1),4,i + 2);
			
		}
		for(int i = 0; i < EnemieLenght;i++) {
			enemie[i] = new Enemie("e+" + (int) (i+1),3,i+1);
		}
		for(int i = 0; i < ObjectSoftLenght;i++) {
			soft[i] = new ObjectSoft("SoObject+" + (int) (i+1),2,i+1);
		}
		for(int i = 0; i < ObjectSolidLenght;i++) {
			solid[i] = new ObjectSolid("SObject+" + (int) (i+1),1,i+1);
		}
		for(int i = 0; i < BackgroundLenght;i++) {
			background[i] = new Background("background+" + (int) (i+1),0,i+1);
		}
		
		
		///////////////////////////////
		optionPanel = new JPanel();
		editor = new JPanel();
		Menue = new JMenuBar();
		file = new JMenu("file");
		help = new JMenu("help");
		
		save = new JMenuItem("save");
		addID = new JMenuItem("addID");
		removeID = new JMenuItem("removeID");
		addID.addActionListener(this);
		removeID.addActionListener(this);
		save.addActionListener(this);

		createoptionPanel();
		createDisplayPanel();
		
		Menue.add(file);
		Menue.add(help);
		
		file.add(save);
		file.add(addID);
		file.add(removeID);
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setDividerLocation((int)width/4);
		editor.add(splitPane, BorderLayout.CENTER);
		splitPane.setLeftComponent(scroll);
		splitPane.setRightComponent(displayPanel);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Openingframe = new JFrame("Metroid Editor - " + Editor.ProjectWidth + "x" + Editor.ProjectHeight);
		Openingframe.add(Menue, BorderLayout.NORTH);
		
	}
	
	public void createoptionPanel() {
		scroll = new JScrollPane(optionPanel,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
				);
        BoxLayout boxLayout = new BoxLayout(optionPanel, BoxLayout.Y_AXIS);
        optionPanel.setLayout(boxLayout);
	    scroll.setPreferredSize( new Dimension((int) (width/1.2),(int) height) );
		for(int i = 0;i < background.length; i++) {
			optionPanel.add(solid[i]);
			optionPanel.add(background[i]);
		}
		for(int i = 0;i < event.length;i++) {
			optionPanel.add(event[i]);
		}
		for(int i = 0; i < solid.length;i++) {
			optionPanel.add(solid[i]);
		}
		for(int i = 0; i < soft.length;i++) {
			optionPanel.add(soft[i]);
		}
		for(int i = 0; i < enemie.length;i++) {
			optionPanel.add(enemie[i]);
		}

	}
	public void createDisplayPanel() {

		displayPanel = new Grid();
		displayPanel.setBackground(Color.white);
	}
	public void createFrame() {
		
		Openingframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Openingframe.setSize(new Dimension((int) width/2, (int) height/2));
		Openingframe.setVisible(true);
        
		//Openingframe.setExtendedState(Openingframe.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		Openingframe.getContentPane().add(editor);
	}
	public static void Background(String s, int i) throws IOException {
		String Path = "/Background/" + s +".jpg";
		displayPanel.backgroundID = i;
		Image img = ImageIO.read(ResourceLoader.load(Path));
		displayPanel.setBackground(img);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//save the created map
		if(e.getSource() == save) {
			displayPanel.scale = 1;
			displayPanel.repaint();
			try {
				File Level1 = new File("/home/leonl/Bilder/" + LevelID + ".pll");
				BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Level1)));
				w.write("!pllDOCUMENT");
				w.newLine();
				w.write("ID:" + LevelID + ";");
				w.newLine();
				w.write("X" + 100 + "Y" + 100 + ";");
				w.newLine();
				w.write("00x" + displayPanel.backgroundID + "-0y0w0h0r0t0;");
				w.newLine();
			//	saveState = 20;
				for(int i = 0;i < ProjectHeight;i++) {
					for(int o = 0;o < ProjectWidth;o++) {
					int IDO = displayPanel.getRectIDO(i, o);
					int ID = displayPanel.getRectID(i, o);
					String x = displayPanel.getRectX(i, o);
					String y = displayPanel.getRectY(i, o);
					String width = displayPanel.getRectW(i, o);
					String height = displayPanel.getRectH(i, o);
					int r = displayPanel.getRectR(i, o);
					String T = displayPanel.getRectT(i, o);
					w.write(IDO + "x" + ID + "-" + x + "y" + y + "w" + width + "h" + height + "r" + r + "t" + T + ";");
					w.newLine();
					//saveState++;
					displayPanel.save(saveState);
					
					}
				}
					
				w.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			saveState = 100;
		}
		if(e.getSource() == addID) {
			LevelIDR++;
			Grid.JID.setText(Integer.toString(Editor.LevelIDR));
			
		}
		if(e.getSource() == removeID) {
			LevelIDR--;
			Grid.JID.setText(Integer.toString(LevelIDR));
		}
		
	}

	
}
