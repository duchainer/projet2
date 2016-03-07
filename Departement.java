/**	B - Dans le fichier  Departement.java, définir la classe Departement
 * 
 * 	1 - Les attributs (choisir les types appropriés): 
 * 		- nom département 
 * 		- nombre d'employés 
 * 		- tableau d'employés (20  au  max) 
 * 			Définir  un  main() et faire des tests au fur et Ã  mesure,
 *  		dans lequel vous créerez un  objet de cette classe 
 *  		et affichez ses informations, avec les données de votre choix. 
 * 	2 - Les méthodes 
 * 		- masseSalariale() : 
 * 			retourne  le  total  des salaires  bruts  de  tous  les  employés
 * 			figurant dans le tableau d'employés 
 * 		- moyenne Salariale() :  
 * 			retourne  la  moyenne  des  salaires  bruts
 *   		de  tous  les  employés figurant dans le tableau d'employés 
 * 
 * @author Raphaël Duchaîne 19/02/2016
 * 
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
	//toString
	public String toString(){
		return nomDepartement+": "+nbrEmploye+" Employés \n Masse Salariale: "+masseSalariale()+"\n Moyenne Salariale: "+moyenneSalariale();
	}
	
  //Méthodes
	//Calcul de la masse salariale
	public double masseSalariale(){
		double masse=0;
		for(int i=0;i<nbrEmploye;i++)
			masse+=tabEmploye[i].salaireBrut();
		
		return masse;	
	}//Calcul de la moyenne salariale 
	public double moyenneSalariale(){
		return masseSalariale()/nbrEmploye;
	}
	//Méthode permettant d'ajouter un employé au bout de tabEmploye
	public void addEmploye(String nom,String prenom,String date,double salaireEmploye,int heures){
		tabEmploye[nbrEmploye]=new Employe(nom,prenom,date,heures,salaireEmploye);
		nbrEmploye++;
	}
	//Main pour tester la classe
	/*public static void main(String[] args) {
		Departement dep1= new Departement("Programmation");
		dep1.addEmploye(20);
		System.out.println(dep1);
		System.out.println("Masse salarial:"+dep1.moyenneSalariale());
		System.out.println("Moyenne salarial:"+dep1.moyenneSalariale());
	}*/

}
