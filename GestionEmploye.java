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
 *    		Exemple de R�sultat : PDomingues98, Domingues, Patrick, 2000$
 * 4 - Statistiques : permet d�afficher le nom du d�partement,
 *     	le nombre d�employ�s ainsi que la masse salariale et la moyenne salariale du d�partement.
 * 5 - Quitter : permet de terminer l�application
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
						if(dep1.nbrEmploye>=dep1.MAX){
							JOptionPane.showMessageDialog(null,"Il y a d�j� 20 employ�s (C'est le maximum)","Enregistrer un employ� DE TROP", JOptionPane.ERROR_MESSAGE);
							break;
						}
							
					if (JOptionPane.showConfirmDialog(null, "Voulez-vous enregistrer un employ�?", "Enregistrement",
						        JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
							break;

                                                //cr�ation de l'objet Employe dans une nouvelle case du tableau tabEmploye
						dep1.tabEmploye[dep1.nbrEmploye] = new Employe(JOptionPane.showInputDialog(null,"Nom de famille de l'employ�?: ","Enregistrer employ�",JOptionPane.QUESTION_MESSAGE),
						JOptionPane.showInputDialog(null,"Pr�nom de l'employ�?: ","Enregistrer employ�",JOptionPane.QUESTION_MESSAGE ),
						JOptionPane.showInputDialog(null,"Date de naissance de l'employ�?(en format JJ/MM/AAAA): ","Enregistrer employ�",JOptionPane.QUESTION_MESSAGE),
						Integer.parseInt(JOptionPane.showInputDialog(null,"nombre d'heures travaill�es de l'employ�?: ","Enregistrer employ�",JOptionPane.QUESTION_MESSAGE)),
								Double.parseDouble(JOptionPane.showInputDialog(null,"taux horaire de l'employ�?: ","Enregistrer employ�",JOptionPane.QUESTION_MESSAGE)));

						//NOTE: La date de naissance de l'employe dois avoir la forme requise, sinon sa marche pas (� cause du substring dans Employe)
					 	JOptionPane.showMessageDialog(null,"compte enregistr�: " + dep1.tabEmploye[dep1.nbrEmploye].codeAcces(),"Enregistrer un employ�", JOptionPane.INFORMATION_MESSAGE);

                                                //prend en compte le nombre d'employe (� remplacer)
                                                dep1.nbrEmploye++;

						break;

				case 2:	//Affiche Employ�: permet d�afficher les informations d�un employ� du d�partement dont le code d�acc�s sera demand� au clavier

                                                //Saisie du code � recherche
						codeSaisi = JOptionPane.showInputDialog(null,"Veillez entrer le Code d'acc�s de l'employ� en question: ","Afficher employ�",JOptionPane.QUESTION_MESSAGE);
						boolean trouve=false;
	    				for (int i=0; i<dep1.nbrEmploye; i++){

	                          //recherche le code identique � celui saisi
								if(codeSaisi.equals(dep1.tabEmploye[i].codeAcces())){
									//Affiche les informations de l'employe voulu (Utilisation de afficher() 
									JOptionPane.showMessageDialog(null,dep1.tabEmploye[i].afficher(),"Infos",JOptionPane.INFORMATION_MESSAGE);
									//on s'arr�te � la premi�re personne avec le code
									trouve=true;
									break;
								}
	    				}
	    				if (trouve) //Si le code a �t� trouver, sortir
	    					break;
	    				
	    				//Message pour signaler un code inexistant (ou erron�)
	    				JOptionPane.showMessageDialog(null,"Le code entr� est non existant ou erron�.","Afficher employ�",JOptionPane.QUESTION_MESSAGE);

						break;

				case 3:	//Lister employ�s : permet d�afficher la liste de tous les employ�s du d�partement contenus (Utilisation du toString() d'Employe)
					if(dep1.nbrEmploye<1){
						JOptionPane.showMessageDialog(null, "Aucun Employ�...");
						break;
					}
					
					for (int i=0; i<dep1.nbrEmploye; i++)
						//message qui contient les informations de tous les employ�s
                                                liste+=dep1.tabEmploye[i].toString()+"\n";
					//On affiche la liste
					JOptionPane.showMessageDialog(null, liste,"Liste des employ�s", JOptionPane.INFORMATION_MESSAGE);

					//On r�initialise la liste, sinon elle s'accumulera a chaque r�p�tition
					liste="";
					break;

				case 4: //AFFICHE TOUTES LES INFORMATIONS SUR DEPARTEMENT
					//Utilisation du toString() de Departement
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
