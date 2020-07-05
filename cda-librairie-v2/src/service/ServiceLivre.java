package service;

import java.util.ArrayList;

import cda.librairie.dao.DaoLivreImp;
import model.Livre;

public class ServiceLivre {
	public static void ListerLesLivres(ArrayList<Livre> pArray) {
		System.out.format("%5s%50s%15s%35s%15s%10s%n", "ID", "Titre", "Auteur", "Genre", "Nombre Page", "Prix");
		for (Livre livre : pArray) {
			System.out.format("%5s%50s%15s%35s%15s%10s%n", livre.getIdentifiant(), livre.getTitre(), livre.getAuteur(),
					livre.getGenre(), livre.getNbrePage(), livre.getPrix());

		}

	}

	public static void modifierPrixLivre(DaoLivreImp pLivreImp, int vPrix, int pId) {
		Livre vLivre = pLivreImp.find(pId);
		vLivre.setPrix(vPrix);
		pLivreImp.update(vLivre);

	}

	public static boolean modifierQuantiteALaCommande(DaoLivreImp pLivreImp, int pQuantite, int pId) {
		Livre vLivre = pLivreImp.find(pId);
		if (vLivre.getIdentifiant() > pQuantite) {
			vLivre.setQuantite(vLivre.getQuantite() - pQuantite);
			pLivreImp.update(vLivre);
			return true;
		}
		return false;
	}

	public static void ajouterLivreAuStock(DaoLivreImp plivreImp, Livre pLivre) {
		plivreImp.create(pLivre);
	}

	public static void modifierQuantiteDuStock(DaoLivreImp pLivreImp, int pQuantite, int pId) {
		Livre vLivre = pLivreImp.find(pId);
		vLivre.setQuantite(pQuantite);
		pLivreImp.update(vLivre);
	}
}
