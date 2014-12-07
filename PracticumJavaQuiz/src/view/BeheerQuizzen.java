package view;

import javax.swing.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

public class BeheerQuizzen extends JFrame{
	
	private JPanel overzichtQuizzen = new JPanel();
	private JTable quizzenTabel = new JTable();
	private JScrollPane scrollPanel = new JScrollPane(quizzenTabel);
	
	
	private JPanel overzichtOpdrachten = new JPanel();
	private JTable opdrachtenTabel = new JTable();
	
	GridBagLayout layout = new GridBagLayout();
	GridBagConstraints gridConstraint = new GridBagConstraints();
	
	
	public BeheerQuizzen(){
		
		overzichtQuizzen.setLayout(layout);
		gridConstraint.fill = gridConstraint.HORIZONTAL;
		
		quizzenTabel.setFillsViewportHeight(true);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 1;
		
		overzichtQuizzen.add(quizzenTabel);
		
		this.add(overzichtQuizzen);
		this.setVisible(true);
	}
	

}
