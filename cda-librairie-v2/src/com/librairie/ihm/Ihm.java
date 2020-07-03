package com.librairie.ihm;

import java.util.Scanner;

import cda.libraire.idao.implementation.IDao;
import cda.librairie.dao.DaoLivreImp;
import cda.librairie.dao.DaoPersonneImp;
import service.ServiceConnexion;
import service.ServiceLivre;

public class Ihm {
	private static String choix = "";
	private static Scanner sc = new Scanner(System.in);
	static IDao daoPersonne = new DaoPersonneImp();
	static IDao daoLivre = new DaoLivreImp();

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
			ServiceLivre.ListerLesLivres();
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
		if (new ServiceConnexion().connexion(daoPersonne, login, password) != null) {
			// connct�

		} else {
			System.out.println("Login ou Password incorrect ! ");
			connexion();
		}
	}

	private static void inscription() {
		System.out.print("Saisir le login: ");
		String login = sc.nextLine();
		System.out.print("Saisir le password: ");
		String password = sc.nextLine();
		System.out.print("Saisir le nom: ");
		String nom = sc.nextLine();
		System.out.print("Saisir le prenom: ");
		String prenom = sc.nextLine();
		System.out.print("Saisir le numero de la rue: ");
		String nRue = sc.nextLine();
		System.out.print("Saisir le le nom de la rue : ");
		String nomRue = sc.nextLine();
		System.out.print("Saisir le code postal: ");
		String codePostal = sc.nextLine();
		new ServiceConnexion().inscription(daoPersonne, login, password);
	}

	private static void MenuLibraire() {

	}

	private static void MenuClient() {

	}

}
