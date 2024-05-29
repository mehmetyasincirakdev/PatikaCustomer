package core;

import javax.swing.*;

public class Helper {
    public static void setTheme() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if (info.getName().equals("Nimbus")) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                         UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }

    public static boolean isFieldEmpty(JTextField jTextField) {
        return jTextField.getText().trim().isEmpty();
    }

    public static boolean isFieldListEmpty(JTextField[] jTextFields) {
        for (JTextField jTextField : jTextFields) {
            if (isFieldEmpty(jTextField)) return true;
        }
        return false;
    }

    public static boolean isEmailValid(String mail) {
        if (mail == null || mail.trim().isEmpty()) return false;
        if (!mail.contains("@")) return false;

        String[] parts = mail.split("@");
        if (parts.length != 2) return false;
        if (parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) return false;
        if (!parts[1].contains(".")) return false;

        return true;
    }

    public static void showInfoMessage(String message) {
        String msg;
        String title;

        switch (message) {
            case "fill":
                msg = "Lütfen tüm alanları doldurunuz.";
                title = "HATA";
                break;
            case "done":
                msg = "İşlem başarılı";
                title = "Sonuç";
                break;
            case "error":
                msg = "Bir hata oluştu.";
                title = "HATA";
                break;
            default:
                msg = message;
                title = "Mesaj";
        }
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
