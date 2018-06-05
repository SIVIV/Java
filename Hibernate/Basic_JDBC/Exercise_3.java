package Connection_01;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Exercise_3 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/exercise_2?createDatabaseIfNotExist=true";
        String user = "root";
        String password = "";

        String query = "SELECT * FROM ourTable;";

        // open all
        Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement pStatement = connection.prepareStatement(query);
        ResultSet rs = pStatement.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();

        int columnCount = rsmd.getColumnCount();
        while (rs.next()) {
            Map<String, Object> resultMap = new HashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                String column = rsmd.getColumnLabel(i);
                Object value = rs.getObject(i);
                resultMap.put(column, value);
            }
        }

        // close all in reverse order
        pStatement.closeOnCompletion();
        connection.close();
    }
}
