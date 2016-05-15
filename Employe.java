import java.util.ArrayList;

//import javax.swing.*;

/**
 * 1- Les attributs (choisir les types appropries): -nom - prenom - date Embauche
 *  (chaine de longueur fixe, format : JJMMAAAA) - mot de passe -
 * nombre d'heures travaillees - taux horaire 2 - Dans la meme classe, definir
 * les methodes suivantes : - codeAcces() : qui retourne le code d'acces de
 * l'employe en le construisant comme suit : 1ere lettre du prenom suivi par le
 * nom complet suivi par les 2 derniers chiffres de l'annee de naissance, le
 * tout sans espace. - initMotPasse() qui reinitialise le mot de passe de
 * l'employe en lui attribuant la chaine crosemont - salaireBrut() qui calcule
 * et retourne le salaire brut de l'employe selon le nombre d'heures travaillees
 * et le taux horaire de l'employe - salaireNet(taux) qui retourne le salaire
 * apres deduction des taxes, selon le taux fourni en parametre (en
 * pourcentage).
 * 
 *@author Patrick Domingues 13/05/2016
 *@author2 Raphael Duchaine 12/04/2016
 *
*/
public class Employe implements Finance {

    //Attributs
    private String nom, prenom, date, motDePasse;
    private int heures;
    private double tauxHoraire;
    //Get-Set

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws Exception {
        if (nom.equals("")) {
            throw new Exception("Aucun nom n'a ete enregistre");
        } else {
            this.nom = nom;
        }
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) throws Exception {
        if (prenom.equals("")) {
            throw new Exception("Aucun prenom n'a ete enregistre");
        } else {
            this.prenom = prenom;
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) throws Exception {
        //Verifie si la chaine date contient 8 caracteres
        if (date.length() == 8) {
            for (int i = 0; i < date.length(); i++) {
                //Si le charactere est un chiffre, alors on ignore, sinon on lance une exception
                if (!Character.isDigit(date.charAt(i))) {
                    throw new Exception("La date ne doit etre compose que de chiffres");
                }
            }
            this.date = date;

        } else {
            throw new Exception("Le format JJMMAAAA n'a pas ete respecte");
        }
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public int getHeures() {
        return heures;
    }

    public void setHeures(int heures) throws Exception {
        if (0 <= heures && heures <= 60) {
            this.heures = heures;
        } else {
            throw new Exception("Le nombre d'heures est invalide (il n'est pas entre 0 et 60)");
        }
    }

    public double getTauxHoraire() {
        return tauxHoraire;
    }

    public void setTauxHoraire(double tauxHoraire) throws Exception {
        if (0 <= tauxHoraire && tauxHoraire <= 100) {
            this.tauxHoraire = tauxHoraire;
        } else {
            throw new Exception("Le taux horaire est invalide (il n'est pas entre 0$ et 100$)");
        }
    }

    //Constructeur : initialise le nom  "invite", et les autres parametres a  defaut
    public Employe() throws Exception{
        setNom("invite");
        setPrenom("prenom");
        setDate("00000000");
        initMotPasse();
    }

    //Constructeur avec parametres: initialise le mot de passe par "crosemont", et les autres parametres sont choisis par saisie
    public Employe(String unNom, String unPrenom, String uneDate, int desHeures, double unTauxHoraire) throws Exception {
        setNom(unNom);
        setPrenom(unPrenom);
        setDate(uneDate);
        initMotPasse();
        setHeures(desHeures);
        setTauxHoraire(unTauxHoraire);
    }

    //acces aux informations
    public String afficher() {
        return "\nCode d'acces: "+ codeAcces()
                + "\nNom: " + getNom()
                + "\nPrenom: " + getPrenom()
                + "\nDate Embauche(JJMMAAAA): " + getDate()
                + "\nMot de passe: " + getMotDePasse()
                + "\nHeures travaillees: " + getHeures()
                + " heures\nTaux horaire: "+ getTauxHoraire() + "$/heures"
                + "\nSalaire brut: "+ salaireBrut();
    }

    @Override
    public String toString() {
        return codeAcces() + " // " + getNom() + " // " + getPrenom() + " // " + salaireBrut();
    }
    public ArrayList<String> allVars() {
    	ArrayList<String> variables = new ArrayList<String>();
    	variables.add(getNom());
    	variables.add(getPrenom());
    	variables.add(getDate());
    	variables.add(Integer.toString(getHeures()));
    	variables.add(Double.toString(getTauxHoraire()));
        return variables;
    }
    //Autres methodes
    //Retourne le code d' acces de l'employe
    public String codeAcces() {
        String code = getPrenom().charAt(0) + getNom() + getDate().substring(getDate().length() - 2, getDate().length());
        return code;
    }

    //Reinitialise le mot de passe de l'employe
    public void initMotPasse() {
        setMotDePasse("crosemont");
    }

    //Calcule et retourne le salaire brut de l'employe
    public double salaireBrut() {
        return getTauxHoraire() * getHeures();
    }

    //Retourne le salaire apres deduction des taxes (taxes en pourcentage)
    public double salaireNet(double taux) {
        return salaireBrut() * (1 - taux);
    }

    //Surdefinition de la methode augmenter() de l'interface Finance
    @Override
    public void augmenter() throws Exception {
        setTauxHoraire((getTauxHoraire()* (1+TAUX_AUGMENTATION)));
    }

    //Surdefinition de la methode reduire() de l'interface Finance
    @Override
    public void reduire() throws Exception {
    	setTauxHoraire((getTauxHoraire()* (1-TAUX_DEDUCTION)));
    }

}
