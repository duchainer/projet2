import javax.swing.JOptionPane;

/**
 * C - Dans le fichier GestionEmploye.java, définir la classe principale GestionEmploye ,
 * avec un main() dans lequel :
 * - Un objet département est créé avec un nom fixe (non demandé) de votre choix,
 * et avec aucun employé au départ ,
 * puis un menu répétitif offre les options suivantes :
 * 1 - Enregistrer employé : un objet Employé est créé avec les valeurs lues au clavier , 
 *      cet objet sera placé dans le tableau d’ employés du département.
 *      Un message confirmera l’enregistrement de l’employé en affichant son code d’accès.
 * 2 - Afficher employé : permet d’afficher les informations d’un employé du
 *      département dont le code d’accès sera demandé au clavier 
 * 3 - Lister employés: permet d’afficher la liste de tous les employés du département contenus
 *      dans le tableau, leur nom, prénom, et salaires brut, un employé par ligne
 *      (Utilise Employe.toString()) 
 *      Exemple de Résultat : PDomingues98, Domingues, Patrick, 2000$
 * 4 - Statistiques : permet d’afficher le nom du département, le
 *      nombre d’employés ainsi que la masse salariale et la moyenne salariale du
 *      département. 
 * 5 - Quitter : permet de terminer l’application
 *
 * @author Raphael Duchaine 10/04/2016
 * @author2 Patrick Domingues 09/04/2016
 */
public class GestionEmploye {

    public static void main(String[] args) {

        //Initialisation des variables
        String liste = "", codeSaisi = "";
        int option = 0;
        //Déclaration et création de l'objet département
        Departement dep1 = new Departement("Informatique");
        dep1.setNbrEmploye(0);
        //menu répétitif
        do {
            //affichage du menu et saisie de l'option
            option = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Choisir:\n 1: Enregistrer employé\n 2: Afficher employé\n 3: Lister employés\n 4: Statistiques \n 5: Quitter",
                    "Gestion des ressources Humaines\n AKA ton poste de travail", JOptionPane.QUESTION_MESSAGE));

            // les différentes options du menu
            switch (option) {
                case 1:  // Demande la saisie de tous les attributs d'un employe et affiche un message de confirmation
                    if (dep1.getNbrEmploye() >= dep1.getMAX()) {
                        JOptionPane.showMessageDialog(null, "Il y a déjà 20 employés (C'est le maximum)", "Enregistrer un employé DE TROP", JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    if (JOptionPane.showConfirmDialog(null, "Voulez-vous enregistrer un employé?", "Enregistrement",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                        break;
                    }

                    //création de l'objet Employe dans une nouvelle case du tableau tabEmploye
                    try {
                        String nom = JOptionPane.showInputDialog(null, "Nom de famille de l'employé?: ", "Enregistrer employé", JOptionPane.QUESTION_MESSAGE);
                        String prenom = JOptionPane.showInputDialog(null, "Prénom de l'employé?: ", "Enregistrer employé", JOptionPane.QUESTION_MESSAGE);
                        String date = JOptionPane.showInputDialog(null, "Date de naissance de l'employé?(en format JJMMAAAA): ", "Enregistrer employé", JOptionPane.QUESTION_MESSAGE);
                        //NOTE: La date de naissance de l'employe dois avoir la forme requise, sinon ça ne marche pas (à cause du substring dans Employe)
                        int heures =Integer.parseInt(JOptionPane.showInputDialog(null, "Nombre d'heures travaillées par l'employé?: ", "Enregistrer employé", JOptionPane.QUESTION_MESSAGE));
                        double tauxHeure = Double.parseDouble(JOptionPane.showInputDialog(null, "Taux horaire de l'employé?: ", "Enregistrer employé", JOptionPane.QUESTION_MESSAGE));
                        
                        if (JOptionPane.showConfirmDialog(null, "Cet employé est-il un VENDEUR?", "Enregistrement",
                                JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                            dep1.setTabEmploye(dep1.getNbrEmploye(), new Employe(nom,prenom,date,heures,tauxHeure));
                            JOptionPane.showMessageDialog(null, "Compte enregistré: " + dep1.getTabEmploye(dep1.getNbrEmploye()).codeAcces(),
                                    "Enregistrer un employé", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            /*montantVentes : le montant des ventes effectuées par le vendeur
                              tauxCommission: le taux de la commission sur les ventes, en pourcentage*/
                            int montantVente =Integer.parseInt(JOptionPane.showInputDialog(null, "Montant des ventes fait par l'employé?: ", "Enregistrer employé", JOptionPane.QUESTION_MESSAGE));
                            double tauxCommission = Double.parseDouble(JOptionPane.showInputDialog(null, "Taux de commission de l'employé?: ", "Enregistrer employé", JOptionPane.QUESTION_MESSAGE));
                            
                            dep1.setTabEmploye(dep1.getNbrEmploye(), new Vendeur(nom,prenom,date,heures,tauxHeure,montantVente,tauxCommission));
                            JOptionPane.showMessageDialog(null, "Compte VENDEUR enregistré: " + dep1.getTabEmploye(dep1.getNbrEmploye()).codeAcces(),
                                    "Enregistrer un employé", JOptionPane.INFORMATION_MESSAGE);
                        }
                        //prend en compte le nouveau nombre d'employes 
                        dep1.setNbrEmploye(dep1.getNbrEmploye() + 1);
                        
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
                    }

                    break;

                case 2:	//Affiche Employé: permet d’afficher les informations d’un employé du département dont le code d’accès sera demandé au clavier

                    //Saisie du code à recherche
                    codeSaisi = JOptionPane.showInputDialog(null, "Veillez entrer le Code d'accès de l'employé en question: ", "Afficher employé", JOptionPane.QUESTION_MESSAGE);
                    boolean trouve = false;
                    for (int i = 0; i < dep1.getNbrEmploye(); i++) {

                        //recherche le code identique à celui saisi
                        if (codeSaisi.equals(dep1.getTabEmploye(i).codeAcces())) {
                            //Affiche les informations de l'employe voulu (Utilisation de afficher() 
                            JOptionPane.showMessageDialog(null, dep1.getTabEmploye(i).afficher(), "Infos", JOptionPane.INFORMATION_MESSAGE);
                            //on s'arrête à la première personne avec le code
                            trouve = true;
                            break;
                        }
                    }
                    if (trouve) //Si le code a été trouver, sortir
                    {
                        break;
                    }

                    //Message pour signaler un code inexistant (ou erroné)
                    JOptionPane.showMessageDialog(null, "Le code entré est non existant ou erroné.", "Afficher employé", JOptionPane.QUESTION_MESSAGE);

                    break;

                case 3:	//Lister employés : permet d’afficher la liste de tous les employés du département contenus (Utilisation du toString() d'Employe)
                    if (dep1.getNbrEmploye() < 1) {
                        JOptionPane.showMessageDialog(null, "Aucun Employé...");
                        break;
                    }

                    for (int i = 0; i < dep1.getNbrEmploye(); i++) //message qui contient les informations de tous les employés
                    {
                        liste += dep1.getTabEmploye(i).toString() + "\n";
                    }
                    //On affiche la liste
                    JOptionPane.showMessageDialog(null, liste, "Liste des employés", JOptionPane.INFORMATION_MESSAGE);

                    //On réinitialise la liste, sinon elle s'accumulera a chaque répétition
                    liste = "";
                    break;

                case 4: //AFFICHE TOUTES LES INFORMATIONS SUR DEPARTEMENT
                    //Utilisation du toString() de Departement

                    try {
                        JOptionPane.showMessageDialog(null, dep1.toString(), "Statistiques", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 5://QUITTER
                    //Option avec oui/non pour quitter le programme
                    int reponse = JOptionPane.showConfirmDialog(null, "Le metier de gestionnaire te fait peur?",
                            "Se Sauver de ses responsabilités", JOptionPane.YES_NO_OPTION);
                    if (reponse == JOptionPane.YES_OPTION) {
                        break;
                    } else {
                        option = 0;
                        break;
                    }

                default:
                    JOptionPane.showMessageDialog(null, "Hey, le Nouveau! \nFais attention, tu mets le département en danger!");
            }//fin switch

        } while (option != 5);

    }

}
