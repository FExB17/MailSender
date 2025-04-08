package org.FEB17;

import org.FEB17.utils.ConfigReader;

import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.mail.*;
import javax.mail.internet.*;

public class Main {
    public static void main(String[] args) {
        ConfigReader config = new ConfigReader();

        // Empfänger und Absender-Details
        final String username = config.getProperty("username"); // Absender-Email-Adresse
        final String password = config.getProperty("password"); // Passwort oder App-spezifisches Passwort

        // Empfänger
        String toEmail = config.getProperty("toMail");

        // SMTP-Server-Einstellungen
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true"); // Authentifizierung erforderlich
        props.put("mail.smtp.starttls.enable", "true"); // TLS aktivieren
        props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP-Server
        props.put("mail.smtp.port", "587"); // Port

        // Authentifizieren und Session erstellen
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Erstelle eine neue E-Mail-Nachricht
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username)); // Absender
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail)); // Empfänger
            message.setSubject("Test E-Mail"); // Betreff
            message.setText("Don't forget to drink Water"); // Inhalt der E-Mail

            // E-Mail senden
            Transport.send(message);

            System.out.println("E-Mail erfolgreich gesendet!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}






