package view;

import core.Helper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public LoginUI() {
        this.add(container);
        this.setTitle("Müşteri Yönetim Sistemi");
        this.setSize(400, 400);
        this.setVisible(true);
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2;
        this.setLocation(x, y);

        this.btn_login.addActionListener(e -> {
            if (Helper.isFieldListEmpty(new JTextField[]{fld_mail, fld_password})) {
                System.out.println("Tüm alanları doldurun.");
            } else {
                System.out.println("Giriş yapabilirsiniz.");
            }
        }); // Added closing parenthesis and semicolon here
    }
}
