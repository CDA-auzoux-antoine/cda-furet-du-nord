package model;

import lombok.Data;

@Data
public class Client extends Personne {
	// adresse
	public Client(String login, String password, String nom, String prenom) {
		super(login, password, nom, prenom);
	}
}