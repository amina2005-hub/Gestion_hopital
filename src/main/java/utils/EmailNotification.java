package utils;

public class EmailNotification implements Observateur {
    private String email;

    public EmailNotification(String email) {
        this.email = email;
    }

    @Override
    public void notifier(String message) {
        System.out.println("📧 Email envoyé à " + email + " : " + message);
        // Simulation d'envoi d'email
        System.out.println("   [EMAIL SIMULATION]");
        System.out.println("   De: notifications@hopital.ma");
        System.out.println("   À: " + email);
        System.out.println("   Sujet: Notification système hospitalier");
        System.out.println("   Corps: " + message);
    }
}