package model;

import lombok.Data;

@Data
public class Adresse {
	private int idAdresse;
	private int numeroDeRue;
	private String rue;
	private int cp;
	private String ville;

	public Adresse(int numeroDeRue, String rue, int cp, String ville) {
		super();
		this.numeroDeRue = numeroDeRue;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
	}
}
