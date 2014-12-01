package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame{

	/**
	 * @author Andy Poron
	 */
	
	private JLabel titel = new JLabel("HoofdMenu");
	private JButton knopNieuweQuiz = new JButton("1. Maak nieuwe quizzen");
	private JButton knopVerwijderQuiz = new JButton("2. Verwijderen van quizzen");
	private JButton knopWijzigQuiz = new JButton("3. Wijzigen van quizzen");
	private JButton knopLijsten = new JButton("6. Quiz lijsten");
	private JButton knopInstellingen = new JButton("7. Instellingen van de quiz applicatie");
	private JButton knopStop = new JButton("0. Stop de applicatie");
	private	JPanel mainMenu = new JPanel();
	
	
	private GridBagLayout layout = new GridBagLayout();
	private GridBagConstraints gridConstraint = new GridBagConstraints();
	
	public MainMenu(){
		super("HoofdMenu");
		mainMenu.setLayout(layout);
		gridConstraint.fill = gridConstraint.HORIZONTAL;
		
		gridConstraint.insets = new Insets(0,60,0,0);
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 0;
		titel.setFont(new Font("Serif",Font.BOLD,25));
		mainMenu.add(titel,gridConstraint);
		gridConstraint.insets = new Insets(0,0,0,0);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 1;
		mainMenu.add(knopNieuweQuiz,gridConstraint);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 2;
		mainMenu.add(knopVerwijderQuiz,gridConstraint);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 3;
		mainMenu.add(knopWijzigQuiz,gridConstraint);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 4;
		mainMenu.add(knopLijsten,gridConstraint);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 5;
		mainMenu.add(knopInstellingen,gridConstraint);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 6;
		mainMenu.add(knopStop,gridConstraint);
		
		this.add(mainMenu);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // In controller wrs? 
		this.setSize(300,300);
		this.setVisible(true);
	}
	
	
		
	public void addknopNieuweQuizActionListener(ActionListener nieuweQuizKnopListener){
		knopNieuweQuiz.addActionListener(nieuweQuizKnopListener);
	}
	
	public void addKnopVerwijderQuizActionListener(ActionListener verwijderQuizKnopListener){
		knopVerwijderQuiz.addActionListener(verwijderQuizKnopListener);
	}
	
	public void addKnopWijzigQuizActionListener(ActionListener wijzigQuizKnopListener){
		knopWijzigQuiz.addActionListener(wijzigQuizKnopListener);
	}
	
	public void addKnopLijstenActionListener(ActionListener lijstenKnopListener){
		knopLijsten.addActionListener(lijstenKnopListener);
	}
	
	public void addKnopInstellingenActionListener(ActionListener instellingenKnopListener){
		knopInstellingen.addActionListener(instellingenKnopListener);
	}
	
	public void addKnopStopActionListener(ActionListener stopKnopListener){
		knopInstellingen.addActionListener(stopKnopListener);
	}
	
	
	
	
	// in de controller class
	
	/*
	 * this.doorgegevenView.addKnopQuizzenActionListener(New knopQuizListener());
	 * 
	 * inner class in controller
	 * knopQuizListener{
	 * 		 public void actionPerformed(ActionEvent e){
	 *    		Open gewesnt venster.. 
	 *  	}
	 *  }
	 * 
	 * 
	 */
	
}
