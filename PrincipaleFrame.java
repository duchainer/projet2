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
	private JButton bouton1,bouton2,bouton3,bouton4,bouton5;
	private JTextField textField;
	private JLabel label;

	//Constructeurs
	public PrincipaleFrame () {
		setTitle ("Gestion Employés");           		// Titre
		setSize (300,600); 								// Dimensions 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermeture par x
		setLocationRelativeTo(null);					// Fenetre centree
		
		simplePanel = new  JPanel ();
		label = new  JLabel ("Code  usager");
		simplePanel.add(label);                         //Ajoute étiquette au panneau 
		
		textField = new  JTextField (10);
		simplePanel.add( textField );                   //Ajoute champ texte au panneau
		
		bouton1 = new JButton("Enregistrement");
		simplePanel.add( bouton1); 						//Ajoute bouton au panneau
		bouton2 = new JButton("Affichage");
		simplePanel.add( bouton2); 						//Ajoute bouton au panneau
		bouton3 = new JButton("Liste");
		simplePanel.add( bouton3); 						//Ajoute bouton au panneau
		bouton4 = new JButton("Statistiques");
		simplePanel.add( bouton4); 						//Ajoute bouton au panneau
		bouton5 = new JButton("Quitter");
		simplePanel.add( bouton5); 						//Ajoute bouton au panneau

		
		add( simplePanel );                             //  ajoute panneau à la  fenêtre

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	//Autres méthodes
}

