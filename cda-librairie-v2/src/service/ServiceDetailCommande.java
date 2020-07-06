package service;

import java.util.Map;

import cda.librairie.dao.DaoDetailCommande;
import cda.librairie.dao.DaoLivreImp;
import model.DetailCommande;
import model.Livre;
import model.Personne;

public class ServiceDetailCommande {

	public static void afficherMonPanier(DaoLivreImp daolivre) {
		for (Map.Entry map : DetailCommande.commande.entrySet()) {
			Livre l = (Livre) map.getKey();
			System.out.println(l.getTitre() + " " + map.getValue());
		}
	}

	public static void validerMonPanier(DaoDetailCommande detailcmd, Personne p, int idCmd) {
		int idCommande = idCmd;
		for (Map.Entry map : DetailCommande.commande.entrySet()) {
			Livre l = (Livre) map.getKey();
			DetailCommande decmd = new DetailCommande(l.getIdentifiant(), (int) map.getValue());
			decmd.setIdCommande(idCommande);
			decmd.setPrixUnitaire(l.getPrix());
			detailcmd.create(decmd);
		}
	}

//	public static void livrerCommande(DaoDetailCommande detailCmdDao, DetailCommande detailCmd) {
//		detailCmdDao.update(detailCmd);
//
//	}

}
