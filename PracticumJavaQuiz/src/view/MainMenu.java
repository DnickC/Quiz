package view;

import javax.swing.*;
import java.awt.event.ActionListener;


public class MainMenu extends JFrame{

	private JLabel titel = new JLabel("HoofdMenu");
	private JButton knopNieuweQuiz = new JButton("1. Maak nieuwe quizzen");
	private JButton knopVerwijderQuiz = new JButton("2. Verwijderen van quizzen");
	private JButton knopWijzigQuiz = new JButton("3. Wijzigen van quizzen");
	private JButton knopLijsten = new JButton("6. Quiz lijsten");
	private JButton knopInstellingen = new JButton("7. Instellingen van de quiz applicatie");
	private JButton knopStop = new JButton("0. Stop de applicatie");
	private	JPanel mainMenu = new JPanel();
	
	MainMenu(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,300);
		mainMenu.add(titel);
		mainMenu.add(knopNieuweQuiz);
		mainMenu.add(knopVerwijderQuiz);
		mainMenu.add(knopWijzigQuiz);
		mainMenu.add(knopLijsten);
		mainMenu.add(knopInstellingen);
		mainMenu.add(knopStop);
		
		this.add(mainMenu);
	}
		
	public void addknopNieuweQuizActionListener(ActionListener nieuweQuizKnopListener){
		knopNieuweQuiz.addActionListener(nieuweQuizKnopListener);
	}
	
	public void addKnopVerwijderQuizActionListener(ActionListener verwijderQuizKnopListener){
		knopVerwijderQuiz.addActionListener(verwijderQuizKnopListener);
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
