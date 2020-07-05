package cda.librairie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.librairie.connexion.bd.MyConnection;

import cda.libraire.idao.implementation.IDao;
import model.Commande;

public class DaoCommande implements IDao<Commande> {
	private static Connection c = MyConnection.getConnexion();

	@Override
	public Commande create(Commande t) {
		try {
			String request = "INSERT INTO commande (id_personne) VALUES (?)";
			PreparedStatement ps = null;
			ps = c.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, t.getIdClient());
			ps.executeUpdate();
			ResultSet resultat = ps.getGeneratedKeys();
			if (resultat.next()) {
				t.setIdcmd(resultat.getInt(1));
				return t;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Commande update(Commande t) {

		return null;
	}

	@Override
	public void delete(Commande t) {

	}

	@Override
	public Commande find(String id) {
		return null;

	}

	@Override
	public List<Commande> selectAll() {
		return null;
	}

}
