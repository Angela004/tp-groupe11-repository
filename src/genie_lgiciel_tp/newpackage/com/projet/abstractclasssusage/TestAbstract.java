package genie_lgiciel_tp.newpackage.com.projet.abstractclasssusage;

import java.sql.Connection;
import java.sql.SQLException;
import genie_lgiciel_tp.newpackage.com.projets.connectionsample.ConnectionFactory;

public class TestAbstract {

    public static void main(String[] args) {
        try {
            //Premier employé
            Person e1 = new Employee();
            e1.setId(1);
            e1.setFirstName("KATHUNGU");
            e1.setLastName("AKEMANI");
            ((Employee) e1).setCnss("23LIAGELJ1070766");
            int result1 = e1.add(e1);
            if (result1 > 0) {
                System.out.println("Employee 1 inserer avec succes!");
            } else {
                System.out.println("L'insertion de l'employe 1 a echoué.");
            }
            // Deuxième employé
            Person e2 = new Employee();
            e2.setId(2);
            e2.setFirstName("KIBISWA");
            e2.setLastName("VABENE");
            ((Employee) e2).setCnss("21IGGJ129477");

            int result2 = e2.add(e2);
            if (result2 > 0) {
                System.out.println("Employee 2 inserer avec succes!");
            } else {
                System.out.println("L'insertion de l'employe 2 a echoué.");
            }
            
            

            // Premier étudiant
            Person et1 = new Student(
                    1, "KATHUNGU",
                    "AKEMANI",
                    "23LIAGELJ1070766"
            );
            int result3 = et1.add(et1);
            if (result3 > 0) {
                System.out.println("L'etudiant 1 inserer avec succes!");
            } else {
                System.out.println(" ️L'insertion de l'etudiant 1 a echoué.");
            }

            // Deuxième étudiant
            Person et2 = new Student(
                    2, "KAVIRA",
                    "LUMUMBI",
                    "22LSILJ700207"
            );
            int result4 = et2.add(et2);
            if (result4 > 0) {
                System.out.println("L'etudiant 2 inserer avec succes!");
            } else {
                System.out.println("L'insertion de l'etudiant 2 a echoué.");
            }
            //Troisieme étudiant
            Person et3 = new Student(
                    3, "KAVIRA",
                    "KATSUNUNDU", 
                    "23LIAGELJ1070793"
            );
            int result5 = et3.add(et3);
            if (result5 > 0) {
                System.out.println("L'etudiant 3 inserer avec succes!");
            } else {
                System.out.println("L'insertion de l'etudiant 3 a echoué.");
            }
            //Quatrieme étudiant
            Person et4 = new Student(
                    4,
                    "KIBANJU", 
                    "KABANGWA",
                    "23LIAGELJ1070476"
            );
            int result6 = et4.add(et4);
            if (result6 > 0) {
                System.out.println("L'etudiant 4 inserer avec succes!");
            } else {
                System.out.println("L'insertion de l'etudiant 4 a echoué.");
            }
            //Cinquieme étudiant
            Person et5 = new Student(
                    5,
                    "KATUMWA",
                    "RUGISHI", 
                    "20IGGJ009074"
            );
            int result7 = et5.add(et5);
            if (result7 > 0) {
                System.out.println("L'etudiant 5 inserer avec succes!");
            } else {
                System.out.println("L'insertion de l'etudiant 5 a echoué.");
            }
            //Sixieme étudiant
            Person et6 = new Student(
                    6, 
                    "KATUNGU", 
                    "KAVUNO", 
                    "23LIAGELJ1070639"
            );
            int result8 = et6.add(et6);
            if (result8 > 0) {
                System.out.println("L'etudiant 6 inserer avec succes!");
            } else {
                System.out.println("L'insertion de l'etudiant 6 a echoué.");
            }
            //Septieme étudiant
            Person et7 = new Student(
                    7, 
                    "KIBISWA", 
                    "VABENE", 
                    "21IGGJ129477"
            );
            int result9 = et7.add(et7);
            if (result9 > 0) {
                System.out.println("L'etudiant 7 inserer avec succes!");
            } else {
                System.out.println("L'insertion de l'etudiant 7 a echoué.");
            }
            //Huitieme étudiant
            Person et8 = new Student(
                    8, 
                    "KAVUGHO", 
                    "KABANGWA", 
                    "22LSILJ690220"
            );
            int result10 = et8.add(et8);
            if (result10 > 0) {
                System.out.println("L'etudiant 8 inserer avec succes!");
            } else {
                System.out.println("L'insertion de l'etudiant 8 a echoué.");
            }

            // Affichager employes et étudiants
            System.out.println("\n  Les employees inserer:");
            e1.showDynamicIdentity(e1.getId());
            System.out.println("-----------------------------------------");
            e2.showDynamicIdentity(e2.getId());
            System.out.println("-----------------------------------------");

            System.out.println("\n Les etudiants inserer : ");
            et1.showDynamicIdentity(et1.getId());
            System.out.println("------------------------------------------");
            et2.showDynamicIdentity(et2.getId());
            System.out.println("-----------------------------------------");
            et3.showDynamicIdentity(et3.getId());
            System.out.println("------------------------------------------");
            et4.showDynamicIdentity(et4.getId());
            System.out.println("-----------------------------------------");
            et5.showDynamicIdentity(et5.getId());
            System.out.println("------------------------------------------");
            et6.showDynamicIdentity(et6.getId());
            System.out.println("-----------------------------------------");
            et7.showDynamicIdentity(et7.getId());
            System.out.println("------------------------------------------");
            et8.showDynamicIdentity(et8.getId());
            System.out.println("-----------------------------------------");

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'insertion des données dans la base de données !");
            e.printStackTrace();
        } finally {
            // Fermeture propre de la connexion
            try (Connection connection = ConnectionFactory.getConnection(ConnectionFactory.MYSQL_CONNECTION)) {
                if (connection != null) {
                    System.out.println("Connection Fermé avec succes.");
                }
            } catch (Exception e2) {
                System.out.println("Problème lors de la fermeture de la connexion.");
                e2.printStackTrace();
            }
        }
    }
}
