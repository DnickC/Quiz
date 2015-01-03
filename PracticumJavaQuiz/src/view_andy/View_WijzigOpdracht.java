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
import model.Opdracht;

public class View_WijzigOpdracht extends JPanel{

	/**
	 * @author Andy Poron
	 */
	private GridBagConstraints gridConstraint;
	private GridBagLayout gridBagLayout;
	
	
	private Opdracht opdracht;
	public void setOpdracht( Opdracht opdracht ){
		this.opdracht = opdracht;
	}
	
	
	public View_WijzigOpdracht(){
		gridConstraint = new GridBagConstraints();
		gridBagLayout = new GridBagLayout();
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		gridConstraint.fill = gridConstraint.HORIZONTAL;
		
		// opdrachtPanel
		JPanel opdrachtPanel = new JPanel();
		opdrachtPanel.setLayout(gridBagLayout);
		
		JLabel lblOnderwerp = new JLabel("");
		lblOnderwerp.setMinimumSize(new Dimension(0, 100));
		JTextField txtOnderwerp= new JTextField();
		JLabel lblKlas= new JLabel();
		JComboBox<String> cboKlas = new JComboBox<String>(new String[]{"1", "2","3","4","5","6"});
		JLabel lblAuteur= new JLabel();
		JComboBox<String> cboAuteur = new JComboBox<String>(new String[]{ Leraar.LeraarA.toString(), Leraar.LeraarB.toString(), Leraar.LeraarC.toString(), Leraar.LeraarD.toString(), Leraar.LeraarE.toString()});
		JButton btnRegistreeropdracht = new JButton("opdracht Opslaan");	
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 0;
		opdrachtPanel.add(lblOnderwerp,gridConstraint);
		
		gridConstraint.gridx = 1;
		gridConstraint.gridy = 0;
		opdrachtPanel.add(txtOnderwerp,gridConstraint);
		
		gridConstraint.gridx = 3;
		gridConstraint.gridy = 0;
		opdrachtPanel.add(lblKlas,gridConstraint);
		
		gridConstraint.gridx = 4;
		gridConstraint.gridy = 0;
		opdrachtPanel.add(cboKlas,gridConstraint);
		
		gridConstraint.gridx = 5;
		gridConstraint.gridy = 0;
		opdrachtPanel.add(lblAuteur,gridConstraint);
		
		gridConstraint.gridx = 6;
		gridConstraint.gridy = 0;
		opdrachtPanel.add(cboAuteur,gridConstraint);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 1;
		opdrachtPanel.add(btnRegistreeropdracht,gridConstraint);
		
		this.add(opdrachtPanel);
	}
	
}
