package utils;

public class SMSNotification implements Observateur {
    private String numeroTelephone;

    public SMSNotification(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    @Override
    public void notifier(String message) {
        System.out.println("📱 SMS envoyé au " + numeroTelephone + " : " + message);
        // Simulation d'envoi SMS
        System.out.println("   [SMS SIMULATION] Message: " + message.substring(0, Math.min(message.length(), 160)));
    }
}