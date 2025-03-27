
package genie_lgiciel_tp.newpackage.com.projet.abstractclasssusage.interfaceusage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import genie_lgiciel_tp.newpackage.com.projets.connectionsample.ConnectionFactory;

public class Student implements Person {
	private int id;
	private String firstName;
	private String lastName;
	private String rollNumber;

	public Student() {
	}

	public Student(int id, String firstName, String lastName, String rollNumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.rollNumber = rollNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	@Override
	public void showIdentity() {
		System.out.println(String.format("Etudiant with ID [%s], Nom [%s], PostNom [%s], Matricule [%s]", id,
				firstName, lastName, rollNumber));
	}

	@Override
	public int add() throws SQLException {
		String sqlQuery = "INSERT INTO Etudiant(id,Nom,PostNom,Matricule) VALUES(?,?,?,?)";
		PreparedStatement ps = ConnectionFactory.getConnection(ConnectionFactory.MYSQL_CONNECTION)
				.prepareStatement(sqlQuery);
		ps.setInt(1, id);
		ps.setString(2, firstName);
		ps.setString(3, lastName);
		ps.setString(4, rollNumber);

		return ps.executeUpdate();
	}

	@Override
	public void showDynamicIdentity(int id) throws SQLException {
		String sqlQuery = "SELECT Etudiant.id, Etudiant.Nom, Etudiant.PostNom, Etudiant.Matricule FROM Etudiant WHERE Etudiant.id=?";
		try (PreparedStatement ps = ConnectionFactory.getConnection(ConnectionFactory.MYSQL_CONNECTION)
				.prepareStatement(sqlQuery)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					System.out.println(String.format(
							"Student with ID [%s], Nom [%s], PoatNom [%s], Matricule [%s]", rs.getInt("id"),
							rs.getString("Nom"), rs.getString("PostNom"), rs.getString("Matricule")));
				}
			}

		}

	}

}
