package view;

import javax.swing.*;
import model.QuizCatalogus;

import java.awt.*;
import java.awt.event.ActionListener;

public class VerwijderQuiz extends JFrame {
	
	private JPanel verwijderQuizzen;
	
	private JLabel titel = new JLabel("Verwijder Quiz");
	private JList klassen = new JList();
	private JList auteurs = new JList();
	private JTable quizzen = new JTable();
	private JButton verwijder = new JButton("Verwijder");
	
	private GridBagLayout layout = new GridBagLayout();
	private GridBagConstraints constraints = new GridBagConstraints();
	
	public VerwijderQuiz(){
		super("Verwijder quizzen");
		
		verwijderQuizzen.setLayout(layout);
		constraints.fill = constraints.HORIZONTAL;
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		verwijderQuizzen.add(titel);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		verwijderQuizzen.add(klassen);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		verwijderQuizzen.add(auteurs);
		
		constraints.gridx = 2;
		constraints.gridy = 0;
		verwijderQuizzen.add(quizzen);
		
		constraints.gridx = 3;
		constraints.gridy = 0;
		verwijderQuizzen.add(verwijder);
		
		
		
	}
}
