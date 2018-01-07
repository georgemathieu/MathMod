package iut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import matière.Cours;
import matière.Matiere;
import objet.Groupe;
import objet.Professeur;
import objet.Salle;

public class Iut {
	private static ArrayList<Groupe> groupes;
	private static ArrayList<Salle> salles;
	private static ArrayList<Professeur> profs;
	private static ArrayList<Matiere> matières;

	public ArrayList<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(ArrayList<Groupe> groupes) {
		this.groupes = groupes;
	}

	public ArrayList<Salle> getSalles() {
		return salles;
	}

	public void setSalles(ArrayList<Salle> salles) {
		this.salles = salles;
	}

	public ArrayList<Professeur> getProfs() {
		return profs;
	}

	public void setProfs(ArrayList<Professeur> profs) {
		this.profs = profs;
	}

	public Iut() {
		this.groupes = new ArrayList<Groupe>();
		this.salles = new ArrayList<Salle>();
		this.profs = new ArrayList<Professeur>();
		this.matières = new ArrayList<Matiere>();
	}

	public static void setDB() throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("bdd v2.txt"));
		String ligne;
		while (sc.hasNextLine()) {
			ligne = sc.nextLine();
			String[] mot = ligne.split(" ");
			if (mot[0].equals("CREATE")) {
				switch (mot[1]) {
				case "GROUPE":
					groupes.add(new Groupe(Integer.parseInt(mot[2]), Integer.parseInt(mot[3])));
					break;
				case "SALLE":
					salles.add(new Salle(Integer.parseInt(mot[2]), mot[3]));
					break;
				case "MATIERE":
					matières.add(new Matiere(mot[2], Integer.parseInt(mot[3]), Integer.parseInt(mot[4]),
							Integer.parseInt(mot[5]), new ArrayList<Professeur>()));
					for (int i = 6; i < mot.length; i++) {
						for (Professeur p : profs) {
							if (p.getNom().equals(mot[i])) {
								matières.get(matières.size() - 1).addProfs(p);
								break;
							}
						}
					}
				case "PROF":
					profs.add(new Professeur(mot[2]));
				default:
					break;
				}
			}
		}

		sc.close();
	}

	private static void amphi() {
		int[] créneau;
		for (Matiere m : matières) {
			if (m.getNbAmphi() != 0) {
				ArrayList<Groupe> g = new ArrayList<Groupe>();
				for (Groupe gr : groupes) {
					if (gr.getMatières().contains(m.getLibelle())) {
						g.add(gr);
					}
				}
				ArrayList<Salle> s = new ArrayList<Salle>();
				for (Salle sa : salles) {
					if (sa.getType().equals("AMPHI")) {
						s.add(sa);
					}
				}

				créneau = findHour(m.getReferent(), s, g);

				/*if (créneau[0] != -1 && créneau[1] != -1) {
					for (Salle sa : s) {
						if (sa.estDispo(créneau[0], créneau[1])) {
							m.getReferent().getEmploi().getCours()
									.add(new Cours(m, sa, m.getReferent(), g, créneau[0], créneau[1]));
							m.getReferent().getEmploi().change(créneau[0], créneau[1]);
							sa.getEmploi().getCours().add(new Cours(m, sa, m.getReferent(), g, créneau[0], créneau[1]));
							sa.getEmploi().change(créneau[0], créneau[1]);
							for (Groupe gr : g) {
								gr.getEmploi().getCours()
										.add(new Cours(m, sa, m.getReferent(), g, créneau[0], créneau[1]));
								gr.getEmploi().change(créneau[0], créneau[1]);
							}
						}
					}
				}*/
			}
		}
	}

	private static int[] findHour(Professeur prof, ArrayList<Salle> s, ArrayList<Groupe> g) {
		boolean[][][] recap = new boolean[g.size() + 2][5][6];
		// [id][jour][heure] recap[0][][] : prof // recap[1][][] : concaténation
		// des salles
		boolean[][] buffer = new boolean[5][6];
		boolean[][] tampon = new boolean[5][6];
		int[] res = { -1, -1 };

		for (int i = 0; i <= 4; i++)
			for (int j = 0; j <= 5; j++)
				tampon[i][j] = false;
		

		int id = 0;

		buffer = prof.getEmploi().getDisponibilités();
		for (int jour = 0; jour <= 4; jour++) {
			for (int heure = 0; heure <= 5; heure++) {
				recap[id][jour][heure] = buffer[jour][heure];
			}
		}
		id++;

		for (Salle sa : s) {
			buffer = sa.getEmploi().getDisponibilités();
			for (int jour = 0; jour <= 4; jour++) {
				for (int heure = 0; heure <= 5; heure++) {
					if (buffer[jour][heure])
						tampon[jour][heure] = true;
				}
			}
		}
		recap[id] = tampon;
		for (int jour = 0; jour <= 4; jour++) {
			for (int heure = 0; heure <= 5; heure++) {
				System.out.println(""+recap[id][jour][heure]);
			}
		}
		id++;
		//System.out.println(""+id);
		for (Groupe gr : g) {
			buffer = gr.getEmploi().getDisponibilités();
			for (int jour = 0; jour <= 4; jour++) {
				for (int heure = 0; heure <= 5; heure++) {
					recap[id][jour][heure] = buffer[jour][heure];
					//System.out.println(""+recap[id][jour][heure]);
				}
			}
			id++;
		}
		

		for (int heure = 5; heure >= 0; heure--) {
			for (int jour = 4; jour >= 0; jour--) {
				boolean dispo = true;
				while (id > 0) {
					//System.out.println(""+recap[id-1][jour][heure]);
					//System.out.println("" + id);
					if (recap[id - 1][jour][heure]== false) {
						System.out.println("gaz");
						dispo = false;
					}
					id--;
				}
				if (dispo) {
					res[0] = jour;
					res[1] = heure;
				}
			}
		}
		return res;
	}

	private static boolean[][] findHour(Objet o) {
		return o.getEmploi().getDisponibilités();
	}

	public static void main(String[] args) {
		Iut iut = new Iut();
		try {
			setDB();
			amphi();
			Groupe g = groupes.get(0);
			System.out.println(g.getEmploi().getCours().toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
