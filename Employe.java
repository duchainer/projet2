import javax.swing.*;
/**
 *1- Les attributs (choisir les types appropri�s):
 * -nom
 * - prenom
 * - date de naissance (chaine de longueur fixe, format : JJMMAAAA)
 * - mot de passe
 * - nombre d'heures travaill�es
 * - taux horaire
 *2 - Dans la m�me classe, d�finir les m�thodes suivantes :
 * - codeAcces() : qui retourne le code d'acc�s de l'employe en le construisant comme suit : 1�re lettre du pr�nom suivi par le nom complet suivi par les 2 derniers chiffres de l'ann�e de naissance, le tout sans espace.
 * - initMotPasse() qui r�initialise le mot de passe de l'employ� en lui attribuant la chaine crosemont
 * - salaireBrut() qui calcule et retourne le salaire brut de l'employ� selon le nombre d'heures travaill�es et le taux horaire de l'employ�
 * - salaireNet(taux) qui retourne le salaire apr�s d�duction des taxes, selon le taux fourni en param�tre (en pourcentage).
 *
 * @author Patrick Domingues 24/02/2016
 *
 */
public class Employe {
	//Attributs
    String nom, prenom, date, mdp;
    int heures;
    double tauxHoraire;

    //Retourne le code d'�acc�s de l'employ�
    public String codeAcces(){
        String code= prenom.charAt(0) + nom + date.substring(date.length()-2, date.length());
        return code ;
    }

    //R�initialise le mot de passe de l'employ�
    public void initMotPasse(){
    	mdp = "crosemont";
    }

    //Calcule et retourne le salaire brut de l'employ�
    public double salaireBrut(){
        return tauxHoraire * heures;
    }

    //Retourne le salaire apr�s d�duction des taxes (taxes en pourcentage)
    public double salaireNet(double taux){
        return salaireBrut()*(1-taux);
    }

    //Constructeur : initialise le nom �"invit�", et les autres param�tres a� d�faut
    public Employe(){
     	nom = "invit�";
		prenom = "";
        date = "";
        mdp= "";
     }

	//Constructeur avec param�tres: initialise le mot de passe par�"crosemont", et les autres param�tres sont choisis par saisie
	public Employe(String unNom, String unPrenom, String uneDate, int desHeures, double unTauxHoraire){
	 	nom = unNom;
		prenom = unPrenom;
        date = uneDate;
	 	mdp = "crosemont";
	 	heures = desHeures;
	 	tauxHoraire = unTauxHoraire;

	 }

	public String afficher(){
		return codeAcces()+
				"\nNom: "+nom+
				"\nPr�nom: "+prenom+
				"\nDate de naissance: "+date+
				"\nMot de passe: "+mdp+""+
				"\nheures: "+heures+
				"\nTaux horaire: "+tauxHoraire;
		
	}
	@Override
	public String toString(){
		return codeAcces()+", "+nom+", "+prenom+", "+salaireBrut();

	}


	//main (sert uniquement a tester)
	public static void main(String[] args){

		Employe employe = new Employe(JOptionPane.showInputDialog(null,"Veuillez entrer votre nom: "),
		JOptionPane.showInputDialog(null,"Veuillez entrer votre prenom: "),
		JOptionPane.showInputDialog(null,"Veuillez entrer votre date de naissance (en format JJ/MM/AAAA): "),
		Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez entrer votre nombre d'heures travaill�s: ")),
		Double.parseDouble(JOptionPane.showInputDialog(null,"Veuillez entrer votre salaire horaire: ")));

		JOptionPane.showMessageDialog(null, employe.codeAcces());
		JOptionPane.showMessageDialog(null, employe.toString());

	}

}
