package objet;

import iut.Objet;

public class Salle extends Objet {
	private int idSalle;
	private String type;
	
	public Salle (int i, String type){
		super();
		this.idSalle = i;
		this.type = type;
	}
	
	@Override
	public int getId(){
		return idSalle;
	}
	
	public String getType(){
		return type;
	}
	
	public String toString(){
		return "" + idSalle + " " + type;
	}
}
