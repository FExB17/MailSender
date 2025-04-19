package org.FEB17.gui;

import org.FEB17.mail.MailSender;
import org.FEB17.utils.FieldValidator;
import org.FEB17.utils.Gui;

import javax.swing.*;
import java.awt.*;

public class MailGuiApp {

    public static void start() {
       JFrame frame = createFrame();
        JPanel panel = createForm(frame);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static JPanel createForm(JFrame frame){

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField mailTo = new JTextField();
        JLabel labelRecipient = new JLabel("Recipient");
        JLabel errorRecipient = Gui.createDefaultErrorLabel();
        mailTo.setMaximumSize(new Dimension((Integer.MAX_VALUE), 30));
        panel.add(labelRecipient);
        panel.add(mailTo);
        panel.add(errorRecipient);


        JTextField subject = new JTextField();
        JLabel labelSubject = new JLabel("Subject");
        JLabel errorSubject = Gui.createDefaultErrorLabel();
        subject.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        panel.add(labelSubject);
        panel.add(subject);
        panel.add(errorSubject);


        JTextArea messageArea = new JTextArea();
        JLabel labelMessage = new JLabel("Message");
        JLabel errorMessage = Gui.createDefaultErrorLabel();


        JScrollPane scrollPane = new JScrollPane(messageArea);
        panel.add(labelMessage);
        panel.add(scrollPane);
        panel.add(errorMessage);


        JButton button = new JButton("Send");
        button.addActionListener(e -> {
            String to = mailTo.getText();
            String subj = subject.getText();
            String message = messageArea.getText();

            boolean valid = true;
            if (!FieldValidator.validateField(mailTo, errorRecipient)) valid = false;
            if (!FieldValidator.validateField(subject, errorSubject)) valid = false;
            if (!FieldValidator.validateField(messageArea, errorMessage)) valid = false;
            if (!valid) {
                return;
            }

            JOptionPane.showMessageDialog(frame, "Message has been send");
            MailSender.sendMail(to, subj, message);
        });

        panel.add(button);
        return panel;
    }
    private static JFrame createFrame (){
        JFrame frame = new JFrame("Reminder");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }
}

