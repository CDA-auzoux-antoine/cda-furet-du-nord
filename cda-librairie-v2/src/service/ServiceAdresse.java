package service;

import cda.librairie.dao.DaoAdresseImp;
import model.Adresse;

public class ServiceAdresse {
	public Adresse creerUneAdresse(DaoAdresseImp daoAdresse, int pNumeroDeRue, String pRue, int pCp, String pVille) {
		return daoAdresse.create(new Adresse(pNumeroDeRue, pRue, pCp, pVille));
	}
}
