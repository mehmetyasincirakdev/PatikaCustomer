package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Database instance = null;
    private Connection connection = null;
    private final String DB_URL = "jdbc:mysql://localhost:3306/customerManage";
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORD = "3652";

    private Database() throws SQLException {
        this.connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    private Connection getConnection() {
        return connection;
    }

    public static Connection getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new Database();
        }
        
        return instance.getConnection();
    }
}
