package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame{

	private JLabel titel = new JLabel("Hoofd Menu");
	private JButton knopNieuweQuiz = new JButton("1. Maak nieuwe quizzen");
	private JButton knopVerwijderQuiz = new JButton("2. Verwijderen van quizzen");
	private JButton knopWijzigQuiz = new JButton("3. Wijzigen van quizzen");
	private JButton knopLijsten = new JButton("6. Quiz lijsten");
	private JButton knopInstellingen = new JButton("7. Instellingen van de quiz applicatie");
	private JButton knopStop = new JButton("0. Stop de applicatie");
	private	JPanel mainMenu = new JPanel();
	
	private GridBagLayout layout = new GridBagLayout();
	
	MainMenu(){
		super("HoofdMenu");
		mainMenu.setLayout(layout);
		
		
		mainMenu.add(titel);
		mainMenu.add(knopNieuweQuiz);
		mainMenu.add(knopVerwijderQuiz);
		mainMenu.add(knopWijzigQuiz);
		mainMenu.add(knopLijsten);
		mainMenu.add(knopInstellingen);
		mainMenu.add(knopStop);
		
		this.add(mainMenu);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // In controller wrs? 
		this.setSize(800,300);
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
