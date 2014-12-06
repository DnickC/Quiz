package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuNew extends JFrame {

	private JLabel titel = new JLabel("Hoofdmenu");
	private JPanel panelLeraarOpties = new JPanel();
	private JButton knopBeheerQuizzen = new JButton("1. Beheer quizzen/opdrachten");
	private JButton knopOverzichtScores = new JButton("2. Overzicht scores");
	private JButton knopInstellingenQuiz = new JButton("3. Instellingen quiz applicatie");
	
	private JPanel panelLeerlingOpties = new JPanel();
	private JButton knopDeelnemenQuiz = new JButton("1. Deelnemen quiz");
	private JButton knopQuizRapport = new JButton("2. Quiz rapport");
	
	private JButton knopStop = new JButton ("Stop applicatie");
	
	private JPanel mainMenu = new JPanel();
	
	private GridBagLayout layout = new GridBagLayout();
	private GridBagConstraints gridConstraint = new GridBagConstraints();
	
	public MainMenuNew(){
		super("Hoofdmenu");
		panelLeraarOpties.setBorder(BorderFactory.createTitledBorder("Leraar"));

		
		panelLeraarOpties.add(knopBeheerQuizzen);
		
		panelLeraarOpties.add(knopOverzichtScores);
		
		panelLeraarOpties.add(knopInstellingenQuiz);
		
		panelLeerlingOpties.setBorder(BorderFactory.createTitledBorder("Leerling"));
		panelLeerlingOpties.add(knopDeelnemenQuiz);
		panelLeerlingOpties.add(knopQuizRapport);
		
		
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
		
		mainMenu.add(panelLeraarOpties,gridConstraint);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 2;
		
		mainMenu.add(panelLeerlingOpties, gridConstraint);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 3;
		mainMenu.add(knopStop,gridConstraint);
		
		this.add(mainMenu);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(750,400);
		this.setVisible(true);
		
		
	}
	
	public void addKnopBeheerQuizzenActionListener(ActionListener knopBeheerQuizzenListener){
		knopBeheerQuizzen.addActionListener(knopBeheerQuizzenListener);
	}
	
	public void addKnopOverzichtScoresActionListener(ActionListener knopOverzichtScoresListener){
		knopOverzichtScores.addActionListener(knopOverzichtScoresListener);
	}
	
	public void addKnopInstellingenQuizActionListener(ActionListener knopInstellingenQuizListener){
		knopInstellingenQuiz.addActionListener(knopInstellingenQuizListener);
				
	}
	
	public void addKnopDeelnemenQuizActionListener(ActionListener knopDeelnemenQuizActionListener){
		knopDeelnemenQuiz.addActionListener(knopDeelnemenQuizActionListener);
	}
	
	public void addKnopQuizRapportActionListener(ActionListener knopQuizRapportActionListener){
		knopQuizRapport.addActionListener(knopQuizRapportActionListener);
	}
	
	public void addKnopStopActionListener(ActionListener knopStopActionListener){
		knopStop.addActionListener(knopStopActionListener);
	}
	
}
