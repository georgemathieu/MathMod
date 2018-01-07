package iut;

public class Objet {
	private Edt emploi;
	

	public Objet (){
		this.emploi = new Edt(); 
	}
	
	
	
	
	public void setEmploi(Edt emploi) {
		this.emploi = emploi;
	}

	public Edt getEmploi() {
		return emploi;
	}

	public int getId() {
		return -1;
	}
	
	public boolean estDispo(int jour, int heure) {
		return emploi.estDispo(jour, heure);
	}
	
	public void modifierDispo (int jour, int heure) {
		emploi.change(jour, heure);
	}
	

}
