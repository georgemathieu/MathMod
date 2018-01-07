package mati�re;

import java.util.ArrayList;

import objet.Groupe;
import objet.Professeur;
import objet.Salle;

public class Cours {
	private int heure;
	private int jour;
	private Salle salle;
	private ArrayList<Groupe> groupes;
	private Professeur prof;
	private Matiere mati�re;

	public Cours() {
	}

	public Cours(Matiere m, Salle s, Professeur p, ArrayList<Groupe> g, int jour, int heure) {
		this.mati�re = m;
		this.salle = s;
		this.prof = p;
		this.heure = heure;
		this.jour = jour;
		this.groupes = g;
	}
	
	public String toString(){
		return mati�re.getLibelle() + " " + jour + " " + heure + " " + prof.getNom();
	}
}
