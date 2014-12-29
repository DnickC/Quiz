package view;

import javax.swing.*;

import java.awt.*;


public class BeheerQuizzen extends JFrame{
	
	final static int extraWindowWidth = 100; 
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	public void addingTabbedPane(Container pane){
		JTabbedPane tabb = new JTabbedPane();
		JLabel labelOnderwerp = new JLabel("Onderwerp: ");
		JTextField textfieldOnderwerp = new JTextField(20);
		JLabel labelLeerjaar = new JLabel("Leerjaar: ");
		JComboBox cmbLeerjaar = new JComboBox();
		JLabel labelIsTest = new JLabel("Test");
		JComboBox cmbIsTest = new JComboBox();
		JLabel labelIsUniekeDeelname = new JLabel("Is unieke deelname? ");
		JComboBox cmbQuizStatus = new JComboBox();
		JCheckBox chkIsUniekeDeelname = new JCheckBox();
		JTable overzichtQuizzen = new JTable();
		JPanel card1 = new JPanel(){
			
			public Dimension getPreferredSize(){
				Dimension size = super.getPreferredSize();
				size.width += extraWindowWidth;
				return size;
			}
		};
		
		card1.setLayout(gbl);
		gbc.fill = gbc.HORIZONTAL;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		card1.add(labelOnderwerp,gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		card1.add(textfieldOnderwerp,gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		card1.add(labelLeerjaar,gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		card1.add(cmbLeerjaar,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		card1.add(labelIsTest,gbc);
		// rest nog toevoegen
		
		
		JPanel card2 = new JPanel();
		card2.add(new JLabel("Verwijderen van quizzen komt hier"));
		
		JPanel card3 = new JPanel();
		card3.add(new JLabel("Overzicht van alle quizzen komt hier"));
		
		tabb.addTab("Nieuwe Quiz", card1);
		tabb.addTab("Verwijderen Quiz", card2);
		tabb.addTab("Overzicht Quiz", card3);
		
		
		pane.add(tabb, BorderLayout.CENTER);
		
	}
	

}
