package com.librairie.ihm;

import java.util.ArrayList;
import java.util.Scanner;

import cda.libraire.idao.implementation.IDao;
import cda.librairie.dao.DaoAdresseImp;
import cda.librairie.dao.DaoLivreImp;
import cda.librairie.dao.DaoPersonneImp;
import model.Livre;
import model.Personne;
import outils.VerificationInscription;
import service.ServiceAdresse;
import service.ServiceConnexion;
import service.ServiceLivre;

public class Ihm {
	private static boolean continuer = true;
	private static String choix = "";
	private static Scanner sc = new Scanner(System.in);
	private static IDao daoPersonne = new DaoPersonneImp();
	private static IDao<Livre> daoLivre = new DaoLivreImp();
	private static IDao daoAdresse = new DaoAdresseImp();
	private static Personne personne;

	public Ihm() {
		System.out.println("1 - Connexion");
		System.out.println("2 - Inscription");
		System.out.println("3 - Lister les livres");
		System.out.print("> ");
		choix = sc.nextLine();
		switchReponse(choix);
	}

	private static void switchReponse(String c) {
		switch (c) {
		case "1":
			connexion();
			break;
		case "2":
			inscription();
			break;
		case "3":
			ServiceLivre.ListerLesLivres((ArrayList<Livre>) daoLivre.selectAll());
			break;
		default:
			break;
		}
	}

	private static void connexion() {
		System.out.print("Saisir le login: ");
		String login = sc.nextLine();
		System.out.print("Saisir le password: ");
		String password = sc.nextLine();
		personne = new ServiceConnexion().connexion((DaoPersonneImp) daoPersonne, login, password);
		if (personne != null) {
			if (personne.isActived()) {
				if (personne.isClient()) {
					menuClient();
				} else {
					menuLibraire();
				}
			} else {
				System.out.println("Le compte est inactif");
				connexion();
			}
		} else {
			System.out.println("Login ou Password incorrect.");
			connexion();
		}
	}

	private static void inscription() {
		VerificationInscription.initTableauInscription();
		DaoPersonneImp daoPersImp = new DaoPersonneImp();
		String vNom = "";
		String vPrenom = "";
		String vNumeroRue = "";
		String vNomRue = "";
		String vCodePostal = "";
		String vVille = "";
		String vLogin = "";
		String vPassword = "";
		String vPasswordConfirmation = "";

		do {
			System.out.println("Saisir le nom: ");
			System.out.print("> ");
			vNom = sc.nextLine();
			System.out.println(VerificationInscription.valideNom(vNom) + "\n");
		} while (!VerificationInscription.valideNom(vNom).equals("Nom valide."));
		VerificationInscription.validationInscription.remove(0);

		do {
			System.out.println("Saisir le prenom: ");
			System.out.print("> ");
			vPrenom = sc.nextLine();
			System.out.println(VerificationInscription.validePrenom(vPrenom) + "\n");
		} while (!VerificationInscription.validePrenom(vPrenom).equals("Prénom valide."));
		VerificationInscription.validationInscription.remove(0);

		do {
			System.out.println("Saisir le numero de la rue: ");
			System.out.print("> ");
			vNumeroRue = sc.nextLine();
			System.out.println(VerificationInscription.valideNumeroRue(vNumeroRue) + "\n");
		} while (!VerificationInscription.valideNumeroRue(vNumeroRue).equals("Numéro de rue valide."));
		VerificationInscription.validationInscription.remove(0);

		do {
			System.out.println("Saisir le nom de la rue : ");
			System.out.print("> ");
			vNomRue = sc.nextLine();
			System.out.println(VerificationInscription.valideNomRue(vNomRue) + "\n");
		} while (!VerificationInscription.valideNomRue(vNomRue).equals("Nom de rue valide."));
		VerificationInscription.validationInscription.remove(0);

		do {
			System.out.println("Saisir le code postal: ");
			System.out.print("> ");
			vCodePostal = sc.nextLine();
			System.out.println(VerificationInscription.valideCodePostal(vCodePostal) + "\n");
		} while (!VerificationInscription.valideCodePostal(vCodePostal).equals("Code postal valide."));
		VerificationInscription.validationInscription.remove(0);

		do {
			System.out.println("Saisir la ville: ");
			System.out.print("> ");
			vVille = sc.nextLine();
			System.out.println(VerificationInscription.valideVille(vVille) + "\n");
		} while (!VerificationInscription.valideVille(vVille).equals("Nom de ville valide."));
		VerificationInscription.validationInscription.remove(0);

		do {
			System.out.println("Saisir le login: ");
			System.out.print("> ");
			vLogin = sc.nextLine();
			if (daoPersImp.find(vLogin) != null) {
				System.out.println("Login déjà utilisé.\n");
			} else {
				System.out.println(VerificationInscription.valideLogin(vLogin) + "\n");
			}
		} while (!VerificationInscription.valideLogin(vLogin).equals("Login valide."));
		VerificationInscription.validationInscription.remove(0);

		do {
			System.out.println("Saisir le password: ");
			System.out.print("> ");
			vPassword = sc.nextLine();
			System.out.println("Confirmer le password: ");
			System.out.print("> ");
			vPasswordConfirmation = sc.nextLine();
			System.out.println(VerificationInscription.validePassword(vPassword, vPasswordConfirmation) + "\n");
		} while (!VerificationInscription.validePassword(vPassword, vPasswordConfirmation)
				.equals("Mot de passe valide."));
		VerificationInscription.validationInscription.remove(0);

		if (VerificationInscription.validationInscription.isEmpty()) {
			new ServiceAdresse().creerUneAdresse((DaoAdresseImp) daoAdresse, Integer.parseInt(vNumeroRue), vNomRue,
					Integer.parseInt(vCodePostal), vVille);
			new ServiceConnexion().inscription((DaoPersonneImp) daoPersonne, vNom, vPrenom,
					((DaoAdresseImp) daoAdresse).getIdAdresse(), vLogin, vPassword);
			System.out.println("Compte créé, en attente de validation par un libraire.");
		} else {
			System.out.println("Une erreur s'est produite à la création du compte.");
			System.out.println("Veuillez remplir le formulaire à nouveau.");
			inscription();
		}
	}

	private static void menuLibraire() {
		System.out.println("bienvenue libraire: " + personne.getNom());
		System.out.println("0 - Quitter");
		System.out.println("1 - Ajouter un nouveau livre");
		System.out.println("2 - Modifier quantité d'un livre");
		System.out.println("3 - Supprimer un livre");
		System.out.println("4 - Lister toute les commandes");
		System.out.println("5 - Modifier l'etat de la commande");
		System.out.print("> ");
		while (continuer) {
			choix = sc.nextLine();
			switch (choix) {
			case "0":
				continuer = false;
				System.out.println("Merci et a bientot.");
				break;
			case "1":
				System.out.print("Saisir le titre: ");
				String titre = sc.nextLine();
				System.out.print("Saisir le genre: ");
				String genre = sc.nextLine();
				System.out.print("Saisir l'auteur: ");
				String auteur = sc.nextLine();
				System.out.print("Saisir le prix: ");
				int prix = sc.nextInt();
				sc.nextLine();
				System.out.print("Saisir le nombre de page: ");
				int nbrePage = sc.nextInt();
				System.out.print("Saisir la quantite : ");
				int quantite = sc.nextInt();
				Livre vLivre = new Livre(titre, genre, auteur, prix, nbrePage, quantite);
				ServiceLivre.ajouterLivreAuStock((DaoLivreImp) daoLivre, vLivre);
				break;
			case "2":
				System.out.print("Saisissez l'id du livre : ");
				int id = sc.nextInt();
				System.out.println("Saisissez la nouvelle quantité");
				quantite = sc.nextInt();
				ServiceLivre.modifierQuantiteDuStock((DaoLivreImp) daoLivre, quantite, id);
				break;
			case "3":
				System.out.print("Saisissez l'id du livre : ");
				id = sc.nextInt();
				daoLivre.delete(daoLivre.find(Integer.toString(id)));
				break;
			case "4":
				break;
			case "5":
				break;
			default:
				break;
			}
		}

	}

	private static void menuClient() {
		System.out.println("bienvenue client : " + personne.getNom());
		System.out.println("0 - Quitter");
		System.out.println("1 - Passer une commande");
		System.out.println("2 - Lister mes commandes");
		System.out.println("3 - Annuler une commande");
		System.out.print("> ");
	}

}
