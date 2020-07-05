package model.model;

import lombok.Data;

@Data
public class Personne {

	private String login;
	private String password;
	private String nom;
	private String prenom;
	private int id;
	private boolean isClient;
	private boolean isActived;

	public Personne(String nom, String prenom, String login, String password, int idAdresse, boolean isActived,
			boolean isClient) {
		super();
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.isClient = isClient;
		this.isActived = isActived;
	}
}