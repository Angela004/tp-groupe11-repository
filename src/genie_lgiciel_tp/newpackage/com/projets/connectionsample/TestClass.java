
package genie_lgiciel_tp.newpackage.com.projets.connectionsample;

import java.sql.Connection;
import java.sql.SQLException;

public class TestClass {

	public static void main(String[] args) {
		try {
			// Create connection through the ConnectionFactory class that use the Singleton
			// Pattern to hold the connection object
			Connection con = ConnectionFactory.getConnection(ConnectionFactory.MYSQL_CONNECTION);
			System.out.println(String.format("%s %s With Connection string: %s", "Successfully connected to the database",
							con.getMetaData().getDatabaseProductName(), con.toString()));
			// Print connection string value
			System.out.println(ConnectionFactory.getConnection(ConnectionFactory.MYSQL_CONNECTION).toString());
		} catch (SQLException e) {
			System.out.println("Impossible de se connecter a la base de donnee");
			e.printStackTrace();
		}
	}

}
