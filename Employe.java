import javax.swing.*;

/**
 * 1- Les attributs (choisir les types appropriés): -nom - prenom - date de
 * naissance (chaine de longueur fixe, format : JJMMAAAA) - mot de passe -
 * nombre d'heures travaillées - taux horaire 2 - Dans la même classe, définir
 * les méthodes suivantes : - codeAcces() : qui retourne le code d'accès de
 * l'employé en le construisant comme suit : 1ère lettre du prénom suivi par le
 * nom complet suivi par les 2 derniers chiffres de l'année de naissance, le
 * tout sans espace. - initMotPasse() qui réinitialise le mot de passe de
 * l'employé en lui attribuant la chaine crosemont - salaireBrut() qui calcule
 * et retourne le salaire brut de l'employé selon le nombre d'heures travaillées
 * et le taux horaire de l'employé - salaireNet(taux) qui retourne le salaire
 * après déduction des taxes, selon le taux fourni en paramètre (en
 * pourcentage).
 * 
 *@author Patrick Domingues 10/04/2016
 *@author2 Raphael Duchaine 12/04/2016
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
            throw new Exception("Aucun nom n'a été enregistré");
        } else {
            this.nom = nom;
        }
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) throws Exception {
        if (prenom.equals("")) {
            throw new Exception("Aucun prénom n'a été enregistré");
        } else {
            this.prenom = prenom;
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) throws Exception {
        //Vérifie si la chaine date contient 8 caractères
        if (date.length() == 8) {
            for (int i = 0; i < date.length(); i++) {
                //Si le charactère est un chiffre, alors on ignore, sinon on lance une exception
                if (Character.isDigit(date.charAt(i))) {
                } else {
                    throw new Exception("La date ne doit être composé que de chiffres");
                }
            }
            this.date = date;

        } else {
            throw new Exception("Le format JJMMAAAA n'a pas été respecté");
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

    //Constructeur : initialise le nom  "invité", et les autres paramètres a  défaut
    public Employe() throws Exception {
        setNom("invité");
        setPrenom("prenom");
        setDate("00000000");
        initMotPasse();
    }

    //Constructeur avec paramètres: initialise le mot de passe par "crosemont", et les autres paramètres sont choisis par saisie
    public Employe(String unNom, String unPrenom, String uneDate, int desHeures, double unTauxHoraire) throws Exception {
        setNom(unNom);
        setPrenom(unPrenom);
        setDate(uneDate);
        initMotPasse();
        setHeures(desHeures);
        setTauxHoraire(unTauxHoraire);
    }

    //accès aux informations
    public String afficher() {
        return "\nCode d'accès: "+ codeAcces()
                + "\nNom: " + getNom()
                + "\nPrénom: " + getPrenom()
                + "\nDate de naissance(JJ/MM/AAAA): " + getDate()
                + "\nMot de passe: " + getMotDePasse()
                + "\nHeures travaillées: " + getHeures()
                + "\nTaux horaire: "+ getTauxHoraire() + "$/heures"
                + "\nSalaire brut: "+ salaireBrut();
    }

    @Override
    public String toString() {
        return "         "+codeAcces() + ", " + getNom() + ", " + getPrenom() + ", " + salaireBrut();
    }

    //Autres méthodes
    //Retourne le code d' accès de l'employé
    public String codeAcces() {
        String code = getPrenom().charAt(0) + getNom() + getDate().substring(getDate().length() - 2, getDate().length());
        return code;
    }

    //Réinitialise le mot de passe de l'employé
    public void initMotPasse() {
        setMotDePasse("crosemont");
    }

    //Calcule et retourne le salaire brut de l'employé
    public double salaireBrut() {
        return getTauxHoraire() * getHeures();
    }

    //Retourne le salaire après déduction des taxes (taxes en pourcentage)
    public double salaireNet(double taux) {
        return salaireBrut() * (1 - taux);
    }

    //Surdéfinition de la méthode augmenter() de l'interface Finance
    @Override
    public double augmenter() {
        return getTauxHoraire() + TAUX_AUGMENTATION;
    }

    //Surdéfinition de la méthode reduire() de l'interface Finance
    @Override
    public double reduire() {
        return getTauxHoraire() - TAUX_DEDUCTION;
    }

    //main (sert uniquement a tester)
    public static void main(String[] args) {
        try {
            Employe employe = new Employe(JOptionPane.showInputDialog(null, "Veuillez entrer votre nom: "),
                    JOptionPane.showInputDialog(null, "Veuillez entrer votre prenom: "),
                    JOptionPane.showInputDialog(null, "Veuillez entrer votre date de naissance (en format JJMMAAAA): "),
                    Integer.parseInt(JOptionPane.showInputDialog(null, "Veuillez entrer votre nombre d'heures travaillées: ")),
                    Double.parseDouble(JOptionPane.showInputDialog(null, "Veuillez entrer votre salaire horaire: ")));

            Vendeur vendeur = new Vendeur(JOptionPane.showInputDialog(null, "Veuillez entrer votre nom: "),
                    JOptionPane.showInputDialog(null, "Veuillez entrer votre prenom: "),
                    JOptionPane.showInputDialog(null, "Veuillez entrer votre date de naissance (en format JJMMAAAA): "),
                    Integer.parseInt(JOptionPane.showInputDialog(null, "Veuillez entrer votre nombre d'heures travaillées: ")),
                    Double.parseDouble(JOptionPane.showInputDialog(null, "Veuillez entrer votre salaire horaire: ")),
                    Integer.parseInt(JOptionPane.showInputDialog(null, "Veuillez entrer votre montant de ventes: ")),
                    Double.parseDouble(JOptionPane.showInputDialog(null, "Veuillez entrer votre taux de commission: ")));

            JOptionPane.showMessageDialog(null, employe.codeAcces());
            JOptionPane.showMessageDialog(null, "toString de l'employe: " + employe.toString());

            JOptionPane.showMessageDialog(null, vendeur.codeAcces());
            JOptionPane.showMessageDialog(null, "toString du vendeur: " + vendeur.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
