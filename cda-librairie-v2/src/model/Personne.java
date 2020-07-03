package model;

import lombok.Data;

@Data
public class Personne {

	private String login;
	private String password;
	private String nom;
	private String prenom;
	private int id;
	private boolean isClient;

	public Personne(String login, String password, String nom, String prenom) {
		super();
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
	}
}