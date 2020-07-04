package com.librairie.connexion.bd;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MyConnection {// nous retourne la connexion Ã  la bdd

	private static Connection connexion = null;

	private MyConnection() {
		DataSource dataSource = MyDataSourceFactory.getMariaDb();

		try {
			connexion = dataSource.getConnection();
			System.out.println("connecté");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnexion() {
		if (connexion == null) {
			new MyConnection();
		}
		return connexion;
	}
}
