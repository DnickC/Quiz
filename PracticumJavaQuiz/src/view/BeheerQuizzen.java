package view;

import javax.swing.*;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

public class BeheerQuizzen extends JFrame{
	
	
	private JPanel overzichtQuizzen = new JPanel();
	
	private JTable quizzenTabel = new JTable();
	private JScrollPane scrollPanel = new JScrollPane(quizzenTabel);
	
	private JLabel leerjaar = new JLabel("Leerjaar: ");
	private JComboBox keuzeLeerjaar = new JComboBox();
	
	private JPanel overzichtOpdrachten = new JPanel();
	private JTable opdrachtenTabel = new JTable();
	
	
	
	GridBagLayout layout = new GridBagLayout();
	GridBagConstraints gridConstraint = new GridBagConstraints();
	
	CardLayout cl = new CardLayout();
	
	public BeheerQuizzen(){
		
		this.setLayout(cl);
		this.add(overzichtQuizzen);
		this.add(overzichtOpdrachten);
		
		overzichtQuizzen.setLayout(layout);
		gridConstraint.fill = gridConstraint.HORIZONTAL;
		
		quizzenTabel.setFillsViewportHeight(true);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 1;
		
		overzichtQuizzen.add(quizzenTabel);
		
		quizzenTabel.setPreferredScrollableViewportSize(new Dimension(500,70));
		
		this.add(overzichtQuizzen);
		this.setVisible(true);
		this.pack();
	}
	

}
