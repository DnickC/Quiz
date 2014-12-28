package view;

import javax.swing.*;
import java.awt.*;


public class BeheerQuizzen extends JFrame{
	
	final static int extraWindowWidth = 100; 
	
	public void addingTabbedPane(Container pane){
		JTabbedPane tabb = new JTabbedPane();
		
		JPanel card1 = new JPanel(){
			
			public Dimension getPreferredSize(){
				Dimension size = super.getPreferredSize();
				size.width += extraWindowWidth;
				return size;
			}
		};
		
		GridBagLayout gbl = new GridBagLayout();
		
		
	}
	

}
