import core.Helper;
import view.LoginUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        Helper.setTheme();
        LoginUI loginUI = new LoginUI();
    }
}

