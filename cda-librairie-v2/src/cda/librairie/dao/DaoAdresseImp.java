package cda.librairie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.librairie.connexion.bd.MyConnection;

import cda.libraire.idao.implementation.IDao;
import model.Adresse;

public class DaoAdresseImp implements IDao<Adresse> {
	public int idAdresse = 0;
	private static final Connection c = MyConnection.getConnexion();

	@Override
	public Adresse create(Adresse t) {
		if (c != null && t != null) {
			try {
				String request = "INSERT INTO adresse (numeroDeRue,rue,cp,ville) VALUES (?,?,?,?);";
				PreparedStatement ps = c.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setInt(1, t.getNumeroDeRue());
				ps.setString(2, t.getRue());
				ps.setInt(3, t.getCp());
				ps.setString(4, t.getVille());
				ps.executeUpdate();
				ResultSet rs = ps.getGeneratedKeys();
				while (rs.next()) {
					idAdresse = rs.getInt(1);
					return (t);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Adresse update(Adresse t) {
		return null;
	}

	@Override
	public void delete(Adresse t) {
	}

	@Override
	public Adresse find(String pId) {
		return null;
	}

	@Override
	public List<Adresse> selectAll() {
		return null;
	}

	public int getIdAdresse() {
		return idAdresse;
	}
}
