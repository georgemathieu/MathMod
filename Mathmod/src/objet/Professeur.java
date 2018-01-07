package objet;

import iut.Objet;

public class Professeur extends Objet {
	private static int nbProf = 0;
	private int idProf;
	private String nom;
	
	
	public Professeur(String nom){
		super();
		nbProf ++;
		this.idProf = nbProf;
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}
	
	@Override
	public int getId(){
		return idProf;
	}
	
	public String toString(){
		return ""+ idProf + " " + nom;
	}
}
