import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * 
 * @author Raphael Duchaine 19/04/2016
 */
public class PrincipaleFrame extends JFrame implements ActionListener {
	//Attributs-nonGraphiques
	Departement dep1 = new Departement("Informatique");

	//Attributs-graphiques
	JPanel simplePanel;
	ButtonGroup group;
	JRadioButton radio1,radio2;
	ArrayList<JButton> boutons = new ArrayList<JButton>();
	ArrayList<JTextField> champs = new ArrayList<JTextField>();

	//Constructeurs
	public PrincipaleFrame () {
		setTitle ("Gestion Employes");           		// Titre
		setSize (1000,800); 								// Dimensions 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermeture par x
		setLocationRelativeTo(null);					// Fenetre centree

		simplePanel = new  JPanel ();
		//Integre un gestionnaire de presentation GridLayout 
		// a 5 lignes et 4 colonnes et l'appliquer a l'objet simplePanel
		GridLayout gl = new GridLayout(0,4,10,10);
		simplePanel.setLayout(gl);

		//Ajout des Labels et champ de texte par une methode
		addChampDeTexte("Nom Employe",10);
		addChampDeTexte("Prenom Employe",10);
		addChampDeTexte("Date D'Embauche",10);
		addChampDeTexte("Heures Travaillees",10);
		addChampDeTexte("Taux Horaire",10);

		group = new ButtonGroup();
		radio1 = new JRadioButton("Employe", true);
		simplePanel.add(radio1);
		group.add(radio1);
		radio2 = new JRadioButton("Vendeur", false);
		simplePanel.add(radio2);
		group.add(radio2);

		addBouton("Enregistrement d'un employe");
		addEspace();
		addEspace();
		addEspace();
		addBouton("Affichage d'un employe");
		addBouton("Liste des Employes");
		addBouton("Statistiques");
		addBouton("Quitter");




		add( simplePanel );                             //  ajoute panneau a la  fenetre

	}

	//Ajoute un element vide au panneau
	public void addEspace() {
		simplePanel.add(new JLabel());
	}

	//Ajout des Labels et champ de texte par une methode tout en permettant d'avoir acces aux champs plus tard
	public void addChampDeTexte(String texte, int tailleChamp) {
		simplePanel.add(new  JLabel (texte));                         //Ajoute etiquette au panneau 
		champs.add(new JTextField (tailleChamp));
		simplePanel.add(champs.get(champs.size()-1));                   //Ajoute champ texte au panneau
	}

	//Ajout des boutons par une methode tout en permettant d'y avoir acces plus tard
	public void addBouton(String texte) {
		boutons.add( new JButton(texte));
		simplePanel.add(boutons.get(boutons.size()-1)); //Ajoute bouton au panneau
		boutons.get(boutons.size()-1).addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource()==boutons.get(0)){ 
			try {
				if(radio2.isSelected()){
					creeVendeur();
					clean();
				}else{
					creeEmploye();
					clean();
				}
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
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

	/**
	 * 
	 */
	private void clean() {
		//Modifie le texte des champs de texte a null en utilisant la methode setText()
		for(JTextField elem:champs)
			elem.setText("");
		//Remet les boutons-radios a zero
		radio1.setSelected(true);

	}


	//Autres methodes
	private void creeEmploye() throws NumberFormatException, Exception {
		//Appel le constructeur de Employe
		dep1.addEmploye(champs.get(0).getText(), champs.get(1).getText(), champs.get(2).getText(), Integer.parseInt(champs.get(3).getText()), Double.parseDouble(champs.get(4).getText()));


	}

	private void creeVendeur() throws NumberFormatException, Exception {
		//Demande les informations necessaires de plus
		int montantVente =Integer.parseInt(JOptionPane.showInputDialog(null, "Montant des ventes fait par l'employe?: ", "Enregistrer employe", JOptionPane.QUESTION_MESSAGE));
		double tauxCommission = Double.parseDouble(JOptionPane.showInputDialog(null, "Taux de commission de l'employe?: ", "Enregistrer employe", JOptionPane.QUESTION_MESSAGE));
		//Appel le constructeur de vendeur par departement
		dep1.addVendeur(champs.get(0).getText(), champs.get(1).getText(), champs.get(2).getText(),
				Integer.parseInt(champs.get(3).getText()), Double.parseDouble(champs.get(4).getText()),montantVente,tauxCommission);

	}

	private void affichage() {
		//Affiche Employe: permet d'afficher les informations d'un employe du departement dont le code d'acces sera demande au clavier

		//Saisie du code a recherche
		String codeSaisi = JOptionPane.showInputDialog(null, "Veillez entrer le Code d'acces de l'employe en question: ", "Afficher employe", JOptionPane.QUESTION_MESSAGE);
		boolean trouve = false;
		for (int i = 0; i < dep1.getNbrEmploye(); i++) {
			//recherche le code identique a celui saisi
			if (codeSaisi.equals(dep1.getTabEmploye(i).codeAcces())) {
				//Affiche les informations de l'employe voulu dans les champs de texte
				champs.get(0).setText(dep1.getTabEmploye(i).getNom());
				System.out.println(champs.get(0).getText());
				champs.get(1).setText(dep1.getTabEmploye(i).getPrenom());
				champs.get(2).setText(dep1.getTabEmploye(i).getDate());
				champs.get(3).setText(Double.toString(dep1.getTabEmploye(i).getHeures()));
				champs.get(4).setText(Double.toString(dep1.getTabEmploye(i).getTauxHoraire()));
				//on s'arrete a la premiere personne avec le code
				trouve = true;
				break;
			}
		}
		if (!trouve) //Si le code n'a pas ete trouve
			//Message pour signaler un code inexistant (ou errone)
			JOptionPane.showMessageDialog(null, "Le code entre est non existant ou errone.", "Afficher employe", JOptionPane.QUESTION_MESSAGE);

	}



	private void liste() {
		//Lister employes : permet d'afficher la liste de tous les employes du departement contenus (Utilisation du toString() d'Employe)
		String liste ="";
		if (dep1.getNbrEmploye() < 1) {
			JOptionPane.showMessageDialog(null, "Aucun Employe...");
		}else{

			for (int i = 0; i < dep1.getNbrEmploye(); i++) //message qui contient les informations de tous les employes
			{
				liste += dep1.getTabEmploye(i).toString() + "\n";
			}
			//On affiche la liste
			JOptionPane.showMessageDialog(null, liste, "Liste des employes", JOptionPane.INFORMATION_MESSAGE);

			//On reinitialise la liste, sinon elle s'accumulera a chaque repetition
			liste = "";
		}
	}

	private void statistique() {
		//AFFICHE TOUTES LES INFORMATIONS SUR DEPARTEMENT
		//Utilisation du toString() de Departement
		try {
			JOptionPane.showMessageDialog(null, dep1.toString(), "Statistiques", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void quitter() {
		//Option avec oui/non pour quitter le programme
		int reponse = JOptionPane.showConfirmDialog(null, "Le metier de gestionnaire te fait peur?",
				"Se Sauver?", JOptionPane.YES_NO_OPTION);
		if (reponse == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}
}


