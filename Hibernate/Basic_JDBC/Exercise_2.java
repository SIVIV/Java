package Connection_01;

import java.sql.*;

public class Exercise_2 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/exercise_2?createDatabaseIfNotExist=true";
        String user = "root";
        String password = "";

        String query1 = "CREATE TABLE myTable(" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(20)," +
                "description VARCHAR(255));";

        String query2 = "CREATE TABLE ourTable(" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(20)," +
                "chinese_fortune_cookies VARCHAR(255));";

        String query3 = "ALTER TABLE myTable " +
                "ADD CONSTRAINT fk_foreign_key " +
                "FOREIGN KEY(id) " +
                "REFERENCES ourTable(id);";

        String query4 = "INSERT INTO ourTable (name, chinese_fortune_cookies) " +
                "VALUES('Toshko', 'Meh')," +
                "('Goshko', 'Ok')," +
                "('Sashko', 'Nice')," +
                "('Peshko', 'Good')," +
                "('Stoyanko', 'AWESOME');";


        // open all
        Connection connection = DriverManager.getConnection(url, user, password);
        //PreparedStatement pStatement = connection.prepareStatement(query1);
        //PreparedStatement pStatement = connection.prepareStatement(query2);
        //PreparedStatement pStatement = connection.prepareStatement(query3);
        PreparedStatement pStatement = connection.prepareStatement(query4);


        int affectedRows = pStatement.executeUpdate();
        if (affectedRows != 0) {
            System.out.println("Done. Affected rows: " + affectedRows);
        }

        // close all in reverse order
        pStatement.closeOnCompletion();
        connection.close();
    }
}
