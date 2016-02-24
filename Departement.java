/**	B - Dans le fichier  Departement .java, définir la classe Departement
 * 	1 - Les attributs (choisir les types appropriés):
 * 		- nom département
 * 		- nombre d’employés
 * 		- tableau d’employés (20  au  max)
 * 			Définir  un  main() et faire des tests au fur et à mesure,
 *  		dans lequel vous créerez un  objet de cette classe
 *  		et affichez ses informations, avec les données de votre choix.
 * 	2 - Les méthodes
 * 		- masseSalariale() :
 * 			retourne  le  total  des salaires  bruts  de  tous  les  employés
 * 			figurant dans le tableau d’employés
 * 		- moyenne Salariale() :
 * 			retourne  la  moyenne  des  salaires  bruts
 *   		de  tous  les  employés figurant dans le tableau d’employés
 *
 * 		Important : coder et tester UNE SEULE méthode à la fois
 * 			 en l’appelant dans le  main() de cette classe
 *
 * @author Raphaël Duchaîne
 *
 */

public class Departement {
  //Attributs
	final int MAX=20;
	String nomDepartement;
	int nbrEmploye;
	Employe[] tabEmploye=new Employe[MAX];
  //Constructeurs
	public Departement(){
		this.nomDepartement="Département par défaut";
	}
	//Constructeur demandant le nom du département
	public Departement(String nomDepartement){
		this.nomDepartement=nomDepartement;
	}
	//Constructeur permettant d'ajouter le salaire du 1er employé
	public Departement(String nomDepartement, double salairePremierEmploye){
		this.nomDepartement=nomDepartement;
		tabEmploye[nbrEmploye]=new Employe(salairePremierEmploye);
		nbrEmploye=1;
	}
	//Calcul de la masse salariale
	public double masseSalariale(){
		double masse=0;
		for(int i=0;i<nbrEmploye;i++)
			masse+=tabEmploye[i].salaire;

		return masse;
	}
	//Calcul de la moyenne salariale
	public double moyenneSalariale(){
		return masseSalariale()/nbrEmploye;
	}

	//Méthode permettant d'ajouter un employé au bout de tabEmploye
	public void addEmploye(double salaireEmploye){
		tabEmploye[nbrEmploye]=new Employe(salaireEmploye);
		nbrEmploye++;
	}

	//Main pour tester la classe
	public static void main(String[] args) {
		Departement dep1= new Departement("Programmation",100);
		dep1.addEmploye(20);
		System.out.println(dep1);
		System.out.println("Masse salarial:"+dep1.moyenneSalariale());
		System.out.println("Moyenne salarial:"+dep1.moyenneSalariale());
	}

}
