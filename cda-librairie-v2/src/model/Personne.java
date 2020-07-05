package model;

import lombok.Data;
import outils.PasswordHash;

@Data
public class Personne {

	private String login;
	private String password;
	private String nom;
	private String prenom;
	private int idAdresse;
	private int id;
	private boolean isClient;
	private boolean isActived;

	public Personne(String nom, String prenom, String login, String password, int idAdresse, boolean isActived,
			boolean isClient) {
		super();
		this.login = login;
		this.password = PasswordHash.getMd5(password);
		this.nom = nom;
		this.prenom = prenom;
		this.idAdresse = idAdresse;
		this.isClient = isClient;
		this.isActived = isActived;
	}
}