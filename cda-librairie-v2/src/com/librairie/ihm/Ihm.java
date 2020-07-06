package com.librairie.ihm;

import java.util.ArrayList;
import java.util.Scanner;

import cda.libraire.idao.implementation.IDao;
import cda.librairie.dao.DaoAdresseImp;
import cda.librairie.dao.DaoCommande;
import cda.librairie.dao.DaoDetailCommande;
import cda.librairie.dao.DaoLivreImp;
import cda.librairie.dao.DaoPersonneImp;
import model.Livre;
import model.Personne;
import outils.VerificationInscription;
import service.ServiceAdresse;
import service.ServiceConnexion;

public class Ihm {
	public static boolean continuer = true;
	public static String choix = "";
	public static Scanner sc = new Scanner(System.in);
	public static IDao daoPersonne = new DaoPersonneImp();
	public static IDao daoLivre = new DaoLivreImp();
	public static IDao daoAdresse = new DaoAdresseImp();
	public static IDao daoDetail = new DaoDetailCommande();
	public static IDao daoCommande = new DaoCommande();
	public static Personne personne;

	public Ihm() {
		do {
			System.out.println("0 - Quitter");
			System.out.println("1 - Connexion");
			System.out.println("2 - Inscription");
			System.out.println("3 - Lister les livres");
			System.out.print("> ");
			choix = sc.nextLine();
			switchReponse(choix);
		} while (!choix.equals("0"));
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

			listerLesLivres();
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
					IhmClient.menuClient();
				} else {
					IhmLibraire.menuLibraire();
//					menuLibraire();
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
		} while (!VerificationInscription.validePrenom(vPrenom).equals("Pr�nom valide."));
		VerificationInscription.validationInscription.remove(0);

		do {
			System.out.println("Saisir le numero de la rue: ");
			System.out.print("> ");
			vNumeroRue = sc.nextLine();
			System.out.println(VerificationInscription.valideNumeroRue(vNumeroRue) + "\n");
		} while (!VerificationInscription.valideNumeroRue(vNumeroRue).equals("Num�ro de rue valide."));
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
				System.out.println("Login d�j� utilis�.\n");
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
			System.out.println("Compte cr��, en attente de validation par un libraire.");
		} else {
			System.out.println("Une erreur s'est produite � la cr�ation du compte.");
			System.out.println("Veuillez remplir le formulaire � nouveau.");
			inscription();
		}
	}

	private static void menuLibraire() {

	}

	public static void listerLesLivres() {
		System.out.format("%5s%50s%15s%35s%15s%10s%n", "ID", "Titre", "Auteur", "Genre", "Nombre Page", "Prix");
		for (Livre livre : (ArrayList<Livre>) daoLivre.selectAll()) {
			System.out.format("%5s%50s%15s%35s%15s%10s%n", livre.getIdentifiant(), livre.getTitre(), livre.getAuteur(),
					livre.getGenre(), livre.getNbrePage(), livre.getPrix());
		}
	}

}
