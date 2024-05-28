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
}
