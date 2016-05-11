import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * 
 * @author Raphael Duchaine 19/04/2016
 */
public class PrincipaleFrame extends JFrame implements ActionListener {
	//Attributs
	Departement dep1 = new Departement ("SIM");
	String relativeFilePath ="/donnees/";


	//Attributs graphiques
	JPanel simplePanel;
	JRadioButton radio1,radio2;
	ButtonGroup group;
	ArrayList<JButton> boutons= new ArrayList<JButton>();
	ArrayList<JTextField> champs= new ArrayList<JTextField>();

	//Constructeurs
	public PrincipaleFrame () {
		setTitle ("Gestion Employes");           		// Titre
		setSize (800,700); 								// Dimensions 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermeture par x
		setLocationRelativeTo(null);					// Fenetre centree

		simplePanel = new  JPanel (); 					//Cree le panneau
		GridLayout gl = new GridLayout(0, 4, 10, 10);	//Cree GridLayout
		simplePanel.setLayout(gl);						//Set le layout
		//Ajoute les champs de texte
		addChampDeTexte("Nom Employe");
		addChampDeTexte("Prenom Employe");
		addChampDeTexte("Date D'Embauche");
		addChampDeTexte("Heures travaillees");
		addChampDeTexte("Taux Horaire");
		//Ajoute les 2 boutons radio
		radio1 = new JRadioButton("Employe",true);
		radio2 = new JRadioButton("Vendeur",false);
		group= new ButtonGroup();
		group.add(radio1);
		group.add(radio2);
		simplePanel.add(radio1);
		simplePanel.add(radio2);
		//Ajoute les boutons
		addBouton("Enregistrement");
		addEspace(); //Permet de laisser le bouton Enregistrement seul en haut a gauche
		addEspace();
		addEspace();
		addBouton("Affichage");
		addBouton("Liste");
		addBouton("Statistiques");
		addBouton("Quitter");

		add( simplePanel );                             //ajoute panneau a  la fenetre
		//TEST:
		/*
		try{
			 dep1.addVendeur("M", "Raph", "12981234", 30, 32,34,23);
		 		dep1.addEmploye("R", "Raph", "12981234", 30, 32);
		 		 dep1.addEmploye("T", "Raph", "12981234", 30, 32);
		     	 dep1.addEmploye("X", "Raph", "12981234", 30, 32);
		    	 dep1.addEmploye("Z", "Raph", "12981234", 30, 32);
				dep1.addEmploye("D", "Raph", "12981234", 30, 32);
				 dep1.addEmploye("B", "Raph", "12981234", 30, 32);
		    	 dep1.addEmploye("Y", "Raph", "12981234", 30, 32);
				dep1.addEmploye("C", "Raph", "12981234", 30, 32);
				 dep1.addEmploye("L", "Raph", "12981234", 30, 32);

		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
		}*/

	}

	private void addEspace() {
		simplePanel.add(new  JLabel (""));
	}

	public void addChampDeTexte(String label) {
		simplePanel.add(new  JLabel (label));                         //Ajoute etiquette au panneau 
		champs.add(new  JTextField (10));								//Cree le champ de texte et le met dans champs
		simplePanel.add( champs.get(champs.size()-1));                   //Ajoute champ de texte au panneau
	}

	public void addBouton(String label) {
		boutons.add(new JButton(label));								//Cree le bouton et le met dans boutons		
		simplePanel.add( boutons.get(boutons.size()-1)); 				//Ajoute bouton au panneau
		boutons.get(boutons.size()-1).addActionListener(this);			//Rend le bouton interactif

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Collections.sort(dep1.getTab(),Departement.COMPARE_BY_NAME);
		try {
			if(event.getSource()==boutons.get(0)){
				if(radio2.isSelected()){
					creeVendeur();
					clean();
				}else{
					creeEmploye();
					clean();
				}
			}
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "","ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		if(event.getSource()==boutons.get(1)){
			rechercher();
		}
		if(event.getSource()==boutons.get(2)){
			affichage();
		}if(event.getSource()==boutons.get(3)){
			liste();
		}if(event.getSource()==boutons.get(4)){
			statistiques();
		}if(event.getSource()==boutons.get(5)){
			quitter();
		}

	}
	//Autres methodes

	private void clean() {
		for(JTextField elem:champs)
			elem.setText("");
		radio1.setSelected(true);
	}

	private void creeVendeur() throws Exception {
		int montantVente=Integer.parseInt(JOptionPane.showInputDialog(null,"Entrer le montant des ventes:",
				"Enregistrer un Vendeur", JOptionPane.QUESTION_MESSAGE));
		int tauxCommission=Integer.parseInt(JOptionPane.showInputDialog(null,"Entrer le taux de commission des ventes:",
				"Enregistrer un Vendeur", JOptionPane.QUESTION_MESSAGE));
		dep1.addVendeur(champs.get(0).getText(), champs.get(1).getText(), champs.get(2).getText(),
				Integer.parseInt(champs.get(3).getText()), Double.parseDouble(champs.get(4).getText()), montantVente, tauxCommission);
		JOptionPane.showMessageDialog(null, "Compte enregistre: " + dep1.getTabEmploye(dep1.getNbrEmploye()-1).codeAcces(),
				"Enregistrer un Vendeur", JOptionPane.INFORMATION_MESSAGE);
	}

	private void creeEmploye() throws Exception {
		dep1.addEmploye(champs.get(0).getText(), champs.get(1).getText(), champs.get(2).getText(),
				Integer.parseInt(champs.get(3).getText()), Double.parseDouble(champs.get(4).getText()));
		JOptionPane.showMessageDialog(null, "Compte enregistre: " + dep1.getTabEmploye(dep1.getNbrEmploye()-1).codeAcces(),
				"Enregistrer un employe", JOptionPane.INFORMATION_MESSAGE);


	}

	private void rechercher() {
		// TODO Auto-generated method stub

	}


	private void affichage() {
		String code=JOptionPane.showInputDialog(null,"Entrer le code de l'employe:","Affichage",JOptionPane.QUESTION_MESSAGE);
		try{
			JOptionPane.showMessageDialog(null, dep1.rechercher(code).afficher(),"Affichage",JOptionPane.INFORMATION_MESSAGE);
		}catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Code errone ou inexistant","ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
		}

	}

	private void liste() {
		//Lister employes : permet d'afficher la liste de tous les employes du departement contenus (Utilisation du toString() d'Employe)
		if (dep1.getNbrEmploye()==0) {
			JOptionPane.showMessageDialog(null, "Aucun Employe...");
			return;
		}

		//On affiche la liste
		JOptionPane.showMessageDialog(null, dep1.listeTriee(), "Liste des employes", JOptionPane.INFORMATION_MESSAGE);

		try { 
			//	Écriture(création) du fichier listeEmployes.txt
			//get path to project
			String filePath = new File("").getAbsolutePath();
			//System.out.println( filePath );
			//Création du flux bufferisee
			BufferedWriter bf;

			bf = new BufferedWriter(new FileWriter(filePath+relativeFilePath+"listeEmployes.txt"));
			bf.write("***Liste des Employes***");
			bf.write("Code d'acces // Nom // Prenom // Date Embauche // Mot de Passe // Heures // Taux Horaire");
			for(Employe e:dep1.getTab()){
				bf.write(e.allVars());
			}
			bf.close();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
		}

		
	}

	private void statistiques() {
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

