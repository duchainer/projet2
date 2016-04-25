import javax.swing.JOptionPane;

/**
 * C - Dans le fichier GestionEmploye.java, definir la classe principale GestionEmploye ,
 * avec un main() dans lequel :
 * - Un objet departement est cree avec un nom fixe (non demande) de votre choix,
 * et avec aucun employe au depart ,
 * puis un menu repetitif offre les options suivantes :
 * 1 - Enregistrer employe : un objet Employe est cree avec les valeurs lues au clavier , 
 *      cet objet sera place dans le tableau d' employes du departement.
 *      Un message confirmera l'enregistrement de l'employe en affichant son code d'acces.
 * 2 - Afficher employe : permet d'afficher les informations d'un employe du
 *      departement dont le code d'acces sera demande au clavier 
 * 3 - Lister employes: permet d'afficher la liste de tous les employes du departement contenus
 *      dans le tableau, leur nom, prenom, et salaires brut, un employe par ligne
 *      (Utilise Employe.toString()) 
 *      Exemple de Resultat : PDomingues98, Domingues, Patrick, 2000$
 * 4 - Statistiques : permet d'afficher le nom du departement, le
 *      nombre d'employes ainsi que la masse salariale et la moyenne salariale du
 *      departement. 
 * 5 - Quitter : permet de terminer l'application
 *
 * @author Raphael Duchaine 10/04/2016
 * @author2 Patrick Domingues 09/04/2016
 */
public class GestionEmploye {

    public static void main(String[] args) {

        //Initialisation des variables
        String liste = "", codeSaisi = "";
        int option = 0;
        //Declaration et creation de l'objet departement
        Departement dep1 = new Departement("Informatique");
        dep1.setNbrEmploye(0);
        //menu repetitif
        do {
            //affichage du menu et saisie de l'option
            option = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Choisir:\n 1: Enregistrer employe\n 2: Afficher employe\n 3: Lister employes\n 4: Statistiques \n 5: Quitter",
                    "Gestion des ressources Humaines\n AKA ton poste de travail", JOptionPane.QUESTION_MESSAGE));

            // les differentes options du menu
            switch (option) {
                case 1:  // Demande la saisie de tous les attributs d'un employe et affiche un message de confirmation
                    if (dep1.getNbrEmploye() >= dep1.getMAX()) {
                        JOptionPane.showMessageDialog(null, "Il y a deja  20 employes (C'est le maximum)", "Enregistrer un employe DE TROP", JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    if (JOptionPane.showConfirmDialog(null, "Voulez-vous enregistrer un employe?", "Enregistrement",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                        break;
                    }

                    //creation de l'objet Employe dans une nouvelle case du tableau tabEmploye
                    try {
                        String nom = JOptionPane.showInputDialog(null, "Nom de famille de l'employe?: ", "Enregistrer employe", JOptionPane.QUESTION_MESSAGE);
                        String prenom = JOptionPane.showInputDialog(null, "Prenom de l'employe?: ", "Enregistrer employe", JOptionPane.QUESTION_MESSAGE);
                        String date = JOptionPane.showInputDialog(null, "Date de naissance de l'employe?(en format JJMMAAAA): ", "Enregistrer employe", JOptionPane.QUESTION_MESSAGE);
                        //NOTE: La date de naissance de l'employe dois avoir la forme requise, sinon ca ne marche pas (a  cause du substring dans Employe)
                        int heures =Integer.parseInt(JOptionPane.showInputDialog(null, "Nombre d'heures travaillees par l'employe?: ", "Enregistrer employe", JOptionPane.QUESTION_MESSAGE));
                        double tauxHeure = Double.parseDouble(JOptionPane.showInputDialog(null, "Taux horaire de l'employe?: ", "Enregistrer employe", JOptionPane.QUESTION_MESSAGE));
                        
                        if (JOptionPane.showConfirmDialog(null, "Cet employe est-il un VENDEUR?", "Enregistrement",
                                JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                            dep1.setTabEmploye(dep1.getNbrEmploye(), new Employe(nom,prenom,date,heures,tauxHeure));
                            JOptionPane.showMessageDialog(null, "Compte enregistre: " + dep1.getTabEmploye(dep1.getNbrEmploye()).codeAcces(),
                                    "Enregistrer un employe", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            /*montantVentes : le montant des ventes effectuees par le vendeur
                              tauxCommission: le taux de la commission sur les ventes, en pourcentage*/
                            int montantVente =Integer.parseInt(JOptionPane.showInputDialog(null, "Montant des ventes fait par l'employe?: ", "Enregistrer employe", JOptionPane.QUESTION_MESSAGE));
                            double tauxCommission = Double.parseDouble(JOptionPane.showInputDialog(null, "Taux de commission de l'employe?: ", "Enregistrer employe", JOptionPane.QUESTION_MESSAGE));
                            
                            dep1.setTabEmploye(dep1.getNbrEmploye(), new Vendeur(nom,prenom,date,heures,tauxHeure,montantVente,tauxCommission));
                            JOptionPane.showMessageDialog(null, "Compte VENDEUR enregistre: " + dep1.getTabEmploye(dep1.getNbrEmploye()).codeAcces(),
                                    "Enregistrer un employe", JOptionPane.INFORMATION_MESSAGE);
                        }
                        //prend en compte le nouveau nombre d'employes 
                        dep1.setNbrEmploye(dep1.getNbrEmploye() + 1);
                        
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
                    }

                    break;

                case 2:	//Affiche Employe: permet d'afficher les informations d'un employe du departement dont le code d'acces sera demande au clavier

                    //Saisie du code a  recherche
                    codeSaisi = JOptionPane.showInputDialog(null, "Veillez entrer le Code d'acces de l'employe en question: ", "Afficher employe", JOptionPane.QUESTION_MESSAGE);
                    boolean trouve = false;
                    for (int i = 0; i < dep1.getNbrEmploye(); i++) {

                        //recherche le code identique a  celui saisi
                        if (codeSaisi.equals(dep1.getTabEmploye(i).codeAcces())) {
                            //Affiche les informations de l'employe voulu (Utilisation de afficher() 
                            JOptionPane.showMessageDialog(null, dep1.getTabEmploye(i).afficher(), "Infos", JOptionPane.INFORMATION_MESSAGE);
                            //on s'arrete a  la premiere personne avec le code
                            trouve = true;
                            break;
                        }
                    }
                    if (trouve) //Si le code a ete trouver, sortir
                    {
                        break;
                    }

                    //Message pour signaler un code inexistant (ou errone)
                    JOptionPane.showMessageDialog(null, "Le code entre est non existant ou errone.", "Afficher employe", JOptionPane.QUESTION_MESSAGE);

                    break;

                case 3:	//Lister employes : permet d'afficher la liste de tous les employes du departement contenus (Utilisation du toString() d'Employe)
                    if (dep1.getNbrEmploye() < 1) {
                        JOptionPane.showMessageDialog(null, "Aucun Employe...");
                        break;
                    }

                    for (int i = 0; i < dep1.getNbrEmploye(); i++) //message qui contient les informations de tous les employes
                    {
                        liste += dep1.getTabEmploye(i).toString() + "\n";
                    }
                    //On affiche la liste
                    JOptionPane.showMessageDialog(null, liste, "Liste des employes", JOptionPane.INFORMATION_MESSAGE);

                    //On reinitialise la liste, sinon elle s'accumulera a chaque repetition
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
                            "Se Sauver de ses responsabilites", JOptionPane.YES_NO_OPTION);
                    if (reponse == JOptionPane.YES_OPTION) {
                        break;
                    } else {
                        option = 0;
                        break;
                    }

                default:
                    JOptionPane.showMessageDialog(null, "Hey, le Nouveau! \nFais attention, tu mets le departement en danger!");
            }//fin switch

        } while (option != 5);

    }

}
