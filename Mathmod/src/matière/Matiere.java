package matière;

import java.util.ArrayList;
import objet.Professeur;

public class Matiere {
	private String libelle;
	private int nbAmphi;
	private int nbTD;
	private int nbTP;
	private ArrayList<Professeur> profs;
	
	public Matiere(String c, int amphi, int td, int tp, ArrayList<Professeur> profs){
		libelle = c;
		nbAmphi = amphi;
		nbTD = td;
		nbTP = tp;
		this.profs = profs;
	}

	public String getLibelle() {
		return libelle;
	}

	public int getNbAmphi() {
		return nbAmphi;
	}

	public int getNbTD() {
		return nbTD;
	}

	public int getNbTP() {
		return nbTP;
	}
	
	public String toString (){
		String s = libelle + " " + nbAmphi + " " + nbTD + " " + nbTP;
		for (int i = 0; i < profs.size(); i++)
			s += " " + profs.get(i).getNom();
		return s;
	}

	public void addProfs(Professeur p) {
		this.profs.add(p);
		
	}

	public Professeur getReferent() {
		return profs.get(0);
	}
}
