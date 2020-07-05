package service;

import cda.librairie.dao.DaoPersonneImp;
import model.Personne;
import outils.PasswordHash;

public class ServiceConnexion {

	public Personne connexion(DaoPersonneImp dao, String login, String password) {
		return dao.connexion(login, PasswordHash.getMd5(password));
	}

	public Personne inscription(DaoPersonneImp daoInscription, String pNom, String pPrenom, int pIdAdresse,
			String pLogin, String pPassword) {
		return daoInscription.create(new Personne(pNom, pPrenom, pLogin, pPassword, pIdAdresse, false, true));
	}
}