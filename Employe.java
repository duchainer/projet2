import javax.swing.*;
/**
*1- Les attributs (choisir les types appropriés):
* -nom
* - prenom
* - date de naissance (chaine de longueur fixe, format : JJMMAAAA)
* - mot de passe
* - nombre d'heures travaillées
* - taux horaire
*2 - Dans la même classe, définir les méthodes suivantes :
* - codeAcces() : qui retourne le code d'accès de l'employé en le construisant comme suit : 1ère lettre du prénom suivi par le nom complet suivi par les 2 derniers chiffres de l'année de naissance, le tout sans espace.
* - initMotPasse() qui réinitialise le mot de passe de l'employé en lui attribuant la chaine crosemont
* - salaireBrut() qui calcule et retourne le salaire brut de l'employé selon le nombre d'heures travaillées et le taux horaire de l'employé
* - salaireNet(taux) qui retourne le salaire après déduction des taxes, selon le taux fourni en paramètre (en pourcentage).
*
* @author Patrick Domingues 24/02/2016
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
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
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
    public void setHeures(int heures) {
        this.heures = heures;
    }
    
    public double getTauxHoraire() {
        return tauxHoraire;
    }
    public void setTauxHoraire(double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }
    
    //Constructeur : initialise le nom  "invité", et les autres paramètres a  défaut
    public Employe(){
        setNom("invité");
        setPrenom("");
        setDate("");
        setMotDePasse("");
    }
    
    //Constructeur avec paramètres: initialise le mot de passe par "crosemont", et les autres paramètres sont choisis par saisie
    public Employe(String unNom, String unPrenom, String uneDate, int desHeures, double unTauxHoraire){
        setNom(unNom);
        setPrenom(unPrenom);
        setDate(uneDate);
        initMotPasse();
        setHeures(desHeures);
        setTauxHoraire(unTauxHoraire);
        }
    
    //accès aux informations
    public String afficher(){
        return " heures\nTaux horaire: "+
                codeAcces()+
                "\nNom: "+getNom()+
                "\nPrénom: "+getPrenom()+
                "\nDate de naissance(JJ/MM/AAAA): "+getDate()+
                "\nMot de passe: "+getMotDePasse()+
                "\nheures: "+getHeures()+getTauxHoraire()+"$/heures";
    }
    
    @Override
    public String toString(){
        return codeAcces()+", "+getNom()+", "+getPrenom()+", "+salaireBrut();
    }
    
    //Autres méthodes
    //Retourne le code d' accès de l'employé
    public String codeAcces(){
        String code= getPrenom().charAt(0) + getNom() + getDate().substring(getDate().length()-2, getDate().length());
        return code ;
    }
    
    //Réinitialise le mot de passe de l'employé
    public void initMotPasse(){
        setMotDePasse("crosemont");
    }
    
    //Calcule et retourne le salaire brut de l'employé
    public double salaireBrut(){
        return getTauxHoraire() * getHeures();
    }
    
    //Retourne le salaire après déduction des taxes (taxes en pourcentage)
    public double salaireNet(double taux){
        return salaireBrut()*(1-taux);
    }
    
    //Surdéfinition de la méthode augmenter() de l'interface Finance
    @Override
    public double augmenter(){
        return getTauxHoraire() + TAUX_AUGMENTATION;
    }
    
    //Surdéfinition de la méthode reduire() de l'interface Finance
    @Override
    public double reduire(){
        return getTauxHoraire() - TAUX_DEDUCTION;
    }    
        
        
    //main (sert uniquement a tester)
    public static void main(String[] args){
        Employe employe = new Employe(JOptionPane.showInputDialog(null,"Veuillez entrer votre nom: "),
        JOptionPane.showInputDialog(null,"Veuillez entrer votre prenom: "),
        JOptionPane.showInputDialog(null,"Veuillez entrer votre date de naissance (en format JJMMAAAA): "),
        Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez entrer votre nombre d'heures travaillées: ")),
        Double.parseDouble(JOptionPane.showInputDialog(null,"Veuillez entrer votre salaire horaire: ")));
        JOptionPane.showMessageDialog(null, employe.codeAcces());
        JOptionPane.showMessageDialog(null, employe.toString());
    }
}