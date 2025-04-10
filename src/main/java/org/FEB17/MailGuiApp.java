package org.FEB17;

import javax.swing.*;

public class MailGuiApp {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Reminder");
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel label = new JLabel("Hallo Swing");
        frame.add(label);

        JTextField mailTo = new JTextField();
        frame.add(mailTo);

        JTextField subject = new JTextField();
        frame.add(subject);

        JTextArea message = new JTextArea();
        frame.add(message);

        JButton button = new JButton("Send");
        frame.add(button);
        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame,"Nachricht wird gesendet");
        });




        frame.setVisible(true);










    }
}
