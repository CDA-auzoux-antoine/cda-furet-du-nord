package cda.librairie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.librairie.connexion.bd.MyConnection;

import cda.libraire.idao.implementation.IDao;
import model.Personne;

public class DaoPersonneImp implements IDao<Personne> {
	private static final Connection c = MyConnection.getConnexion();
	private static String query;
	private static PreparedStatement ps = null;

	@Override
	public Personne find(String pLogin) {
		Personne vPersonne = null;
		String request = "SELECT * FROM personne WHERE login=?";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement(request);
			ps.setString(1, pLogin);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				vPersonne = new Personne(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getBoolean(7), rs.getBoolean(8));
				vPersonne.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (vPersonne != null) {
			return vPersonne;
		} else {
			return null;
		}
	}

	// pour l'inscription
	@Override
	public Personne create(Personne t) {
		if (c != null && t != null) {
			try {
				String request = "INSERT INTO personne (nom,prenom,login,password,id_adresse,isActived,isClient) VALUES (?,?,?,?,?,?,?)";
				PreparedStatement ps = c.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, t.getNom());
				ps.setString(2, t.getPrenom());
				ps.setString(3, t.getLogin());
				ps.setString(4, t.getPassword());
				ps.setInt(5, t.getIdAdresse());
				ps.setBoolean(6, t.isActived());
				ps.setBoolean(7, t.isClient());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					return (t);
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
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
