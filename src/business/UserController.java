package business;

import core.Helper;
import dao.UserDao;
import entity.User;

import java.sql.SQLException;

public class UserController {
    private final UserDao userDao = new UserDao();

    public UserController() throws SQLException {
    }

    public User findByLogin(String mail, String password) {
        if (!Helper.isEmailValid(mail)) return null;
        return this.userDao.findByLogin(mail, password);
    }
}
