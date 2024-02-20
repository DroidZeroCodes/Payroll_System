package com.mmdc_group10_oop.service.actions;

import javax.swing.*;
import java.awt.*;

public class ErrorMessage extends Component {
    public static void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }


}