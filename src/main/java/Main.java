import controller.HopitalManager;
import model.*;
import utils.*;
import view.MenuPrincipal;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n🏥 ========================================");
        System.out.println("   SYSTÈME DE GESTION HOSPITALIÈRE");
        System.out.println("   Version 2.0 - Interface Complète");
        System.out.println("   École d'Ingénierie Digital & IA");
        System.out.println("   Euromed Université de Fès");
        System.out.println("========================================\n");

        HopitalManager manager = HopitalManager.getInstance();

        // ================= CHARGEMENT DES DONNÉES =================
        manager.chargerDonneesTest();

        // ================= INITIALISATION DES THREADS =================
        System.out.println("\n🔄 Initialisation des services système...");

        // Thread pour les rappels automatiques
        ThreadRappel threadRappel = new ThreadRappel(manager);
        threadRappel.setDaemon(true);
        threadRappel.start();

        // Thread pour la surveillance des stocks
        ThreadStock threadStock = new ThreadStock(manager);
        threadStock.setDaemon(true);
        threadStock.start();

        // Thread pour le nettoyage automatique
        Thread nettoyageThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(300000); // Toutes les 5 minutes
                    System.out.println("\n🧹 Nettoyage automatique des données...");
                    // Ici, vous pourriez ajouter la logique de nettoyage
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        nettoyageThread.setDaemon(true);
        nettoyageThread.start();

        System.out.println("✅ Services système démarrés");

        // ================= STATISTIQUES INITIALES =================
        System.out.println("\n📊 STATISTIQUES INITIALES:");
        System.out.println("- Patients: " + manager.getPatients().size());
        System.out.println("- Personnel: " + manager.getToutPersonnel().size());
        System.out.println("- Médicaments: " + manager.getMedicaments().size());
        System.out.println("- Chambres: " + manager.getChambres().size());

        // ================= DÉMARRAGE DU MENU =================
        MenuPrincipal menu = new MenuPrincipal(manager);

        try {
            menu.afficherMenu();
        } catch (Exception e) {
            System.err.println("\n❌ ERREUR: " + e.getMessage());
            System.err.println("Veuillez redémarrer le système.");
        } finally {
            // ================= ARRÊT DU SYSTÈME =================
            System.out.println("\n🛑 Arrêt du système hospitalier...");
            manager.sauvegarderDonnees();

            // Arrêt propre des threads
            threadRappel.interrupt();
            threadStock.interrupt();
            nettoyageThread.interrupt();

            System.out.println("\n========================================");
            System.out.println("   SYSTÈME ARRÊTÉ AVEC SUCCÈS");
            System.out.println("   Merci d'avoir utilisé notre système");
            System.out.println("   À bientôt ! 👋");
            System.out.println("========================================\n");
        }
    }
}