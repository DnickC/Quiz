package view;

import javax.swing.*;

import java.awt.*;


public class BasisLayout extends JFrame {
		
	// Alles van QuizScherm
	private JPanel QuizScherm;
		// QuizPanel
	private JPanel QuizPanel;
	private JLabel lblOnderwerp;
	private JTextField txtOnderwerp;
	private JLabel lblKlas;
	private JComboBox cboKlas;
	private JLabel lblAuteur;
	private JComboBox cboAuteur;
	private JButton btnRegistreerQuiz;
		// OpdrachtenPanel
	private JPanel OpdrachtPanel;
	private JLabel lblCategorie;
	private JComboBox cboCategorie;
	private JLabel lblSorteer;
	private JComboBox cboSorteer;
	private JLabel lblAantalToegevoegd;
	private JLabel lblToegevoegd;
	private JTextArea opdrachten;
	private JTextArea toegevoegdeOpdrachten;
	
	private JButton btnVoegOpdrachtToe;
	private JButton btnVerwijderOpdracht;
	
	// Alles van de lege mainFrame
	private JPanel mainFrame;
	private CardLayout cardLayout;
	
	// ALles van Hoofdscherm
		private JPanel hoofdMenuScherm;
		private GridBagConstraints gridConstraint;
		private GridBagLayout gridBagLayout;
		private JLabel lblTitel;
		private JButton btnBeheerQuizzen;
		private JButton btnOverzichtScores;
		private JButton btnInstellingenQuiz;
		private JButton btnStop;
		private JButton btnDeelnemenQuiz;
		private JButton btnQuizRapport;
	
	public BasisLayout(){
		// Alles van lege Main Frame 
		mainFrame = new JPanel();
		mainFrame.setSize(600,600);
		
		cardLayout = new CardLayout();
		cardLayout.setHgap(5);
		cardLayout.setVgap(5);
		mainFrame.setLayout(cardLayout);
		
		// Alles van Hoofdmenu
		hoofdMenuScherm = new JPanel();
		lblTitel = new JLabel("Welkom bij de Quiz-Applicatie");
		btnBeheerQuizzen = new JButton("1. Beheer quizzen/opdrachten");
		btnOverzichtScores = new JButton("2. Overzicht scores");
		btnInstellingenQuiz = new JButton("3. Instellingen quiz applicatie");
		btnDeelnemenQuiz = new JButton("1. Deelnemen quiz");
		btnQuizRapport = new JButton("2. Quiz rapport");
		btnStop = new JButton("Stop");
		
		gridConstraint = new GridBagConstraints();
		gridBagLayout = new GridBagLayout();
		hoofdMenuScherm.setLayout(gridBagLayout);
		gridConstraint.fill = gridConstraint.HORIZONTAL;
		
		
		gridConstraint.insets = new Insets(0,60,0,0);
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 0;
		lblTitel.setFont(new Font("Serif",Font.BOLD,25));
		hoofdMenuScherm.add(lblTitel,gridConstraint);
		gridConstraint.insets = new Insets(0,0,0,0);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 1;
		hoofdMenuScherm.add(btnBeheerQuizzen,gridConstraint);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 2;
		hoofdMenuScherm.add(btnOverzichtScores,gridConstraint);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 3;
		hoofdMenuScherm.add(btnInstellingenQuiz,gridConstraint);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 4;
		hoofdMenuScherm.add(btnQuizRapport,gridConstraint);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 5;
		hoofdMenuScherm.add(btnDeelnemenQuiz,gridConstraint);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 6;
		hoofdMenuScherm.add(btnStop,gridConstraint);
		
		mainFrame.add(hoofdMenuScherm);
		
	
		// Alles van Quiz
		JPanel QuizScherm = new JPanel();
		QuizScherm.setLayout(gridBagLayout);
		
			// QuizPanel
		JPanel QuizPanel = new JPanel();
		QuizPanel.setLayout(gridBagLayout);
		
		JLabel lblOnderwerp = new JLabel("");
		JTextField txtOnderwerp= new JTextField();
		JLabel lblKlas= new JLabel();
		JComboBox cboKlas = new JComboBox();
		JLabel lblAuteur= new JLabel();
		JComboBox cboAuteur = new JComboBox();
		JButton btnRegistreerQuiz = new JButton("Registreer Quiz");	
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 0;
		QuizPanel.add(lblOnderwerp,gridConstraint);
		
		gridConstraint.gridx = 1;
		gridConstraint.gridy = 0;
		QuizPanel.add(txtOnderwerp,gridConstraint);
		
		gridConstraint.gridx = 3;
		gridConstraint.gridy = 0;
		QuizPanel.add(lblKlas,gridConstraint);
		
		gridConstraint.gridx = 4;
		gridConstraint.gridy = 0;
		QuizPanel.add(cboKlas,gridConstraint);
		
		gridConstraint.gridx = 5;
		gridConstraint.gridy = 0;
		QuizPanel.add(lblAuteur,gridConstraint);
		
		gridConstraint.gridx = 6;
		gridConstraint.gridy = 0;
		QuizPanel.add(cboAuteur,gridConstraint);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 1;
		QuizPanel.add(btnRegistreerQuiz,gridConstraint);
		
		QuizScherm.add(QuizPanel);
			// OpdrachtenPanel
		
		JPanel OpdrachtPanel = new JPanel();
		
		
		
		
		
		
		
		mainFrame.setSize(300,300);
		mainFrame.setVisible(true);
		
		
		
		
		
	}
	
	
	
	
	
}
