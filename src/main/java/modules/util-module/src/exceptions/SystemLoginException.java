package exceptions;

import javax.swing.*;

public class SystemLoginException extends Exception {
    public SystemLoginException(String message) {
        super(message);
    }

    public static void throwLoginError_INCORRECT_USERNAME_OR_PASSWORD() throws SystemLoginException {
        JOptionPane.showMessageDialog(null, "Incorrect Username or Password", "Login Error", JOptionPane.ERROR_MESSAGE);
        throw new SystemLoginException("Invalid Username or Password");
    }

    public static void throwLoginError_MISSING_USERNAME_OR_PASSWORD() throws SystemLoginException {
        JOptionPane.showMessageDialog(null, "Missing Username or Password", "Login Error", JOptionPane.ERROR_MESSAGE);
        throw new SystemLoginException("Missing Username or Password");
    }
}
