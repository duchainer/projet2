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
 *    		Ex Résultat : PDomingues98, Domingues, Patrick, 2000$ 
 * 4 - Statistiques : permet d’afficher le nom du département,
 *     	le nombre d’employés ainsi que la masse salariale et la moyenne salariale du département. 
 * 5 - Quitter : permet de terminer l’application
 * 
 * 
 * @author Raphael Duchaine
 *
 */
public class GestionEmploye {

	public static void main(String[] args) {
		int option=0;
		Departement dep1 = new Departement("Informatique");
		//menu répétitif
		do{
			//affichage du menu et saisie de l'option
			 option=Integer.parseInt(JOptionPane.showInputDialog(null,
					 "Choisir:\n 1: Enregistrer employé\n 2: Afficher employé\n 3: Lister employés\n 4: Statistiques \n 5:Quitter",
					 "Gestion des ressources Humaines\n AKA ton poste de travail",JOptionPane.QUESTION_MESSAGE));
			// les différentes options du menu
			switch(option){
				case 1:  // Demande la saisie de tous les attributs d'un employe et affiche un message de confirmation 
						if (JOptionPane.showConfirmDialog(null, "Voulez-vous enregistrer un employé?", "Enregistrement",
						        JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) 
							break;
						
					 	//création d'un objet Employe (Demande de saisie au clavier)
					 	
						break;
						
				case 2://Affiche Employé: permet d’afficher les informations d’un employé du département dont le code d’accès sera demandé au clavier
						
					//TODO Trouver Employé par code d'accès et affiché ses information par toString
					
					break;
					
				case 3://Lister employés : permet d’afficher la liste de tous les employés du département contenus (toString)
					//TODO for loop qui fait le toString des employes
					break;

				case 4://FAIT
						//AFFICHE TOUTES LES INFORMATIONS SUR DEPARTEMENT
					//toString dans departement
					JOptionPane.showMessageDialog(null, dep1.toString(), "Statistiques", JOptionPane.INFORMATION_MESSAGE);
					 break;
					 
				case 5://QUITTER(FAIT)
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
