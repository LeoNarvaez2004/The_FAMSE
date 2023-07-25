/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.thefamse.controller;


import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Leonardo Narvaez, The FAMSE, DCCO-ESPE
 */
public class Validation {
   public void NumberValidation(JTextField txtField, java.awt.event.KeyEvent evt, JLabel lblfield, int length) {

        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9' || Character.isISOControl(evt.getKeyChar())) {
            LengthValidation(txtField, evt, length);
            lblfield.setText("");
        } else {
            lblfield.setText("Enter Only digits");
            txtField.setEditable(false);
        }
    }
   
   public void StringValidation(JTextField txtField, java.awt.event.KeyEvent evt, JLabel lblfield, int length) {

        if (Character.isAlphabetic(evt.getKeyChar()) || Character.isWhitespace(evt.getKeyChar()) || Character.isISOControl(evt.getKeyChar())) {
            LengthValidation(txtField, evt, length);
            lblfield.setText("");
        } else {
            txtField.setEditable(false);
            lblfield.setText("Error");
        }

    }

    private void LengthValidation(JTextField txtField, KeyEvent evt, int length) {
         String text = txtField.getText();

        if (text.length() <= length || Character.isISOControl(evt.getKeyChar())) {
            txtField.setEditable(true);
        } else {
            txtField.setEditable(false);
        }
         }
}


   