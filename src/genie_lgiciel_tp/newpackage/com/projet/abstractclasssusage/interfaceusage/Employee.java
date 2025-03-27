package genie_lgiciel_tp.newpackage.com.projet.abstractclasssusage.interfaceusage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import genie_lgiciel_tp.newpackage.com.projets.connectionsample.ConnectionFactory;
public class Employee implements Person {
	private int id;
	private String firstName;
	private String lastName;
	private String cnss;

	public Employee() {
	}

	public Employee(int id, String firstName, String lastName, String cnss) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cnss = cnss;
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

	public String getCnss() {
		return cnss;
	}

	public void setCnss(String cnss) {
		this.cnss = cnss;
	}

	@Override
	public void showIdentity() {
		System.out.println(String.format("Employee with ID [%s], Nom [%s], PostNom [%s], Social Security [%s]",
				id, firstName, lastName, cnss));
	}

	@Override
	public void showDynamicIdentity(int id) throws SQLException {
		String sqlQuery = "Select employee.id, employee.Nom, employee.PostNom, employee.cnss FROM employee WHERE employee.id=?";
		try (PreparedStatement ps = ConnectionFactory.getConnection(ConnectionFactory.MYSQL_CONNECTION)
				.prepareStatement(sqlQuery)) {
			ps.setInt(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					System.out.println(
							String.format("Employee with ID [%s], Nom [%s], PostNom [%s], Social Security [%s]",
									rs.getInt("id"), rs.getString("Nom"), rs.getString("PostNom"),
									rs.getString("cnss")));
				}
			}
		}
	}

	@Override
	public int add() throws SQLException {
		String sqlQuery = "INSERT INTO employee(id,Nom,PostNom,cnss) VALUES(?,?,?,?)";
		try (PreparedStatement ps = ConnectionFactory.getConnection(ConnectionFactory.MYSQL_CONNECTION)
				.prepareStatement(sqlQuery)) {
			ps.setInt(1, id);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, cnss);
			return ps.executeUpdate();
		}
	}
}
