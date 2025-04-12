package org.FEB17;

import javax.mail.search.SizeTerm;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MailGuiApp {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Reminder");
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField mailTo = new JTextField();
        JLabel labelRecipient = new JLabel("Recipient");
        mailTo.setMaximumSize(new Dimension((Integer.MAX_VALUE),30));
        panel.add(labelRecipient);
        panel.add(mailTo);


        JTextField subject = new JTextField();
        JLabel labelSubject = new JLabel("Subject");
        subject.setMaximumSize(new Dimension(Integer.MAX_VALUE,30));
        panel.add(labelSubject);
        panel.add(subject);


        JTextArea messageArea = new JTextArea();
        JLabel labelMessage = new JLabel("Message");
        JScrollPane scrollPane = new JScrollPane(messageArea);
        panel.add(labelMessage);
        panel.add(scrollPane);


        JButton button = new JButton("Send");
        button.addActionListener(e -> {
            String to = mailTo.getText();
            String subj = subject.getText();
            String message = messageArea.getText();

            Map<String,String> fields = Map.of(
                    "Recipient",to,
                    "Subject", subj,
                    "Message", message
            );

            List<String> missingFields = new ArrayList<>();
            for (Map.Entry<String,String> entry: fields.entrySet()){
                if (entry.getValue().isBlank()){
                    missingFields.add(entry.getKey());
                }
            }
            if (!missingFields.isEmpty()){
                String reqFieldsMessage = "Please fill out required fields:\n" + String.join(", ", missingFields);
                JOptionPane.showMessageDialog(frame, reqFieldsMessage );
                return;
            }

            JOptionPane.showMessageDialog(frame,"Nachricht wird gesendet");
            MailSender.sendMail(to,subj,message);
        });
        panel.add(button);


        frame.add(panel);
        frame.setVisible(true);










    }
}
