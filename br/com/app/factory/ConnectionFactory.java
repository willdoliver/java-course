package br.com.app.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/java-jdbc";

    public static Connection createConnectionToMySQL() throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        return connection;
    }

    public static void main(String[] args) throws Exception {
        Connection conn = createConnectionToMySQL();

        if (conn!=null) {
            System.out.println("Connected successfully");
            conn.close();
        }
    }

}
