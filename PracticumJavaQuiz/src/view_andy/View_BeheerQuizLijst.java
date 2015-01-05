package view_andy;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.ListDataEvent;

public class View_BeheerQuizLijst extends JPanel{

	/**
	 * @author Andy Poron
	 * Een simpel lijstje met alle quizzen erin. Hier kies je je quiz en zal deze meegaan naar het detail scherm.
	 * De lijst komt rechtstreeks uit QuizDB ( Niet de beste oplossing.. maar kom)  
	 */
	
	private JList<String> quizLijst = new JList<String>();
	private JButton knopNieuw = new JButton("Nieuw");
	private JButton knopWijzigen = new JButton("Wijzigen");
	private JButton knopVerwijder = new JButton("Verwijder");
	
	private GridBagLayout layout = new GridBagLayout();
	private GridBagConstraints gridConstraint = new GridBagConstraints();
	
	public View_BeheerQuizLijst(List<String> quizzen){
		this.setLayout(layout);
		gridConstraint.fill = gridConstraint.HORIZONTAL;
		this.SetQuizLijst(quizzen);
		gridConstraint.insets = new Insets(0,0,0,0);
		
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 0;
		gridConstraint.gridwidth = 3;
		this.add(quizLijst,gridConstraint);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 1;
		gridConstraint.gridwidth = 0;
		this.add(knopNieuw,gridConstraint);
		
		gridConstraint.gridx = 1;
		gridConstraint.gridy = 1;
		this.add(knopWijzigen,gridConstraint);
		
		gridConstraint.gridx = 2;
		gridConstraint.gridy = 1;
		this.add(knopVerwijder,gridConstraint);		
	}
	
	/**
	 * Voeg de String lijst toe aan de JList. 
	 * @param List<String> quizzen
	 */
	
	public void SetQuizLijst(List<String> quizzen){
		this.quizLijst.setListData(quizzen.toArray(new String[0]));
	}
	
	/**
	 * Actionlistener toevoegen/verwijderen
	 * @param Actionlisteners
	 */
	
	public void addknopNieuweQuizActionListener(ActionListener nieuweQuizKnopListener){
		knopNieuw.addActionListener(nieuweQuizKnopListener);
	}
	public void verwijderknopNieuweQuizActionListener(ActionListener nieuweQuizKnopListener){
		knopNieuw.removeActionListener(nieuweQuizKnopListener);
	}
}
