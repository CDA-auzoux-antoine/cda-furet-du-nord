package cda.librairie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.librairie.connexion.bd.MyConnection;

import cda.libraire.idao.implementation.IDao;
import model.model.Personne;

public class DaoPersonneImp implements IDao<Personne> {
	private static final Connection c = MyConnection.getConnexion();
	private static String query;
	private static PreparedStatement ps = null;

	@Override
	public Personne find(int id) {
		return null;

	}

	// pour l'inscription
	@Override
	public Personne create(Personne t) {
		// TODO Auto-generated method stub
		// pas besoin de id
		// par defaut le compte et desactiver
		// par default le compte est un compte client
		// exemple d'insertion : insert into personne (nom,prenom ,id_adresse ,login
		// ,password) values("client1","client1", 1, "client","client");
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

	// Connexion au compte
	public Personne connexion(String login, String password) {
		try {
			query = "select * from personne where login=? and password=?";
			ps = c.prepareStatement(query);
			ps.setString(1, login);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Personne p = new Personne(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getBoolean(7), rs.getBoolean(8));
				p.setId(rs.getInt(1));
				return p;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
