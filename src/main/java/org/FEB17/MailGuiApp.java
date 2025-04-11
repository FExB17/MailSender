package org.FEB17;

import javax.swing.*;

public class MailGuiApp {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Reminder");
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField mailTo = new JTextField();
        JLabel labelRecipient = new JLabel("Recipient");
        panel.add(labelRecipient);
        panel.add(mailTo);


        JTextField subject = new JTextField();
        JLabel labelSubject = new JLabel("Subject");
        panel.add(labelSubject);
        panel.add(subject);


        JTextArea messageArea = new JTextArea();
        JLabel labelMessage = new JLabel("Message");
        JScrollPane scrollPane = new JScrollPane(messageArea);
        panel.add(labelMessage);
        panel.add(scrollPane);


        JButton button = new JButton("Send");
        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame,"Nachricht wird gesendet");
            MailSender.sendMail(mailTo.getText(),subject.getText(),messageArea.getText());
        });
        panel.add(button);


        frame.add(panel);
        frame.setVisible(true);










    }
}
