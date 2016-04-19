import javax.swing.*;
import java.awt.event.*;

/**
 * 
 * 
 * @author Raphael Duchaine 19/04/2016
 */
public class PrincipaleFrame extends JFrame implements ActionListener {
	//Get-Set


	//Attributs
	private JPanel simplePanel;
	private JButton bouton1;
	private JTextField textField;
	private JLabel label;

	//Constructeurs
	public PrincipaleFrame () {
		setTitle (" ExempleFrame ");           			// Titre
		setSize (300,300); 								// Dimensions 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermeture par x
		setLocationRelativeTo(null);					// Fenetre centree
		
		simplePanel = new  JPanel ();
		label = new  JLabel ("Code  usager");
		simplePanel.add(label);                         //Ajoute étiquette au panneau 
		
		textField = new  JTextField (10);
		simplePanel.add( textField );                   //Ajoute champ texte au panneau
		
		bouton1 = new JButton("bouton");
		simplePanel.add( bouton1); 						//Ajoute bouton au panneau
		
		add( simplePanel );                             //  ajoute panneau à la  fenêtre

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	//Autres méthodes
}

