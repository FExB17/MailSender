package org.FEB17;

import org.FEB17.utils.ConfigReader;

import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.mail.*;
import javax.mail.internet.*;

public class Main {
    public static void main(String[] args) {
        MailSender.sendMail();
    }
}






