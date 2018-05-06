package vvoid.Void.game;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import vvoid.init.main.Main;

public class BindingControl {
	
	private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	private static final String MOVE_UP = "move up";
	
	public BindingControl() {
		System.out.println("test");
		Main.panel.getInputMap(IFW).put(KeyStroke.getKeyStroke("UP"), MOVE_UP);
		Main.panel.getActionMap().put(MOVE_UP, new MoveAction());
	}
	
	private class MoveAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("test");
				
			}
		}
		
	}
