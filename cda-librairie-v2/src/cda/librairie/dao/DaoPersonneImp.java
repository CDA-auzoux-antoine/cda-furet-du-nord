package cda.librairie.dao;

import java.util.List;

import cda.libraire.idao.implementation.IDao;
import model.Personne;

public class DaoPersonneImp implements IDao<Personne> {

	// Pour la connexion
	@Override
	public Personne find(int id) {
		return null;

	}

	// pour l'inscription
	@Override
	public Personne create(Personne t) {
		// TODO Auto-generated method stub
		return null;
	}

	/*****************************************************************
	 * partie utiliser par le libraire (pour gerer les compte client )
	 *****************************************************************/
	/*
	 * mettre ( where isClient = 1 dans les requetes sql afin de lister que les
	 * clients )
	 */

	@Override
	public Personne update(Personne t) {
		// pour activer le compte Personne
		return null;
	}

	@Override
	public void delete(Personne t) {

	}

	@Override
	public List<Personne> selectAll() {

		return null;
	}

}
