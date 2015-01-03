package view_andy;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View_Venster extends JFrame {		
	// Alles van de lege mainFrame
	private JPanel hoofdPanel;
	private BoxLayout hoofdLayout;
	
	private JPanel cardPanel;
	private CardLayout cardLayout;
	private JPanel pagina = null;
	
	private JPanel navigatiePanel;
	private BoxLayout navigatieLayout;
	private JButton btnTerug;
	private JLabel lblPaginaTitel;
	
	public View_Venster(){
		super("Quiz Applicatie 2014");
		
		hoofdPanel = new JPanel();
		hoofdLayout = new BoxLayout(hoofdPanel, BoxLayout.PAGE_AXIS);
		hoofdPanel.setLayout(hoofdLayout);
		hoofdPanel.setSize(600,600);
		
		// Navigatie
		navigatiePanel = new JPanel();
		navigatieLayout = new BoxLayout(navigatiePanel, BoxLayout.LINE_AXIS);
		navigatiePanel.setLayout(navigatieLayout);
		btnTerug = new JButton("Terug");
		lblPaginaTitel = new JLabel("");
		lblPaginaTitel.setFont(new Font("Serif",Font.BOLD,25));
		navigatiePanel.add(btnTerug);
		navigatiePanel.add(lblPaginaTitel);
		btnTerug.setVisible(false);
		
		hoofdPanel.add(navigatiePanel);
		
		cardPanel = new JPanel(); 
		cardLayout = new CardLayout(5, 5);
		cardPanel.setLayout(cardLayout);
		hoofdPanel.add(cardPanel);
		
		this.add(hoofdPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,600);
	}
	
	
	public void setPagina( JPanel pagina, String titel){
		JPanel prevPagina = this.pagina;
		this.pagina = pagina;
		
		cardPanel.add(pagina, titel);
		lblPaginaTitel.setText(titel);
		cardLayout.show(cardPanel, titel);
		
		if(prevPagina != null)
			cardPanel.remove(prevPagina);
	}
	
	public void setTerugEnabled( boolean enabled ){
		btnTerug.setVisible(enabled);
	}
	
	public void addknopTerugActionListener(ActionListener terugKnopListener){
		btnTerug.addActionListener(terugKnopListener);
	}
	
	public void verwijderKnopTerugActionListener(ActionListener terugKnopListener){
		btnTerug.removeActionListener(terugKnopListener);
	}
}