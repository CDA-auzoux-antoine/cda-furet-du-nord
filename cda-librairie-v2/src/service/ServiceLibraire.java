package service;

import cda.librairie.dao.DaoDetailCommande;
import cda.librairie.dao.DaoPersonneImp;
import model.Personne;

public class ServiceLibraire {

	public static void validerDemande(DaoPersonneImp pDaoPersonneImp, String loginPersonne) {
		Personne vPersonne = pDaoPersonneImp.find(loginPersonne);
		if (vPersonne != null) {
			vPersonne.setActived(true);
			pDaoPersonneImp.update(vPersonne);
		}
	}

	public static void supprimerDemande(DaoPersonneImp pDaoPersonneImp, String loginPersonne) {
		Personne vPersonne = pDaoPersonneImp.find(loginPersonne);
		if (vPersonne != null) {
			pDaoPersonneImp.delete(vPersonne);
		}
	}

	public static void LivrerUneCommande(DaoDetailCommande cmdDetail, String idCommande) {
		cmdDetail.update(cmdDetail.find(idCommande));
	}
}
