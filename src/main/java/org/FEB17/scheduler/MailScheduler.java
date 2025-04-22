package org.FEB17.scheduler;

import org.FEB17.gui.MailGuiApp;
import org.FEB17.mail.MailData;
import org.FEB17.mail.MailSender;

import javax.swing.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class MailScheduler {

    // läuft parallel und im Hintergrund
    static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    // sendet die Nachricht in einem angegebenen Intervall
    public static void startScheduledMailing(long intervalMinutes, Supplier<MailData> dataSupplier) {
        Runnable command = () -> {
            MailData data = dataSupplier.get();
            String result = MailSender.sendMail(data.to, data.subject, data.body);
        };
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()){
            scheduledExecutorService = Executors.newScheduledThreadPool(1);
        }
        scheduledExecutorService.scheduleAtFixedRate(command, 0, intervalMinutes, TimeUnit.MINUTES);
    }

    public static void stop() {
        if (scheduledExecutorService != null ) {
            scheduledExecutorService.shutdown();
            System.out.println("Scheduler stopped");
        }
    }
}
