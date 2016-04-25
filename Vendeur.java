/**
 *
 * @author Patrick Domingues 09/04/2016
 * @author2 Raphael Duchaine 12/04/2016
 */
public class Vendeur extends Employe implements Finance {

    //2 attributs supplementaires
    private int montantVentes;
    private double tauxCommission;

    //Get-Set
    public int getMontantVentes() {
        return montantVentes;
    }

    public void setMontantVentes(int montantVentes) throws Exception {
        if (0 <= montantVentes && montantVentes <= 10000) {
            this.montantVentes = montantVentes;
        } else {
            throw new Exception("Montant de ventes invalide (n'est pas entre 0 et 10000)");
        }
    }

    public double getTauxCommission() {
        return tauxCommission;
    }

    public void setTauxCommission(double tauxCommission) throws Exception {
        if (0 <= tauxCommission && tauxCommission <= 100) {
            this.tauxCommission = tauxCommission;
        } else {
            throw new Exception("Taux de commission invalide (n'est pas entre 0 et 100)");
        }
    }

    //constructeur sans parametres
    public Vendeur() throws Exception {
        super();
        setMontantVentes(0);
        setTauxCommission(0);
    }

    //constructeur avec parametres
    public Vendeur(String unNom, String unPrenom, String uneDate, int desHeures, double unTauxHoraire, int unMontantVentes, double unTauxCommission) throws Exception {
        super(unNom, unPrenom, uneDate, desHeures, unTauxHoraire);
        setMontantVentes(unMontantVentes);
        setTauxCommission(unTauxCommission);
    }
    
    //acces aux informations
    @Override
    public String afficher() {
        return "\t\tVENDEUR"
                + "\nCode d'acces: "+ codeAcces()
                + "\nNom: " + getNom()
                + "\nPrenom: " + getPrenom()
                + "\nDate de naissance(JJMMAAAA): " + getDate()
                + "\nMot de passe: " + getMotDePasse()
                + "\nHeures travaillees: " + getHeures()
                + "\nTaux horaire: "+ getTauxHoraire() + "$/heures"
                + "\nSalaire brut: "+ salaireBrut()
                + "\nMontant des ventes: "+ montantVentes
                + "\nTaux de commission: "+ tauxCommission;
    }

    @Override
    public String toString() {
        return "VENDEUR: "+codeAcces() + ", " + getNom() + ", " + getPrenom() + ", " + salaireBrut();
    }

    //Surdefinition de la methode initMotPasse()
    @Override
    public void initMotPasse() {
        super.setMotDePasse("vendeur");
    }

    //Surdefinition de la methode salaireBrut(){
    @Override
    public double salaireBrut() {
        return super.salaireBrut() + getMontantVentes() * getTauxCommission();
    }

    //Surdefinition de la methode augmenter() de l'interface Finance
    @Override
    public void augmenter() throws Exception{
    	setTauxCommission(getTauxCommission()*(1+TAUX_DEDUCTION));
    }

    //Surdefinition de la methode reduire() de l'interface Finance
    @Override
    public void reduire() throws Exception {
       setTauxCommission(getTauxCommission()*(1-TAUX_DEDUCTION));
    }

}

//Interface Finance contenant des variables finales et des methodes abstraites
interface Finance {

    final double TAUX_DEDUCTION = 0.15;
    final double TAUX_AUGMENTATION = 0.10;

    public void augmenter()throws Exception;

    public void reduire()throws Exception;

}
