package model;

import lombok.Data;

@Data
public class Livre {

	private String titre;

	private String genre;
	private String auteur;
	private float prix;
	private int nbrePage;

	private int quantite;

	private int identifiant;

	public Livre(String titre, String genre, String auteur, float prix, int nbrePage, int quantite) {

		this.titre = titre;
		this.genre = genre;
		this.auteur = auteur;
		this.prix = prix;
		this.nbrePage = nbrePage;
		this.quantite = quantite;
	}
}