
package TP.groupe11.newpackage.com.projets.connectionsample;


import java.sql.Connection;
import java.sql.SQLException;

public interface IConnection {
	Connection getConnection() throws SQLException;
}

