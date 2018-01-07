package objet;

import java.util.ArrayList;

import iut.Objet;

public class Groupe extends Objet {
	private int idGroupe;
	private static final int TAILLE_GROUPE = 15; 
	private ArrayList<String> mati�res;
	private int ann�e;
	
	
	public Groupe(int id, int ann�e){
		super();
		assert (ann�e ==1 || ann�e == 2);
		idGroupe = id;
		this.ann�e = ann�e;
		this.mati�res = new ArrayList <String>();
		if (ann�e == 1){
			mati�res.add("Archi");
			mati�res.add("AlgL");
			mati�res.add("CDIN");
			mati�res.add("EGOD");
			mati�res.add("IAP");
			mati�res.add("Maths");
			mati�res.add("PJS1");
			mati�res.add("SGBD");
			mati�res.add("SHS");
			mati�res.add("Anglais");		
			mati�res.add("EC");
		}
		if (ann�e == 2) {
			mati�res.add("AAV");
			mati�res.add("Anglais");
			mati�res.add("BDA");
			mati�res.add("Droit");		
			mati�res.add("EC");
			mati�res.add("MathsMod");
			mati�res.add("Mpa");
			mati�res.add("ProbaStat");
			mati�res.add("PWEB");
			mati�res.add("PSE");
		}
	}

	public int getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(int idGroupe) {
		this.idGroupe = idGroupe;
	}

	public ArrayList<String> getMati�res() {
		return mati�res;
	}

	public void setMati�res(ArrayList<String> mati�res) {
		this.mati�res = mati�res;
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
