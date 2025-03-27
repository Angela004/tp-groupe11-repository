package genie_lgiciel_tp.newpackage.com.projet.abstractclasssusage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import genie_lgiciel_tp.newpackage.com.projets.connectionsample.ConnectionFactory;

public class Employee extends Person {
    private String cnss;
    public Employee() {}
    public Employee(int id, String firstName, String lastName, String cnss) {
        super(id, firstName, lastName);
        this.cnss = cnss;
    }
    public String getCnss() {
        return cnss;}
    public void setCnss(String cnss) {
        this.cnss = cnss;}
    @Override
    public void showIdentity() {
        System.out.println(String.format("Employee with ID [%s], Nom [%s], PostNom [%s], Social security [%s]",
                id, firstName, lastName, cnss));
    }
    @Override
    public int add(Person p) throws SQLException {
        String sqlQuery = "INSERT INTO employee(id, Nom, PostNom, cnss) VALUES(?,?,?,?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection(ConnectionFactory.MYSQL_CONNECTION)
                .prepareStatement(sqlQuery)) {
            ps.setInt(1, p.getId());
            ps.setString(2, p.getFirstName());
            ps.setString(3, p.getLastName());
            ps.setString(4, ((Employee) p).getCnss());
            return ps.executeUpdate();
        }
    }
    @Override
    public void showDynamicIdentity(int id) throws SQLException {
        String sqlQuery = "SELECT id, Nom, PostNom, cnss FROM employee WHERE id=?";
        try (PreparedStatement ps = ConnectionFactory.getConnection(ConnectionFactory.MYSQL_CONNECTION)
                .prepareStatement(sqlQuery)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println(String.format("Employee with ID [%s], Nom [%s], PostNom [%s], Social security [%s]",
                            rs.getInt("id"), rs.getString("Nom"), rs.getString("PostNom"),
                            rs.getString("cnss")));
                }
            }
        }
    }
}
