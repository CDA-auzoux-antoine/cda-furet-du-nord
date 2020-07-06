package service;

import java.util.ArrayList;
import java.util.List;

import cda.librairie.dao.DaoCommande;
import model.Commande;
import model.Livre;
import model.Personne;

public class ServiceCommande {

	public static int creerCommande(DaoCommande cmddao, Personne pPersonne) {
		return cmddao.create(new Commande(pPersonne.getId())).getIdcmd();
	}

	public static List<Commande> listerLesCommandesNonLivrer(DaoCommande cmdDao) {
		return cmdDao.selectAll();
	}

	public static void ListerLesCommande(ArrayList<Livre> selectAll) {
		// TODO Auto-generated method stub

	}

}
