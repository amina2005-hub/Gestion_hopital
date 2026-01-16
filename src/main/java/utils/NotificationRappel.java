package utils;

public class NotificationRappel implements Observateur {
    private String destinataire; // Peut être un email ou un numéro de téléphone
    private String type; // "email" ou "sms"

    public NotificationRappel(String destinataire) {
        this.destinataire = destinataire;
        // Déterminer le type basé sur le format
        if (destinataire.contains("@")) {
            this.type = "email";
        } else {
            this.type = "sms";
        }
    }

    public NotificationRappel(String destinataire, String type) {
        this.destinataire = destinataire;
        this.type = type;
    }

    @Override
    public void notifier(String message) {
        System.out.println("📧 Notification envoyée à " + destinataire + " (" + type + ") : " + message);

        // Ici, vous pourriez implémenter l'envoi réel par email ou SMS
        if (type.equals("email")) {
            envoyerEmail(message);
        } else {
            envoyerSMS(message);
        }
    }

    private void envoyerEmail(String message) {
        // Simulation d'envoi d'email
        System.out.println("   [EMAIL] De: hopital@system.ma");
        System.out.println("   [EMAIL] À: " + destinataire);
        System.out.println("   [EMAIL] Sujet: Rappel Hôpital");
        System.out.println("   [EMAIL] Message: " + message);
    }

    private void envoyerSMS(String message) {
        // Simulation d'envoi SMS
        System.out.println("   [SMS] À: " + destinataire);
        System.out.println("   [SMS] Message: " + message);
    }
}