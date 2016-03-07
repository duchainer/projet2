/**	B - Dans le fichier  Departement.java, d�finir la classe Departement
 * 
 * 	1 - Les attributs (choisir les types appropri�s): 
 * 		- nom d�partement 
 * 		- nombre d'employ�s 
 * 		- tableau d'employ�s (20  au  max) 
 * 			D�finir  un  main() et faire des tests au fur et à mesure,
 *  		dans lequel vous cr�erez un  objet de cette classe 
 *  		et affichez ses informations, avec les donn�es de votre choix. 
 * 	2 - Les m�thodes 
 * 		- masseSalariale() : 
 * 			retourne  le  total  des salaires  bruts  de  tous  les  employ�s
 * 			figurant dans le tableau d'employ�s 
 * 		- moyenne Salariale() :  
 * 			retourne  la  moyenne  des  salaires  bruts
 *   		de  tous  les  employ�s figurant dans le tableau d'employ�s 
 * 
 * @author Rapha�l Ducha�ne 19/02/2016
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
		this.nomDepartement="D�partement par d�faut";
	}
	//Constructeur demandant le nom du d�partement
	public Departement(String nomDepartement){
		this.nomDepartement=nomDepartement;
	}
	//toString
	public String toString(){
		return nomDepartement+": "+nbrEmploye+" Employ�s \n Masse Salariale: "+masseSalariale()+"\n Moyenne Salariale: "+moyenneSalariale();
	}
	
  //M�thodes
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
	//M�thode permettant d'ajouter un employ� au bout de tabEmploye
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
