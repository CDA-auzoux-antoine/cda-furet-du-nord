package model;

import java.util.HashMap;

import lombok.Data;

@Data
public class DetailCommande {
	private int idCommande;
	private int livre;
	private int quantite;
	private float prixUnitaire;
	private boolean commandeValider;
	private int idClient;
	private String datecmd;
	public static HashMap<Livre, Integer> commande = new HashMap<>();

	public DetailCommande(int idLivre, int quantite) {
		this.livre = idLivre;
		this.quantite = quantite;
	}

}
