package view;

import javax.swing.*;
import java.awt.event.ActionListener;


public class MainMenu extends JFrame{

	private JLabel titel = new JLabel("HoofdMenu");
	private JButton knopOpdrachten = new JButton("1. Beheren van opdrachten");
	private JButton knopQuizzen = new JButton("2. Beheren van quizzen/testen");
	private JButton knopDeelnemen = new JButton("3. Deelnemen aan quiz");
	private JButton knopOverzicht = new JButton("4. Overzicht scores");
	private JButton knopRapporten = new JButton("5. Quiz rapport");
	private JButton knopLijsten = new JButton("6. Quiz lijsten");
	private JButton knopInstellingen = new JButton("7. Instellingen van de quiz applicatie");
	private JButton knopStop = new JButton("0. Stop de applicatie");
	private	JPanel mainMenu = new JPanel();
	
	MainMenu(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,300);
		mainMenu.add(titel);
		mainMenu.add(knopOpdrachten);
		mainMenu.add(knopQuizzen);
		mainMenu.add(knopDeelnemen);
		mainMenu.add(knopOverzicht);
		mainMenu.add(knopRapporten);
		mainMenu.add(knopLijsten);
		mainMenu.add(knopInstellingen);
		mainMenu.add(knopStop);
		
		this.add(mainMenu);
	}
		
	public void addKnopQuizzenActionListener(ActionListener quizKnopListener){
		knopQuizzen.addActionListener(quizKnopListener);
	}
	
	// in de controller class
	
	/*
	 * this.doorgegevenView.addKnopQuizzenActionListener(New knopQuizListener());
	 * 
	 * inner class in controller
	 * knopQuizListener{
	 * 		 public void actionPerformed(ActionEvent e){
	 *    		.....
	 *  	}
	 *  }
	 * 
	 * 
	 */
	
}
