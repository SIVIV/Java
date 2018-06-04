package Connection_01;

import java.sql.*;

public class Exercise {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/soft_uni";
        String user = "root";
        String password = "";

        // open all
        Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM projects");
        ResultSet rs = pStatement.executeQuery();

        while (rs.next()) {
            System.out.print(rs.getString("project_id") + " ");
            System.out.println(rs.getString("name"));
        }

        // close all in reverse order
        rs.close();
        pStatement.closeOnCompletion();
        connection.close();
    }

}
