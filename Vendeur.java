/**
 *
 * @author usager
 */
public class Vendeur extends Employe implements Finance{
    //2 attributs supplémentaires
    private int montantVentes ;
    private double tauxCommission ;
    
    //Get-Set
    public int getMontantVentes() {
        return montantVentes;
    }
    public void setMontantVentes(int unMontantVentes) {
        this.montantVentes = unMontantVentes;
    }
    public double getTauxCommission() {
        return tauxCommission;
    }
    public void setTauxCommission(double unTauxCommission) {
        this.tauxCommission = unTauxCommission;
    }
    
    //constructeur sans paramètres
    public Vendeur(){
        super();
        setMontantVentes(0);
        setTauxCommission(0);
        }
    
    //constructeur avec paramètres
    public Vendeur(String unNom, String unPrenom, String uneDate, int desHeures, double unTauxHoraire, int unMontantVentes, double unTauxCommission){
        super(unNom, unPrenom, uneDate, desHeures, unTauxHoraire);
        setMontantVentes(unMontantVentes);
        setTauxCommission(unTauxCommission);
    }
    //Surdéfinition de la méthode initMotPasse()
    @Override
    public void initMotPasse(){
        super.setMotDePasse("vendeur");
    }
    
    //Surdéfinition de la méthode salaireBrut(){
    @Override
    public double salaireBrut(){
        return super.salaireBrut() + getMontantVentes() * getTauxCommission();
    }
    
    //Surdéfinition de la méthode augmenter() de l'interface Finance
    @Override
    public double augmenter(){
        return getTauxCommission() + TAUX_AUGMENTATION;
    }
    
    //Surdéfinition de la méthode reduire() de l'interface Finance
    @Override
    public double reduire(){
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
