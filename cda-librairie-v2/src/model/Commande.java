package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Commande {
	private int idClient;
	private int idcmd;

	public Commande(int id) {
		this.idClient = id;
	}

}
