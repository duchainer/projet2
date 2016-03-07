import javax.swing.JOptionPane;

/**
 * C - Dans le fichier GestionEmploye.java, d�finir la classe principale GestionEmploye , avec un main() dans lequel :
 * 		- Un objet d�partement est cr�� avec un nom fixe (non demand�) de votre choix, et avec aucun employ� au d�part ,
 *  	puis un menu r�p�titif offre les options suivantes :
 * 1 - Enregistrer employ� : un objet Employ� est cr�� avec les valeurs lues au clavier ,
 *    cet objet sera plac� dans le tableau d� employ�s du d�partement.
 *     Un message confirmera l�enregistrement de l�employ� en affichant son code d�acc�s.
 * 2 - Afficher employ� : permet d�afficher les informations d�un employ� du d�partement
 *   		 dont le code d�acc�s sera demand� au clavier
 * 3 - Lister employ�s : permet d�afficher la liste de tous les employ�s du d�partement contenus dans le tableau,
 *    	leur nom, pr�nom, et salaires brut, un employ� par ligne (Utilise Employe.toString())
 *    		Ex R�sultat : PDomingues98, Domingues, Patrick, 2000$
 * 4 - Statistiques : permet d�afficher le nom du d�partement,
 *     	le nombre d�employ�s ainsi que la masse salariale et la moyenne salariale du d�partement.
 * 5 - Quitter : permet de terminer l�application
 *
 *
 * @author Raphael Duchaine
 *
 */
public class GestionEmploye {

	public static void main(String[] args) {

		//Initialisation des variables
        String liste="", newCode= "";
		int option=0;
		//D�claration et cr�ation de l'objet d�partement
        Departement dep1 = new Departement("Informatique");
        dep1.nbrEmploye=0;
		//menu r�p�titif
		do{
			//affichage du menu et saisie de l'option
			 option=Integer.parseInt(JOptionPane.showInputDialog(null,
					 "Choisir:\n 1: Enregistrer employ�\n 2: Afficher employ�\n 3: Lister employ�s\n 4: Statistiques \n 5: Quitter",
					 "Gestion des ressources Humaines\n AKA ton poste de travail",JOptionPane.QUESTION_MESSAGE));

			// les diff�rentes options du menu
			switch(option){
				case 1:  // Demande la saisie de tous les attributs d'un employe et affiche un message de confirmation
						if (JOptionPane.showConfirmDialog(null, "Voulez-vous enregistrer un employ�?", "Enregistrement",
						        JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
							break;

                                                //cr�ation de l'objet Employe dans une nouvelle case du tableau tabEmploye
						dep1.tabEmploye[dep1.nbrEmploye] = new Employe(JOptionPane.showInputDialog(null,"Nom de famille de l'employ�?: ","Enregistrer employ�",JOptionPane.QUESTION_MESSAGE),
						JOptionPane.showInputDialog(null,"Pr�nom de l'employ�?: ","Enregistrer employ�",JOptionPane.QUESTION_MESSAGE ),
						JOptionPane.showInputDialog(null,"Date de naissance de l'employ�?(en format JJ/MM/AAAA): ","Enregistrer employ�",JOptionPane.QUESTION_MESSAGE ),
						Double.parseDouble(JOptionPane.showInputDialog(null,"taux horaire de l'employ�?: ","Enregistrer employ�",JOptionPane.QUESTION_MESSAGE)),
						Integer.parseInt(JOptionPane.showInputDialog(null,"nombre d'heures travaill�es de l'employ�?: ","Enregistrer employ�",JOptionPane.QUESTION_MESSAGE)));

						//NOTE: La date de naissance de l'employe dois avoir la forme requise, sinon sa marche pas (� cause du substring dans Employe)
					 	JOptionPane.showMessageDialog(null,"compte enregistr�: " + dep1.tabEmploye[dep1.nbrEmploye].codeAcces(),"Enregistrer un employ�", JOptionPane.INFORMATION_MESSAGE);

                                                //prend en compte le nombre d'employe (� remplacer)
                                                dep1.nbrEmploye++;

						break;

				case 2:	//Affiche Employ�: permet d�afficher les informations d�un employ� du d�partement dont le code d�acc�s sera demand� au clavier

                                                //Saisie du code � recherche
						newCode = JOptionPane.showInputDialog(null,"Veillez entrer le Code d'acc�s de l'employ� en question: ","Afficher employ�",JOptionPane.QUESTION_MESSAGE);
						boolean trouve=false;
	    				for (int i=0; i<dep1.nbrEmploye; i++){

	                                                        //recherche le code identique � celui saisi
								if(newCode.equals(dep1.tabEmploye[i].codeAcces())){
									JOptionPane.showMessageDialog(null,"'"+newCode+"'\nNom: "+dep1.tabEmploye[i].nom+
									"\nPr�nom: "+dep1.tabEmploye[i].prenom+"\nDate de naissance: "+dep1.tabEmploye[i].date+
									"\nMot de passe: "+dep1.tabEmploye[i].mdp+"\nheures: "+dep1.tabEmploye[i].heures+
									"\nTaux horaire: "+dep1.tabEmploye[i].tauxHoraire,"Infos",JOptionPane.INFORMATION_MESSAGE);
									trouve=true;
									break;//on s'arr�te � la premi�re personne avec le code
								}

	    				}
	    				if (trouve)break;
	    				//Message pour signaler un code nonexistant (ou erron�)
	    				JOptionPane.showMessageDialog(null,"Le code entr� est non existant ou erron�.","Afficher employ�",JOptionPane.QUESTION_MESSAGE);

						break;

				case 3:	//Lister employ�s : permet d�afficher la liste de tous les employ�s du d�partement contenus (toString)

					for (int i=0; i<dep1.nbrEmploye; i++)
						//message qui contient les informations de tous les employ�s
                                                liste+="#"+(i+1)+", "+dep1.tabEmploye[i].nom+", "+dep1.tabEmploye[i].prenom+", "+dep1.tabEmploye[i].salaireBrut()+"\n";

					//On affiche la liste
					JOptionPane.showMessageDialog(null, liste,"Liste des employ�s", JOptionPane.INFORMATION_MESSAGE);

					//On r�initialise la liste, sinon elle s'accumulera a chaque r�p�tition
					liste="";
					break;

				case 4: //AFFICHE TOUTES LES INFORMATIONS SUR DEPARTEMENT
					//toString dans departement
					JOptionPane.showMessageDialog(null, dep1.toString(), "Statistiques", JOptionPane.INFORMATION_MESSAGE);
					 break;


				case 5://QUITTER
                                        //Option avec oui/non pour quitter le programme
					int reponse =JOptionPane.showConfirmDialog(null, "Le metier de gestionnaire te fait peur?",
							"Se Sauver de ses responsabilit�s",JOptionPane.YES_NO_OPTION);
					if(reponse==JOptionPane.YES_OPTION)
						break;
					else{option = 0;
						break;
						}

				default:
					JOptionPane.showMessageDialog(null, "Hey, le Nouveau! \nFais attention, tu mets ce d�partement en danger!");
				}//fin switch

			}while(option!=5);

	}

}
