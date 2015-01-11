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

public class View_BeheerOpdrachtenLijst extends JPanel{

	/**
	 * @author Andy Poron
	 * Lijstje met opdrachten erin. Nieuwe maken of eentje aanpassen. 
	 */
	
	private JList<String> opdrachtenLijst = new JList<String>();
	private JButton knopNieuw = new JButton("Nieuw");
	private JButton knopWijzigen = new JButton("Wijzigen");
	private JButton knopVerwijder = new JButton("Verwijder");
	
	private GridBagLayout layout = new GridBagLayout();
	private GridBagConstraints gridConstraint = new GridBagConstraints();
	
	public View_BeheerOpdrachtenLijst(List<String> opdrachten){
		this.setLayout(layout);
		gridConstraint.fill = gridConstraint.HORIZONTAL;
		this.SetOpdrachtenLijst(opdrachten);
		gridConstraint.insets = new Insets(0,0,0,0);
		
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 0;
		this.add(opdrachtenLijst,gridConstraint);
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 1;
		this.add(knopNieuw,gridConstraint);
		
		gridConstraint.gridx = 2;
		gridConstraint.gridy = 1;
		this.add(knopWijzigen,gridConstraint);
		
		gridConstraint.gridx = 3;
		gridConstraint.gridy = 1;
		this.add(knopVerwijder,gridConstraint);		
	}
	
	public void SetOpdrachtenLijst(List<String> opdrachten){
		this.opdrachtenLijst.setListData(opdrachten.toArray(new String[0]));
	}
	
	public void addWijzigknopActionListener(ActionListener wijzigOpdrachtKnopListener){
		knopNieuw.addActionListener(wijzigOpdrachtKnopListener);
	}
	public void verwijderVerwijderknopActionListener(ActionListener verwijderVerwijderOpdrachtKnopListener){
		knopNieuw.removeActionListener(verwijderVerwijderOpdrachtKnopListener);
	}
	
	public void addVerwijderknopActionListener(ActionListener verwijderOpdrachtKnopListener){
		knopNieuw.addActionListener(verwijderOpdrachtKnopListener);
	}
	public void verwijderWijzigknopActionListener(ActionListener verwijderWijzigOpdrachtKnopListener){
		knopNieuw.removeActionListener(verwijderWijzigOpdrachtKnopListener);
	}
	
	public void addknopNieuweOpdrachtActionListener(ActionListener nieuweOpdractKnopListener){
		knopNieuw.addActionListener(nieuweOpdractKnopListener);
	}
	public void verwijderknopNieuweOpdrachtActionListener(ActionListener verwijderOpdrachtKnopListener){
		knopNieuw.removeActionListener(verwijderOpdrachtKnopListener);
	}
}
