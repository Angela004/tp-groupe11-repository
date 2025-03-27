
package genie_lgiciel_tp.newpackage.com.projet.abstractclasssusage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import genie_lgiciel_tp.newpackage.com.projets.connectionsample.ConnectionFactory;
public class Student extends Person {
	private String rollNumber;

	public Student() {
	}
	public Student(int id, String firstName, String lastName, String rollNumber) {
		super(id, firstName, lastName);
		this.rollNumber = rollNumber;
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
	public int add(Person p) throws SQLException {
		String sqlQuery = "INSERT INTO Etudiant(id,Nom,PostNom,Matricule) VALUES(?,?,?,?)";
		try (PreparedStatement ps = ConnectionFactory.getConnection(ConnectionFactory.MYSQL_CONNECTION)
				.prepareStatement(sqlQuery)) {
			ps.setInt(1, p.getId());
			ps.setString(2, p.getFirstName());
			ps.setString(3, p.getLastName());
			ps.setString(4, ((Student) p).getRollNumber());
			return ps.executeUpdate();
		}
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
							"Etudiant with ID [%s], Nom [%s], PostNom [%s], Matricule [%s]", rs.getInt("id"),
							rs.getString("Nom"), rs.getString("PostNom"), rs.getString("Matricule")));
				}
			}

		}
	}

}
