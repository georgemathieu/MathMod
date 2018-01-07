package iut;

import java.util.ArrayList;

import matière.Cours;

public class Edt {
	private boolean[][] disponibilités;
	private ArrayList<Cours> cours; 
	
	public Edt(){
		disponibilités = new boolean[5][6];
		this.cours = new ArrayList<Cours>();
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 6; j++)
				disponibilités[i][j] = true; 
	}
	
	public void fixercontrainte(boolean [][] h){
		for(int i = 0; i<5;i++){
			for(int j=0;j<6;j++){
				disponibilités[i][j] = h[i][j];
			}
		}
	}

	public boolean[][] getDisponibilités() {
		return disponibilités;
	}

	public void setDisponibilités(boolean[][] disponibilités) {
		this.disponibilités = disponibilités;
	}

	public boolean estDispo(int jour, int heure) {
		return disponibilités[jour][heure];
	}

	public void change(int jour, int heure) {
		disponibilités[jour][heure] = !disponibilités[jour][heure];
	}
	
	public ArrayList<Cours> getCours() {
		return cours;
	}

	public void setCours(ArrayList<Cours> cours) {
		this.cours = cours;
	}
}
