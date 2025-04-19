package org.FEB17.utils;

import javax.swing.*;
import javax.swing.text.JTextComponent;

public class FieldValidator {
    public static boolean validateField(JTextComponent field, JLabel errorLabel){
        if (field.getText().isBlank()){
            errorLabel.setText("* Required");
            return false;
        }else{
            errorLabel.setText("");
        }
        return true;
    }
}
