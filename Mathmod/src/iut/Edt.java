package iut;

import java.util.ArrayList;

import mati�re.Cours;

public class Edt {
	private boolean[][] disponibilit�s;
	private ArrayList<Cours> cours; 
	
	public Edt(){
		disponibilit�s = new boolean[5][6];
		this.cours = new ArrayList<Cours>();
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 6; j++)
				disponibilit�s[i][j] = true; 
	}
	
	public void fixercontrainte(boolean [][] h){
		for(int i = 0; i<5;i++){
			for(int j=0;j<6;j++){
				disponibilit�s[i][j] = h[i][j];
			}
		}
	}

	public boolean[][] getDisponibilit�s() {
		return disponibilit�s;
	}

	public void setDisponibilit�s(boolean[][] disponibilit�s) {
		this.disponibilit�s = disponibilit�s;
	}

	public boolean estDispo(int jour, int heure) {
		return disponibilit�s[jour][heure];
	}

	public void change(int jour, int heure) {
		disponibilit�s[jour][heure] = !disponibilit�s[jour][heure];
	}
	
	public ArrayList<Cours> getCours() {
		return cours;
	}

	public void setCours(ArrayList<Cours> cours) {
		this.cours = cours;
	}
}
