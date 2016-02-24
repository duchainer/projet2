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
		int option=0;
		Departement dep1 = new Departement("Informatique");
		//menu r�p�titif
		do{
			//affichage du menu et saisie de l'option
			 option=Integer.parseInt(JOptionPane.showInputDialog(null,
					 "Choisir:\n 1: Enregistrer employ�\n 2: Afficher employ�\n 3: Lister employ�s\n 4: Statistiques \n 5:Quitter",
					 "Gestion des ressources Humaines\n AKA ton poste de travail",JOptionPane.QUESTION_MESSAGE));
			// les diff�rentes options du menu
			switch(option){
				case 1:  // Demande la saisie de tous les attributs d'un employe et affiche un message de confirmation 
						if (JOptionPane.showConfirmDialog(null, "Voulez-vous enregistrer un employ�?", "Enregistrement",
						        JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) 
							break;
						
					 	//cr�ation d'un objet Employe (Demande de saisie au clavier)
					 	
						break;
						
				case 2://Affiche Employ�: permet d�afficher les informations d�un employ� du d�partement dont le code d�acc�s sera demand� au clavier
						
					//TODO Trouver Employ� par code d'acc�s et affich� ses information par toString
					
					break;
					
				case 3://Lister employ�s : permet d�afficher la liste de tous les employ�s du d�partement contenus (toString)
					//TODO for loop qui fait le toString des employes
					break;

				case 4://FAIT
						//AFFICHE TOUTES LES INFORMATIONS SUR DEPARTEMENT
					//toString dans departement
					JOptionPane.showMessageDialog(null, dep1.toString(), "Statistiques", JOptionPane.INFORMATION_MESSAGE);
					 break;
					 
				case 5://QUITTER(FAIT)
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
