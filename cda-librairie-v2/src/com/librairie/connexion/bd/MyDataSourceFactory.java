package com.librairie.connexion.bd;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.mariadb.jdbc.MariaDbDataSource;

public class MyDataSourceFactory {

	public static DataSource getMariaDb() {
		Properties properties = new Properties();
		FileInputStream file = null;
		MariaDbDataSource mariaDbSource = null;

		try {
			file = new FileInputStream("ressources/db.properties");
			properties.load(file);
			mariaDbSource = new MariaDbDataSource();
			mariaDbSource.setUrl(properties.getProperty("url"));
			mariaDbSource.setUser(properties.getProperty("user"));
			mariaDbSource.setPassword(properties.getProperty("password"));

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return mariaDbSource;
	}
}
