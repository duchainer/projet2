/**
 * B - Dans le fichier Departement.java, definir la classe Departement
 *
 * 1 - Les attributs (choisir les types appropries): - nom departement - nombre
 * d'employes - tableau d'employes (20 au max) Definir un main() et faire des
 * tests au fur et a mesure, dans lequel vous creerez un objet de cette classe
 * et affichez ses informations, avec les donnees de votre choix. 2 - Les
 * methodes - masseSalariale() : retourne le total des salaires bruts de tous
 * les employes figurant dans le tableau d'employes - moyenne Salariale() :
 * retourne la moyenne des salaires bruts de tous les employes figurant dans le
 * tableau d'employes
 *
 * @author Raphael Duchaine 09/04/2016
 *
 *
 */
import java.util.*;
public class Departement {

	//Attributs
	private final int MAX = 20;
	private String nomDepartement;
	private int nbrEmploye;
	private List<Employe> tabEmploye = new ArrayList<Employe>();

	public int getMAX() {
		return MAX;
	}

	public String getNomDepartement() {
		return nomDepartement;
	}

	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}

	public int getNbrEmploye() {
		return nbrEmploye;
	}

	public void setNbrEmploye(int nbrEmploye) {
		this.nbrEmploye = nbrEmploye;
	}
	//Modification avec ArrayList
	public Employe getTabEmploye(int i) {
		return tabEmploye.get(i);
	}
	//Modification avec ArrayList
	public void setTabEmploye(int i, Employe employe) {
		this.tabEmploye.add(i, employe);
	}
	public List<Employe> getTab() {
		return tabEmploye;
	}

	//Constructeurs	
	public Departement() {
		this.setNomDepartement("Departement par defaut");
	}

	//Constructeur demandant le nom du departement
	public Departement(String nomDepartement) {
		this.setNomDepartement(nomDepartement);
	}
	//toString

	@Override
	public String toString() {
		try {
			return getNomDepartement() + ": " + getNbrEmploye() + " Employes \n Masse Salariale: " + masseSalariale() + "\n Moyenne Salariale: " + moyenneSalariale();
		} catch (Exception e) {
			throw new ArithmeticException(e.getMessage());
		}
	}

	//Autres Methodes
	//Calcul de la masse salariale
	public double masseSalariale() {
		double masse = 0;
		for (int i = 0; i < getNbrEmploye(); i++) {
			masse += getTabEmploye(i).salaireBrut();
		}

		return masse;
	}//Calcul de la moyenne salariale 

	public double moyenneSalariale() throws Exception {
		try {
			return masseSalariale() / getNbrEmploye();
		} catch (Exception e) {
			throw new ArithmeticException("Il n'y a pas d'employes!!");
		}
	}

	//Methode permettant d'ajouter un employe au bout de tabEmploye
	public void addEmploye(String nom, String prenom, String date, int heures, double salaireEmploye) throws Exception {
		setTabEmploye(getNbrEmploye(), new Employe(nom, prenom, date, heures, salaireEmploye));
		setNbrEmploye(getNbrEmploye() + 1);
	}

	public void addVendeur(String nom, String prenom, String date, int heures, double salaireEmploye, int montantVente, double tauxCommission ) throws Exception {
		setTabEmploye(getNbrEmploye(), new Vendeur(nom, prenom, date, heures, salaireEmploye, montantVente, tauxCommission));
		setNbrEmploye(getNbrEmploye() + 1);
	}
	//methode qui affiche les elements du tableau dans une ligne
	public void  afficher(List<Employe> tabEmploye2){
		for (int i=0; i<tabEmploye2.size(); i++)
			System.out.print(tabEmploye2.get(i).codeAcces()+"  ");
		System.out.println();
	}
	
	//Comparator stockant la methode de compararaison par nom
	public static Comparator<Employe> COMPARE_BY_NAME = new Comparator<Employe>() {
        public int compare(Employe one, Employe other) {
            return one.getNom().compareTo(other.getNom());
        }
    };



	//Methode qui retourne un employe du departement ayant le code specifie en parametre, ou null s il n existe pas dans le departement
	 public Employe rechercher(String code){
	        boolean trouve= false;
	        Employe temp= null;
	        for (int i=0; i<tabEmploye.size();i++){
	            if (code.equals(tabEmploye.get(i).codeAcces())){
	                temp= tabEmploye.get(i);
	                trouve= true;
	            }
	        }
	        if(trouve==true){
	            return temp;
	        }
	        else
	        	return null;
	    }


	/*public void addEmploye(String nom, String prenom, String date, double salaireEmploye, int heures) throws Exception {
        setTabEmploye(getNbrEmploye(), new Employe(nom, prenom, date, heures, salaireEmploye));
        setNbrEmploye(getNbrEmploye() + 1);
    }
	//Main pour tester la classe
	public static void main(String[] args) {
     Departement dep1= new Departement("Programmation");
     try {
    	 dep1.addEmploye("M", "Raph", "12981234", 30, 32);
 		dep1.addEmploye("R", "Raph", "12981234", 30, 32);
 		 dep1.addEmploye("T", "Raph", "12981234", 30, 32);
     	 dep1.addEmploye("X", "Raph", "12981234", 30, 32);
    	 dep1.addEmploye("Z", "Raph", "12981234", 30, 32);
		dep1.addEmploye("D", "Raph", "12981234", 30, 32);
		 dep1.addEmploye("B", "Raph", "12981234", 30, 32);
    	 dep1.addEmploye("Y", "Raph", "12981234", 30, 32);
		dep1.addEmploye("C", "Raph", "12981234", 30, 32);
		 dep1.addEmploye("L", "Raph", "12981234", 30, 32);
	} catch (Exception e) {
		e.printStackTrace();
	}
     
     Collections.sort(dep1.tabEmploye,Departement.COMPARE_BY_NAME);
     dep1.afficher(dep1.tabEmploye);
     //System.out.println(dep1.tri(dep1.tabEmploye,0,dep1.tabEmploye.size()-1));
     try {
    	 System.out.println(dep1.rechercher("RA34").getNom());
		System.out.println("Masse salarial:"+dep1.masseSalariale());
		System.out.println("Moyenne salarial:"+dep1.moyenneSalariale());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     }*/

}
