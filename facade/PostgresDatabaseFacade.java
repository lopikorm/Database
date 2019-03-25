/*package com.company.facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDatabaseFacade {
    private final String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
    private final String user = "postgres";
    private final String pass = "sewer736";

    private Connection connection;

    public PostgresDatabaseFacade() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("No driver for PostgreSQL found");
            cnfe.printStackTrace();
        }

        public Connection getConnection () {
            return connection;
        }
    }

}
    try {
        Class.forName("org.postgresql.Driver");

    }
       catch(ClassNotFoundException cnfe){

        System.out.println("No driver for PostgreSQL found");
        cnfe.printStackTrace();
        return;
    }
        try {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "sewer736");

        connection.close();
    }catch (
    SQLException sqle){
        System.out.println(sqle.getMessage());
        System.out.println("No connection");
    }
}
package Study;

        import java.sql.*;

public class Connect {

    //  String className = "org.postgresql.Driver";
    private final String url = "jdbc:postgresql://127.0.0.1:5432/newbd";
    private final String user = "postgres";
    private final String pass = "user";

    private Connection connection;

    public Connect() {
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}*/