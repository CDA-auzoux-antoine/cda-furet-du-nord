package com.librairie.ihm;

import java.util.ArrayList;

import cda.librairie.dao.DaoCommande;
import cda.librairie.dao.DaoDetailCommande;
import cda.librairie.dao.DaoLivreImp;
import model.DetailCommande;
import model.Livre;
import service.ServiceCommande;
import service.ServiceDetailCommande;

public class IhmClient {

	public static void menuClient() {

		do {
			System.out.println("bienvenue client : " + Ihm.personne.getNom());
			System.out.println("0 - Quitter");
			System.out.println("1 - Ajouter livre au panier");
			System.out.println("2 - Afficher mon panier");
			System.out.println("3 - Effacer livre du panier");
			System.out.println("4 - Effacer le panier");
			System.out.println("5 - Valider ma commande");
			System.out.println("6 - Afficher mes commandes");
			System.out.println("7 - Annuler commande");
			System.out.println("8 - Lister les livres");
			System.out.print("> ");
			Ihm.choix = Ihm.sc.nextLine();
			switch (Ihm.choix) {
			case "0":
				Ihm.continuer = false;
				System.out.println("Merci et a bientot.");
				break;
			case "1":
				System.out.println("saisissez l'id du livre : ");
				String id = Ihm.sc.nextLine();
				System.out.println("saisissez la quantit� : ");
				int quant = Ihm.sc.nextInt();
				quant += DetailCommande.commande.getOrDefault(((Livre) Ihm.daoLivre.find(id)), 0);
				DetailCommande.commande.put((Livre) Ihm.daoLivre.find(id), quant);
				break;
			case "2":
				ServiceDetailCommande.afficherMonPanier((DaoLivreImp) Ihm.daoLivre);// a implementer
				break;
			case "3":
				System.out.println("saisissez l'id du livre a supprimer");
				id = Ihm.sc.nextLine();
				DetailCommande.commande.remove((Livre) Ihm.daoLivre.find(id));
				break;
			case "4":
				DetailCommande.commande.clear();
				break;
			case "5":
				int idCommande = ServiceCommande.creerCommande((DaoCommande) Ihm.daoCommande, Ihm.personne);
				ServiceDetailCommande.validerMonPanier((DaoDetailCommande) Ihm.daoDetail, Ihm.personne, idCommande);
				DetailCommande.commande.clear();
				break;
			case "6":
				for (DetailCommande mesCmd : (ArrayList<DetailCommande>) Ihm.daoDetail.selectAll()) {
					if (mesCmd.getIdClient() == Ihm.personne.getId()) {
						System.out.print(mesCmd.getIdCommande() + " :");
						System.out.print(((Livre) Ihm.daoLivre.find(mesCmd.getLivre() + "")).getTitre() + " ");
						System.out.println(mesCmd.getQuantite());
					}
				}
				break;
			case "7":
				System.out.println("taper l'id commande a annul�");
				id = Ihm.sc.nextLine();
				Ihm.daoDetail.delete(Ihm.daoDetail.find(id));
				break;
			case "8":
				Ihm.listerLesLivres();
				break;

			default:
				break;
			}

		} while (Ihm.continuer);
	}
}
