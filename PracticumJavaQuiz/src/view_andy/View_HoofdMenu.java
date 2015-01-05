package view_andy;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class View_HoofdMenu extends JPanel{

	/**
	 * @author Andy Poron
	 * 
	 */
	
	private JButton knopOpdrachtenBeheren = new JButton("1. Beheren van opdrachten");
	private JButton knopQuizzenBeheren = new JButton("2. Beheren van quizzen/testen");
	private JButton knopDeelnemenQuiz = new JButton("3. Deelnemen aan quiz");
	private JButton knopScoreOverzicht = new JButton("4. Overzicht scores");
	private JButton knopQuizRapport = new JButton("5. Quiz rapport");
	private JButton knopLijsten = new JButton("6. Quiz lijsten");
	private JButton knopInstellingen = new JButton("7. Instellingen van de quiz applicatie");
	private JButton knopStop = new JButton("0. Stop de applicatie");
	
	private GridBagLayout layout = new GridBagLayout();
	private GridBagConstraints gridConstraint = new GridBagConstraints();
	
	/**
	 * Constructor voor het hoofdmenu
	 */
	
	public View_HoofdMenu(){
		this.setLayout(layout);
		gridConstraint.fill = gridConstraint.HORIZONTAL;
		
		gridConstraint.insets = new Insets(0,0,0,0);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 0;
		this.add(knopOpdrachtenBeheren,gridConstraint);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 1;
		this.add(knopQuizzenBeheren,gridConstraint);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 2;
		this.add(knopDeelnemenQuiz,gridConstraint);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 3;
		this.add(knopScoreOverzicht,gridConstraint);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 4;
		this.add(knopQuizRapport,gridConstraint);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 5;
		this.add(knopLijsten,gridConstraint);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 6;
		this.add(knopInstellingen,gridConstraint);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 7;
		this.add(knopStop,gridConstraint);
	}
	
	/**
	 * Alle Actionlisteners voor het hoofdmenu
	 * @param Actionlistener 
	 */
		
	public void addknopBeheerOpdrachtActionListener(ActionListener beheerOpdractKnopListener){
		knopOpdrachtenBeheren.addActionListener(beheerOpdractKnopListener);
	}
	public void verwijderknopBeheerOpdrachtActionListener(ActionListener beheerOpdractKnopListener){
		knopOpdrachtenBeheren.removeActionListener(beheerOpdractKnopListener);
	}
	
	public void addknopBeheerQuizActionListener(ActionListener beheerQuizKnopListener){
		knopQuizzenBeheren.addActionListener(beheerQuizKnopListener);
	}
	public void verwijderknopBeheerQuizActionListener(ActionListener beheerQuizKnopListener){
		knopQuizzenBeheren.removeActionListener(beheerQuizKnopListener);
	}
	
	public void addKnopDeelenemenQuizActionListener(ActionListener deelnemenQuizKnopListener){
		knopDeelnemenQuiz.addActionListener(deelnemenQuizKnopListener);
	}
	public void verwijderKnopDeelenemenQuizActionListener(ActionListener deelnemenQuizKnopListener){
		knopDeelnemenQuiz.removeActionListener(deelnemenQuizKnopListener);
	}
	
	public void addknopScoreOverzichtActionListener(ActionListener scoreOverzichtKnopListener){
		knopScoreOverzicht.addActionListener(scoreOverzichtKnopListener);
	}
	public void verwijderknopScoreOverzichtActionListener(ActionListener scoreOverzichtKnopListener){
		knopScoreOverzicht.removeActionListener(scoreOverzichtKnopListener);
	}
	
	public void addKnopQuizRapportActionListener(ActionListener deelnemenQuizRapportListener){
		knopQuizRapport.addActionListener(deelnemenQuizRapportListener);
	}
	public void verwijderKnopQuizRapportActionListener(ActionListener deelnemenQuizRapportListener){
		knopQuizRapport.removeActionListener(deelnemenQuizRapportListener);
	}
	
	public void addKnopLijstenActionListener(ActionListener lijstenKnopListener){
		knopLijsten.addActionListener(lijstenKnopListener);
	}
	public void verwijderKnopLijstenActionListener(ActionListener lijstenKnopListener){
		knopLijsten.removeActionListener(lijstenKnopListener);
	}
	
	public void addKnopInstellingenActionListener(ActionListener instellingenKnopListener){
		knopInstellingen.addActionListener(instellingenKnopListener);
	}
	public void verwijderKnopInstellingenActionListener(ActionListener instellingenKnopListener){
		knopInstellingen.removeActionListener(instellingenKnopListener);
	}
	
	public void addKnopStopActionListener(ActionListener stopKnopListener){
		knopInstellingen.addActionListener(stopKnopListener);
	}
	public void verwijderKnopStopActionListener(ActionListener stopKnopListener){
		knopInstellingen.removeActionListener(stopKnopListener);
	}
	
	
}
