package objet;

import java.util.ArrayList;

import iut.Objet;

public class Groupe extends Objet {
	private int idGroupe;
	private static final int TAILLE_GROUPE = 15; 
	private ArrayList<String> matières;
	private int année;
	
	
	public Groupe(int id, int année){
		super();
		assert (année ==1 || année == 2);
		idGroupe = id;
		this.année = année;
		this.matières = new ArrayList <String>();
		if (année == 1){
			matières.add("Archi");
			matières.add("AlgL");
			matières.add("CDIN");
			matières.add("EGOD");
			matières.add("IAP");
			matières.add("Maths");
			matières.add("PJS1");
			matières.add("SGBD");
			matières.add("SHS");
			matières.add("Anglais");		
			matières.add("EC");
		}
		if (année == 2) {
			matières.add("AAV");
			matières.add("Anglais");
			matières.add("BDA");
			matières.add("Droit");		
			matières.add("EC");
			matières.add("MathsMod");
			matières.add("Mpa");
			matières.add("ProbaStat");
			matières.add("PWEB");
			matières.add("PSE");
		}
	}

	public int getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(int idGroupe) {
		this.idGroupe = idGroupe;
	}

	public ArrayList<String> getMatières() {
		return matières;
	}

	public void setMatières(ArrayList<String> matières) {
		this.matières = matières;
	}

	public static int getTailleGroupe() {
		return TAILLE_GROUPE;
	}

	@Override
	public int getId() {
		return idGroupe;
	}
	
	public int getTaille (){
		return TAILLE_GROUPE;
	}
	
	public String toString(){
		return ""+ idGroupe;
	}
}
