import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * 
 * 
 * @author Raphael Duchaine 19/04/2016
 */
public class PrincipaleFrame extends JFrame implements ActionListener {
	//Get-Set


	//Attributs
	private JPanel simplePanel;
	private ButtonGroup group;
	private JRadioButton radio1,radio2;
	ArrayList<JButton> boutons = new ArrayList<JButton>();
	private JTextField textField;
	private JLabel label;

	//Constructeurs
	public PrincipaleFrame () {
		setTitle ("Gestion Employes");           		// Titre
		setSize (300,600); 								// Dimensions 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermeture par x
		setLocationRelativeTo(null);					// Fenetre centree
		
		simplePanel = new  JPanel ();
		//Intégre un gestionnaire de présentation GridLayout 
		// à 5 lignes et 2 colonnes et l'appliquer à l'objet panel
		GridLayout gl = new GridLayout(5,2,30,30);
		
		label = new  JLabel ("Nom Employe");
		simplePanel.add(label);                         //Ajoute etiquette au panneau 
		
		textField = new  JTextField (10);
		simplePanel.add( textField );                   //Ajoute champ texte au panneau
		
		radio1 = new JRadioButton("Employe", true);
		group.add(radio1);
		radio2 = new JRadioButton("Vendeur", true);
		group.add(radio2);
		
		addBouton("Enregistrement");
		addBouton("Affichage");
		addBouton("Liste");
		addBouton("Statistiques");
		addBouton("Quitter");


		
		add( simplePanel );                             //  ajoute panneau a  la  fenetre

	}


	public void addBouton(String texte) {
		boutons.add( new JButton(texte));
		simplePanel.add(boutons.get(boutons.size()-1)); 						//Ajoute bouton au panneau
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource()==boutons.get(0)){ 
			if(radio2.isSelected()){
				creeVendeur();
			}
			else{
				creeEmploye();
			}
		}
			
		if (event.getSource()==boutons.get(1))
			affichage();
		if (event.getSource()==boutons.get(2))
			liste();
		if (event.getSource()==boutons.get(3))
			statistique();
		if (event.getSource()==boutons.get(4))
			quitter();
	}

		//Autres methodes
		private void creeEmploye() {
			// TODO Auto-generated method stub
			
		}
		
		private void creeVendeur() {
			// TODO Auto-generated method stub
			
		}
		
		private void affichage() {
			
		}
		
		private void liste() {
			// TODO Auto-generated method stub
			
		}
		
		private void statistique() {
			// TODO Auto-generated method stub
			
		}
		
		private void quitter() {
			// TODO Auto-generated method stub
			
		}
}


