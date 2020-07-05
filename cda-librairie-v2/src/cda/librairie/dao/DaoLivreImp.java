package cda.librairie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.librairie.connexion.bd.MyConnection;

import cda.libraire.idao.implementation.IDao;
import model.model.Livre;

public class DaoLivreImp implements IDao<Livre> {
	private static Connection c = MyConnection.getConnexion();

	@Override
	public Livre update(Livre t) {
		if (t != null) {
			String request = "update livre set titre = ?, auteur = ?, nombreDePages = ?, Genre = ?, prix = ?, quantite = ? where id_livre = ?";
			PreparedStatement ps = null;
			try {
				ps = c.prepareStatement(request);
				ps.setString(1, t.getTitre());
				ps.setString(2, t.getAuteur());
				ps.setInt(3, t.getNbrePage());
				ps.setString(4, t.getGenre());
				ps.setFloat(5, t.getPrix());
				ps.setInt(6, t.getQuantite());
				ps.setInt(7, t.getIdentifiant());
				ps.executeUpdate();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} else {
			System.out.println("Entrée impossible la personne ne peut etre null");
		}
		return null;
	}

	@Override
	public void delete(Livre t) {
		String request = "delete from livre where id_livre = ?";
		PreparedStatement ps = null;
		try {
			ps = c.prepareStatement(request);
			ps.setInt(1, t.getIdentifiant());
			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public Livre find(int id) {
		Livre vLivre = null;
		try {
			String request = "select * from livre where id_livre = ?";
			PreparedStatement ps = c.prepareStatement(request);
			ps.setInt(1, id);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				Integer vIdLivre = r.getInt(1);
				String titreLivre = r.getString(2);
				String auteurLivre = r.getString(3);
				Integer nbrePage = r.getInt(4);
				String genreLivre = r.getString(5);
				Float prixLivre = r.getFloat(6);
				Integer quantiteLivre = r.getInt(6);
				vLivre = new Livre(titreLivre, genreLivre, auteurLivre, prixLivre, nbrePage, quantiteLivre);
				vLivre.setIdentifiant(id);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (vLivre != null) {
			return vLivre;
		} else {

			return null;
		}
	}

	@Override
	public List<Livre> selectAll() {
		ArrayList<Livre> arrayLivre = new ArrayList<>();
		try {
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery("select * from livre");
			while (r.next()) {
				Integer vIdLivre = r.getInt(1);
				String titreLivre = r.getString(2);
				String auteurLivre = r.getString(3);
				Integer nbrePage = r.getInt(4);
				String genreLivre = r.getString(5);
				Float prixLivre = r.getFloat(6);
				Integer quantiteLivre = r.getInt(7);

				Livre vLivre = new Livre(titreLivre, genreLivre, auteurLivre, prixLivre, nbrePage, quantiteLivre);
				vLivre.setIdentifiant(vIdLivre);
				arrayLivre.add(vLivre);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayLivre;
	}

	@Override
	public Livre create(Livre t) {
		if (c != null && t != null) {
			try {
				String request = "INSERT INTO livre (titre_livre,auteur_livre,nombreDePages_livre,Genre_livre, prix_livre,quantite ) VALUES (?,?,?,?,?,?)";
				PreparedStatement ps = null;
				ps = c.prepareStatement(request);
				ps.setString(1, t.getTitre());
				ps.setString(2, t.getAuteur());
				ps.setInt(3, t.getNbrePage());
				ps.setString(4, t.getGenre());
				ps.setFloat(5, t.getPrix());
				ps.setInt(6, t.getQuantite());
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
}
