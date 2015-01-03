package view_andy;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.ListDataEvent;

import model.Leraar;
import model.Quiz;

public class View_WijzigQuiz extends JPanel{

	/**
	 * @author Andy Poron
	 */
	private GridBagConstraints gridConstraint;
	private GridBagLayout gridBagLayout;
	
	
	private Quiz quiz;
	public void setQuiz( Quiz quiz ){
		this.quiz = quiz;
	}
	
	
	public View_WijzigQuiz(){
		gridConstraint = new GridBagConstraints();
		gridBagLayout = new GridBagLayout();
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		gridConstraint.fill = gridConstraint.HORIZONTAL;
		
		// QuizPanel
		JPanel QuizPanel = new JPanel();
		QuizPanel.setLayout(gridBagLayout);
		
		JLabel lblOnderwerp = new JLabel("");
		lblOnderwerp.setMinimumSize(new Dimension(0, 100));
		JTextField txtOnderwerp= new JTextField();
		JLabel lblKlas= new JLabel();
		JComboBox<String> cboKlas = new JComboBox<String>(new String[]{"1", "2","3","4","5","6"});
		JLabel lblAuteur= new JLabel();
		JComboBox<String> cboAuteur = new JComboBox<String>(new String[]{ Leraar.LeraarA.toString(), Leraar.LeraarB.toString(), Leraar.LeraarC.toString(), Leraar.LeraarD.toString(), Leraar.LeraarE.toString()});
		JButton btnRegistreerQuiz = new JButton("Quiz Opslaan");	
		
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
		
		this.add(QuizPanel);
	}
	
}
