package service;

import cda.libraire.idao.implementation.IDao;
import cda.librairie.dao.DaoPersonneImp;
import model.Personne;;

public class ServiceConnexion {

	public Personne connexion(DaoPersonneImp dao, String login, String password) {
		return dao.connexion(login, password);
	}

	public Personne inscription(IDao dao, String login, String password) {
		return null;
	}
}
