package service;

import java.util.ArrayList;

import model.Livre;

public class ServiceLivre {

	public static void ListerLesLivres(ArrayList<Livre> pArray) {
		System.out.format("%5s%50s%15s%35s%15s%10s%n", "ID", "Titre", "Auteur", "Genre", "Nombre Page", "Prix");
		for (Livre livre : pArray) {
			System.out.format("%5s%50s%15s%35s%15s%10s%n", livre.getIdentifiant(), livre.getTitre(), livre.getAuteur(),
					livre.getGenre(), livre.getNbrePage(), livre.getPrix());
		}
	}
}