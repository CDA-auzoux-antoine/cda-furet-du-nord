package service;

import cda.librairie.dao.DaoCommande;
import model.Commande;
import model.Personne;

public class ServiceCommande {

	public static int creerCommande(DaoCommande cmddao, Personne pPersonne) {
		return cmddao.create(new Commande(pPersonne.getId())).getIdcmd();
	}

}
