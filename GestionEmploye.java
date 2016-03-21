import javax.swing.JOptionPane;

/**
 * C - Dans le fichier GestionEmploye.java, définir la classe principale GestionEmploye , avec un main() dans lequel :
 * 		- Un objet département est créé avec un nom fixe (non demandé) de votre choix, et avec aucun employé au départ ,
 *  	puis un menu répétitif offre les options suivantes :
 * 1 - Enregistrer employé : un objet Employé est créé avec les valeurs lues au clavier ,
 *    cet objet sera placé dans le tableau d’ employés du département.
 *     Un message confirmera l’enregistrement de l’employé en affichant son code d’accès.
 * 2 - Afficher employé : permet d’afficher les informations d’un employé du département
 *   		 dont le code d’accès sera demandé au clavier
 * 3 - Lister employés : permet d’afficher la liste de tous les employés du département contenus dans le tableau,
 *    	leur nom, prénom, et salaires brut, un employé par ligne (Utilise Employe.toString())
 *    		Exemple de Résultat : PDomingues98, Domingues, Patrick, 2000$
 * 4 - Statistiques : permet d’afficher le nom du département,
 *     	le nombre d’employés ainsi que la masse salariale et la moyenne salariale du département.
 * 5 - Quitter : permet de terminer l’application
 *
 *
 * @author Raphael Duchaine 24/01/2016
 * @author2 Patrick Domingues 05/03/2016
 */
public class GestionEmploye {

	public static void main(String[] args) {

		//Initialisation des variables
        String liste="", codeSaisi= "";
		int option=0;
		//Déclaration et création de l'objet département
        Departement dep1 = new Departement("Informatique");
        dep1.nbrEmploye=0;
		//menu répétitif
		do{
			//affichage du menu et saisie de l'option
			 option=Integer.parseInt(JOptionPane.showInputDialog(null,
					 "Choisir:\n 1: Enregistrer employé\n 2: Afficher employé\n 3: Lister employés\n 4: Statistiques \n 5: Quitter",
					 "Gestion des ressources Humaines\n AKA ton poste de travail",JOptionPane.QUESTION_MESSAGE));

			// les différentes options du menu
			switch(option){
				case 1:  // Demande la saisie de tous les attributs d'un employe et affiche un message de confirmation
						if(dep1.nbrEmploye>=dep1.MAX){
							JOptionPane.showMessageDialog(null,"Il y a déjà 20 employés (C'est le maximum)","Enregistrer un employé DE TROP", JOptionPane.ERROR_MESSAGE);
							break;
						}
							
					if (JOptionPane.showConfirmDialog(null, "Voulez-vous enregistrer un employé?", "Enregistrement",
						        JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
							break;

                                                //création de l'objet Employe dans une nouvelle case du tableau tabEmploye
						dep1.tabEmploye[dep1.nbrEmploye] = new Employe(JOptionPane.showInputDialog(null,"Nom de famille de l'employé?: ","Enregistrer employé",JOptionPane.QUESTION_MESSAGE),
						JOptionPane.showInputDialog(null,"Prénom de l'employé?: ","Enregistrer employé",JOptionPane.QUESTION_MESSAGE ),
						JOptionPane.showInputDialog(null,"Date de naissance de l'employé?(en format JJMMAAAA): ","Enregistrer employé",JOptionPane.QUESTION_MESSAGE),
						Integer.parseInt(JOptionPane.showInputDialog(null,"nombre d'heures travaillées de l'employé?: ","Enregistrer employé",JOptionPane.QUESTION_MESSAGE)),
								Double.parseDouble(JOptionPane.showInputDialog(null,"taux horaire de l'employé?: ","Enregistrer employé",JOptionPane.QUESTION_MESSAGE)));

						//NOTE: La date de naissance de l'employe dois avoir la forme requise, sinon sa marche pas (à cause du substring dans Employe)
					 	JOptionPane.showMessageDialog(null,"compte enregistré: " + dep1.tabEmploye[dep1.nbrEmploye].codeAcces(),"Enregistrer un employé", JOptionPane.INFORMATION_MESSAGE);

                                                //prend en compte le nombre d'employe (à remplacer)
                                                dep1.nbrEmploye++;

						break;

				case 2:	//Affiche Employé: permet d’afficher les informations d’un employé du département dont le code d’accès sera demandé au clavier

                                                //Saisie du code à recherche
						codeSaisi = JOptionPane.showInputDialog(null,"Veillez entrer le Code d'accès de l'employé en question: ","Afficher employé",JOptionPane.QUESTION_MESSAGE);
						boolean trouve=false;
	    				for (int i=0; i<dep1.nbrEmploye; i++){

	                          //recherche le code identique à celui saisi
								if(codeSaisi.equals(dep1.tabEmploye[i].codeAcces())){
									//Affiche les informations de l'employe voulu (Utilisation de afficher() 
									JOptionPane.showMessageDialog(null,dep1.tabEmploye[i].afficher(),"Infos",JOptionPane.INFORMATION_MESSAGE);
									//on s'arrête à la première personne avec le code
									trouve=true;
									break;
								}
	    				}
	    				if (trouve) //Si le code a été trouver, sortir
	    					break;
	    				
	    				//Message pour signaler un code inexistant (ou erroné)
	    				JOptionPane.showMessageDialog(null,"Le code entré est non existant ou erroné.","Afficher employé",JOptionPane.QUESTION_MESSAGE);

						break;

				case 3:	//Lister employés : permet d’afficher la liste de tous les employés du département contenus (Utilisation du toString() d'Employe)
					if(dep1.nbrEmploye<1){
						JOptionPane.showMessageDialog(null, "Aucun Employé...");
						break;
					}
					
					for (int i=0; i<dep1.nbrEmploye; i++)
						//message qui contient les informations de tous les employés
                                                liste+=dep1.tabEmploye[i].toString()+"\n";
					//On affiche la liste
					JOptionPane.showMessageDialog(null, liste,"Liste des employés", JOptionPane.INFORMATION_MESSAGE);

					//On réinitialise la liste, sinon elle s'accumulera a chaque répétition
					liste="";
					break;

				case 4: //AFFICHE TOUTES LES INFORMATIONS SUR DEPARTEMENT
					//Utilisation du toString() de Departement
					JOptionPane.showMessageDialog(null, dep1.toString(), "Statistiques", JOptionPane.INFORMATION_MESSAGE);
					 break;


				case 5://QUITTER
                                        //Option avec oui/non pour quitter le programme
					int reponse =JOptionPane.showConfirmDialog(null, "Le metier de gestionnaire te fait peur?",
							"Se Sauver de ses responsabilités",JOptionPane.YES_NO_OPTION);
					if(reponse==JOptionPane.YES_OPTION)
						break;
					else{option = 0;
						break;
						}

				default:
					JOptionPane.showMessageDialog(null, "Hey, le Nouveau! \nFais attention, tu mets ce département en danger!");
				}//fin switch

			}while(option!=5);

	}

}
