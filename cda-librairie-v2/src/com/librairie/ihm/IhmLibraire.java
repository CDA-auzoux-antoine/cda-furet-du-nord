package com.librairie.ihm;

import java.util.ArrayList;

import cda.librairie.dao.DaoDetailCommande;
import cda.librairie.dao.DaoLivreImp;
import cda.librairie.dao.DaoPersonneImp;
import model.DetailCommande;
import model.Livre;
import model.Personne;
import service.ServiceLibraire;
import service.ServiceLivre;

public class IhmLibraire {

	public static void menuLibraire() {
		System.out.println("bienvenue libraire: " + Ihm.personne.getNom());

		do {
			System.out.println("0 - Quitter");
			System.out.println("1 - Ajouter un nouveau livre");
			System.out.println("2 - Modifier quantit� d'un livre");
			System.out.println("3 - Supprimer un livre");
			System.out.println("4 - Lister toute les commandes");
			System.out.println("5 - Lister les commandes en attente de livraison");
			System.out.println("6 - Livrer une la commande");
			System.out.println("7 - Lister les comptes en attente de confirmation");
			System.out.println("8 - Activer un compte");
			System.out.println("9 - Supprimer une demande");
			System.out.println("10 - Livrer les livres");

			System.out.print("> ");
			Ihm.choix = Ihm.sc.nextLine();
			switch (Ihm.choix) {
			case "0":
				Ihm.continuer = false;
				System.out.println("Merci et a bientot.");
				break;
			case "1":
				System.out.print("Saisir le titre: ");
				String titre = Ihm.sc.nextLine();
				System.out.print("Saisir le genre: ");
				String genre = Ihm.sc.nextLine();
				System.out.print("Saisir l'auteur: ");
				String auteur = Ihm.sc.nextLine();
				System.out.print("Saisir le prix: ");
				int prix = Ihm.sc.nextInt();
				Ihm.sc.nextLine();
				System.out.print("Saisir le nombre de page: ");
				int nbrePage = Ihm.sc.nextInt();
				System.out.print("Saisir la quantite : ");
				int quantite = Ihm.sc.nextInt();
				Livre vLivre = new Livre(titre, genre, auteur, prix, nbrePage, quantite);
				ServiceLivre.ajouterLivreAuStock((DaoLivreImp) Ihm.daoLivre, vLivre);
				break;
			case "2":

				System.out.print("Saisissez l'id du livre : ");
				int id = Ihm.sc.nextInt();
				System.out.println("Saisissez la nouvelle quantit�");
				quantite = Ihm.sc.nextInt();
				ServiceLivre.modifierQuantiteDuStock((DaoLivreImp) Ihm.daoLivre, quantite, id);
				break;
			case "3":
				System.out.print("Saisissez l'id du livre : ");
				id = Ihm.sc.nextInt();
				Ihm.daoLivre.delete(Ihm.daoLivre.find(Integer.toString(id)));
				break;
			case "4":
				for (DetailCommande cmd : (ArrayList<DetailCommande>) Ihm.daoDetail.selectAll()) {
					System.out.println(cmd.getIdClient() + " " + cmd.getIdCommande() + " "
							+ (cmd.isCommandeValider() ? "Livrée" : "Non livrée"));
				}
				System.out.println("fin");
				break;
			case "5":
				for (DetailCommande cmd : (ArrayList<DetailCommande>) Ihm.daoDetail.selectAll()) {
					if (!cmd.isCommandeValider()) {
						System.out.println(cmd.getIdClient() + " " + cmd.getIdCommande() + " " + "Non livrée");
					}
				}
				break;
			case "6":
				System.out.print("saisir l'id de la commande: ");
				ServiceLibraire.LivrerUneCommande((DaoDetailCommande) Ihm.daoDetail, Ihm.sc.nextLine());
				break;
			case "7":
				for (Personne personne : (ArrayList<Personne>) Ihm.daoPersonne.selectAll()) {
					if (!personne.isActived()) {
						System.out.println(personne.getId() + " " + personne.getLogin() + " " + personne.getNom() + " "
								+ personne.getPrenom() + " inactif");
					}
				}

				break;
			case "8":
				System.out.print("Saisir le login: ");
				ServiceLibraire.validerDemande((DaoPersonneImp) Ihm.daoPersonne, Ihm.sc.nextLine());
				break;
			case "9":
				System.out.print("Saisir le login: ");
				ServiceLibraire.supprimerDemande((DaoPersonneImp) Ihm.daoPersonne, Ihm.sc.nextLine());
				break;
			case "10":
				Ihm.listerLesLivres();
				break;

			default:
				break;
			}
		} while (Ihm.continuer);
	}

}
