/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author Rohan
 */
public class testpanel extends javax.swing.JPanel {

    /**
     * Creates new form testpanel
     */
    public testpanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.regex.Pattern;

public class NewJFrame extends javax.swing.JFrame {

    private JButton submitButton;
    private JButton uploadPhotoButton;
    private JLabel photoLabel;
    private File selectedPhotoFile;

    public NewJFrame() {
        initComponents();
        addSubmitButton();
        addUploadPhotoButton();
    }

    private void addSubmitButton() {
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateForm()) {
                    displayUserProfile();
                }
            }
        });
        jPanel1.add(submitButton);
    }

    private void addUploadPhotoButton() {
        uploadPhotoButton = new JButton("Upload Photo");
        uploadPhotoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    selectedPhotoFile = fileChooser.getSelectedFile();
                    photoLabel.setIcon(new ImageIcon(selectedPhotoFile.getAbsolutePath()));
                }
            }
        });
        jPanel1.add(uploadPhotoButton);
        photoLabel = new JLabel();
        jPanel1.add(photoLabel);
    }

    private boolean validateForm() {
        if (firstNameTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "First name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (lastNameTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Last name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!maleRadioButton.isSelected() && !femaleRadioButton.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select a gender", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            int age = Integer.parseInt(ageTextField.getText());
            if (age <= 0) {
                JOptionPane.showMessageDialog(this, "Age must be a positive number", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Age must be a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!Pattern.matches("^[0-9]{10}$", phoneNumberTextField.getText())) {
            JOptionPane.showMessageDialog(this, "Phone number must be 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", emailTextField.getText())) {
            JOptionPane.showMessageDialog(this, "Invalid email address", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void displayUserProfile() {
        String profile = "First Name: " + firstNameTextField.getText() + "\n" +
                "Last Name: " + lastNameTextField.getText() + "\n" +
                "Gender: " + (maleRadioButton.isSelected() ? "Male" : "Female") + "\n" +
                "Age: " + ageTextField.getText() + "\n" +
                "Phone Number: " + phoneNumberTextField.getText() + "\n" +
                "Email: " + emailTextField.getText();

        JOptionPane.showMessageDialog(this, profile, "User Profile", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(selectedPhotoFile.getAbsolutePath()));
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel GenderLabel;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JTextField ageTextField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JRadioButton femaleRadioButton;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.ButtonGroup genderbuttonGroup;
    private java.awt.Label headinglabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JRadioButton maleRadioButton;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JTextField phoneNumberTextField;
    // End of variables declaration
}