/**
 *
 * @author Patrick Domingues 09/04/2016
 * @author2 Raphael Duchaine 12/04/2016
 */
public class Vendeur extends Employe implements Finance {

    //2 attributs supplémentaires
    private int montantVentes;
    private double tauxCommission;

    //Get-Set
    public int getMontantVentes() {
        return montantVentes;
    }

    public void setMontantVentes(int montantVentes) throws Exception {
        if (0 <= montantVentes || montantVentes <= 10000) {
            this.montantVentes = montantVentes;
        } else {
            throw new Exception("Montant de ventes invalide (n'est pas entre 0 et 10000)");
        }
    }

    public double getTauxCommission() {
        return tauxCommission;
    }

    public void setTauxCommission(double tauxCommission) throws Exception {
        if (0 <= tauxCommission || tauxCommission <= 100) {
            this.tauxCommission = tauxCommission;
        } else {
            throw new Exception("Taux de commission invalide (n'est pas entre 0 et 100)");
        }
    }

    //constructeur sans paramètres
    public Vendeur() throws Exception {
        super();
        setMontantVentes(0);
        setTauxCommission(0);
    }

    //constructeur avec paramètres
    public Vendeur(String unNom, String unPrenom, String uneDate, int desHeures, double unTauxHoraire, int unMontantVentes, double unTauxCommission) throws Exception {
        super(unNom, unPrenom, uneDate, desHeures, unTauxHoraire);
        setMontantVentes(unMontantVentes);
        setTauxCommission(unTauxCommission);
    }
    
    //accès aux informations
    @Override
    public String afficher() {
        return "\t\tVENDEUR"
                + "\nCode d'accès: "+ codeAcces()
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
        return "VENDEUR: "+codeAcces() + ", " + getNom() + ", " + getPrenom() + ", " + salaireBrut();
    }

    //Surdéfinition de la méthode initMotPasse()
    @Override
    public void initMotPasse() {
        super.setMotDePasse("vendeur");
    }

    //Surdéfinition de la méthode salaireBrut(){
    @Override
    public double salaireBrut() {
        return super.salaireBrut() + getMontantVentes() * getTauxCommission();
    }

    //Surdéfinition de la méthode augmenter() de l'interface Finance
    @Override
    public double augmenter() {
        return getTauxCommission() + TAUX_AUGMENTATION;
    }

    //Surdéfinition de la méthode reduire() de l'interface Finance
    @Override
    public double reduire() {
        return getTauxCommission() - TAUX_DEDUCTION;
    }

}

//Interface Finance contenant des variables finales et des méthodes abstraites
interface Finance {

    final double TAUX_DEDUCTION = 0.15;
    final double TAUX_AUGMENTATION = 0.10;

    public double augmenter();

    public double reduire();

}
