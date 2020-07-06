package exec;

import com.librairie.connexion.bd.MyConnection;
import com.librairie.ihm.Ihm;

public class Prog {
	public static void main(String[] args) {
		MyConnection.getConnexion();
		new Ihm();

		// -Dlogin.conf=ressources/db.properties

	}
}
