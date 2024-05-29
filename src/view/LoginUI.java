package view;

import business.UserController;
import core.Helper;
import entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginUI extends JFrame {
    private JPanel container;
    private JPanel pnl_top;
    private JLabel lbl_title;
    private JPanel pnl_bottom;
    private JTextField fld_mail;
    private JButton btn_login;
    private JLabel lbl_mail;
    private JLabel lbl_password;
    private JPasswordField fld_password;
    private UserController userController;

    public LoginUI() throws SQLException {
        this.userController = new UserController();
        this.add(container);
        this.setTitle("Müşteri Yönetim Sistemi");
        this.setSize(400, 400);
        this.setVisible(true);
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2;
        this.setLocation(x, y);

        this.btn_login.addActionListener(e -> {
            if (!Helper.isEmailValid(this.fld_mail.getText())) {
                Helper.showInfoMessage("Geçerli bir eposta adresi giriniz.");
            } else if (Helper.isFieldListEmpty(new JTextField[]{fld_mail, fld_password})) {
                Helper.showInfoMessage("fill");

            } else {
                User user = this.userController.findByLogin(this.fld_mail.getText(), this.fld_password.getText());
                if (user == null) {
                    Helper.showInfoMessage("Girdiğiniz bilgilere göre kullanıcı bulunamadı.");
                } else {
                    System.out.println(user.toString());
                }
            }
        });
    }
}
