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
import model.DetailCommande;

public class DaoDetailCommande implements IDao<DetailCommande> {
	private static Connection c = MyConnection.getConnexion();

	@Override
	public DetailCommande create(DetailCommande t) {
		if (t != null) {
			try {
				String request = "INSERT INTO detailscommande (id_commande,id_livre,quantite,prixUnitaire ) VALUES (?,?,?,?)";
				PreparedStatement ps = null;
				ps = c.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setInt(1, t.getIdCommande());
				ps.setInt(2, t.getLivre());
				ps.setInt(3, t.getQuantite());
				ps.setFloat(4, t.getPrixUnitaire());
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

	@Override
	public DetailCommande update(DetailCommande t) {
		if (t != null) {
			String request = "update detailscommande set commande_livree = true where id_commande = ?";
			PreparedStatement ps = null;
			try {
				ps = c.prepareStatement(request);
				ps.setInt(1, t.getIdCommande());
				ps.executeUpdate();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void delete(DetailCommande t) {
		if (!t.isCommandeValider()) {
			String request = "delete from detailscommande where id_commande = ? and commande_livree = false";
			PreparedStatement ps = null;
			try {
				ps = c.prepareStatement(request);
				ps.setInt(1, t.getIdCommande());
				ps.executeUpdate();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public DetailCommande find(String pid) {
		try {
			String request = "Select * from detailscommande where id_commande = ? ";
			PreparedStatement ps = null;
			ps = c.prepareStatement(request);
			ps.setInt(1, Integer.parseInt(pid));
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				Integer vIdcommande = r.getInt("id_commande");
				Integer idLivre = r.getInt("id_livre");
				Integer quantite = r.getInt("quantite");
				Float prixUnitaire = r.getFloat("prixUnitaire");
				Boolean livree = r.getBoolean("commande_livree");
				DetailCommande detailcommande = new DetailCommande(idLivre, quantite);
				detailcommande.setCommandeValider(livree);
				detailcommande.setIdCommande(vIdcommande);
				detailcommande.setPrixUnitaire(prixUnitaire);
				return detailcommande;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<DetailCommande> selectAll() {
		ArrayList<DetailCommande> arraydetail = new ArrayList<>();
		try {
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(
					"SELECT d2.id_commande , c2.id_personne , d2.id_livre , d2.prixUnitaire , d2.quantite, d2.commande_livree, c2.date_Commande FROM detailscommande d2 INNER JOIN commande c2 on d2.id_commande = c2.id_commande order by c2.date_Commande desc");
			while (r.next()) {
				Integer vIdcommande = r.getInt("id_commande");
				Integer idLivre = r.getInt("id_livre");
				Integer quantite = r.getInt("quantite");
				Float prixUnitaire = r.getFloat("prixUnitaire");
				Boolean livree = r.getBoolean("commande_livree");
				int idclient = r.getInt("id_personne");
				String date = r.getDate("date_Commande").toString();
				DetailCommande detailcommande = new DetailCommande(idLivre, quantite);
				detailcommande.setCommandeValider(livree);
				detailcommande.setIdCommande(vIdcommande);
				detailcommande.setPrixUnitaire(prixUnitaire);
				detailcommande.setIdClient(idclient);
				detailcommande.setDatecmd(date);
				arraydetail.add(detailcommande);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arraydetail;
	}

}
