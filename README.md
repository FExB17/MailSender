# 📧 Mail Reminder App (Java + Swing)

Dies ist die Erweiterung der MailSender Anwendung.
Eine leichtgewichtige Reminder-Anwendung, die Erinnerungen per E-Mail versendet – lokal ausführbar mit grafischer Benutzeroberfläche (GUI), geplant für verschiedene Plattformen und Einsatzarten.

---

## 🚀 Features

- ✉️ E-Mail-Versand in individuell einstellbaren Intervallen
- 🧠 Eingabefelder mit Validierung und Nutzer-Feedback (Erfolg oder Fehler)
- ⏱️ Hintergrundprozess mit `ScheduledExecutorService`
- 🖥️ Lokale Swing-GUI mit getrennten Statusanzeigen (z. B. Fehler vs. "Mail sent")
- 🔄 Konfigurierbar über Datei
- ✅ Java 17, Maven-Projekt, klar strukturierter Code

---

## 🧭 Geplante Erweiterungen

- 📋 Reminder-Liste mit Verwaltung (anzeigen, bearbeiten, löschen)
- 🔔 Desktop-Benachrichtigungen
- ☁️ CLI- und API-Version (ohne GUI)
- 📱 Android-App & Raspberry-Pi-Integration
- 🌐 Webhooks für externe Trigger

---

## 🧰 Tech Stack

- Java 17
- Swing (GUI)
- JavaMail (SMTP)
- Maven
- Threads & ScheduledExecutorService
- Saubere Paketstruktur (`gui`, `mail`, `scheduler`, `utils`)

---

## 🧑‍💻 Projektstruktur

```
src/main/java/org/FEB17/
├── Main.java
├── gui/                 # GUI-Logik (Swing)
├── mail/                # Maildaten & Mailversand
├── scheduler/           # Intervallversand
└── utils/               # Config- und Validierungs-Helfer
```

---

## 🧪 Lokales Testen & Starten

### In IntelliJ IDEA:
1. Projekt importieren (als Maven-Projekt)
2. `MailGuiApp.main()` in `src/main/java/org/FEB17/gui/` ausführen

### Maven (optional):
```bash
mvn compile
mvn exec:java -Dexec.mainClass="org.FEB17.ui.MailGuiApp"
```

---

## 📸 Screenshots (folgt)
>

---

## 📦 Build-Ziele (geplant)
- `.jar` → ausführbar über Doppelklick oder CLI
- `.exe` → für Windows-Nutzer (Java nicht nötig)
- REST-API → headless auf Servern
- Android-Port

---

## 📄 Lizenz
*(Optional: Deine Lizenz oder "MIT License" einfügen)*

---

## 👨‍💻 Über den Entwickler

Ich bin Quereinsteiger mit Java- und Testautomatisierungs-Hintergrund. Dieses Projekt dient als Lernplattform für professionelle Java-Entwicklung und gleichzeitig als Teil meines Portfolios für den Berufseinstieg als Entwickler.  

Ich freue mich über Feedback, Fragen oder Ideen!
