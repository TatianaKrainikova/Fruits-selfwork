package app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {

    public static Connection connect() {
        String dbDriver = Constants.DB_DRIVER;
        String dbBaseUrl = Constants.DB_BASE_URL;
        String dbName = Constants.DB_NAME;
        String url = dbDriver + dbBaseUrl + dbName;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }
}
