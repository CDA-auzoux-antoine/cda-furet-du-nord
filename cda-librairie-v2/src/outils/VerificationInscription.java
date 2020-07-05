package outils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificationInscription {
	public static List<Integer> validationInscription = new ArrayList<>();
	private static Pattern p = Pattern.compile("^[a-z]+[[-]?[a-z]+]+$");
	private static Matcher m;
	static String ok = "valide";

	public static void initTableauInscription() { // à initialiser en premier sur le formulaire d'inscription
		for (int i = 0; i < 8; i++) {
			validationInscription.add(i);
		}
	}

	// 0
	public static String valideNom(String pNom) {
		m = p.matcher(pNom);

		if (pNom == null || pNom.trim().length() == 0) {
			// Nom d'utilisateur requis
			return "Nom d'utilisateur requis";
		} else if (pNom != null && pNom.trim().length() < 2) {
			// Le nom doit contenir au moins 2 caractères
			return "Le nom doit contenir au minimum 2 caractères";
		} else if (!(m.find())) {
			// Le nom est incorrect
			return "Le nom est incorrect";
		} else {
			return "Nom valide.";
		}
	}

	// 1
	public static String validePrenom(String pPrenom) {
		m = p.matcher(pPrenom);

		if (pPrenom == null || pPrenom.trim().length() == 0) {
			// Prénom d'utilisateur requis
			return "Prénom requis.";
		} else if (pPrenom != null && pPrenom.trim().length() < 2) {
			// Le prénom doit contenir au moins 2 caractères
			return "Le prénom doit contenir au moins 2 caractères.";
		} else if (!(m.find())) {
			// Le prénom est incorrect
			return "Le prénom est incorrect.";
		} else {
			return "Prénom valide.";
		}
	}

	// 2
	public static String valideNumeroRue(String pNumeroRue) {

		if (pNumeroRue == null || pNumeroRue.trim().length() == 0) {
			// Numéro de rue requis
			return "Numéro de rue requis.";
		} else if (!(Pattern.matches("^[\\d]+$", pNumeroRue)) || Integer.parseInt(pNumeroRue) < 0) {
			// Le nom de rue est incorrect
			return "Le numéro de la rue est incorrect.";
		} else {
			return "Numéro de rue valide.";
		}
	}

	// 3
	public static String valideNomRue(String pNomRue) {

		if (pNomRue == null || pNomRue.trim().length() == 0) {
			// Nom de rue requis
			return "Nom de rue requis.";
		} else {
			return "Nom de rue valide.";
		}
	}

	// 4
	public static String valideCodePostal(String pCodePostal) {

		if (pCodePostal == null || pCodePostal.trim().length() == 0) {
			// Code postal requis
			return "Code postal requis.";
		} else if (!(Pattern.matches("^[\\d]+$", pCodePostal)) || Integer.parseInt(pCodePostal) < 0) {
			// Le code postal est incorrect
			return "Le code postal est incorrect";
		} else {
			return "Code postal valide.";
		}
	}

	// 5
	public static String valideVille(String pNomVille) {

		if (pNomVille == null || pNomVille.trim().length() == 0) {
			// Nom de ville requis
			return "Nom de ville requis.";
		} else if (Pattern.matches("^[\\d]+$", pNomVille)) {
			// Le nom de la ville est incorrect
			return "Le nom de la ville est incorrect.";
		} else {
			return "Nom de ville valide.";
		}
	}

	// 6
	public static String valideLogin(String pLogin) {
		if (pLogin == null && pLogin.trim().length() == 0) {
			// Login requis
			return "Login requis.";
		} else {
			return "Login valide.";
		}
	}

	// 7
	public static String validePassword(String pPassword, String pPasswordConfirmation) {

		if (pPassword != null && pPasswordConfirmation != null) {
			if (!pPassword.equals(pPasswordConfirmation)) {
				// Les mots de passe sont différents
				return "Les mots de passe sont différents";
			} else if (pPassword.length() < 5) {
				// Les mots de passe doivent contenir au moins 5 caractères
				return "Le mot de passe doit contenir au moins 5 caractères";
			}
		} else if (pPassword == null) {
			// Merci de saisir et confirmer votre mot de passe
			return "Merci de saisir et confirmer votre mot de passe.";
		}
		return "Mot de passe valide.";
	}
}
