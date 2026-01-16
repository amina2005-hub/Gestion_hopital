package utils;

import controller.HopitalManager;
import model.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class Statistiques {

    public static void genererRapportJournalier(HopitalManager manager) {
        LocalDateTime aujourdhui = LocalDateTime.now();

        System.out.println("\n📊 RAPPORT JOURNALIER - " +
                aujourdhui.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("=" .repeat(50));

        // Patients
        System.out.println("\n👥 PATIENTS:");
        System.out.println("- Total: " + manager.getPatients().size());

        // Rendez-vous du jour
        List<RendezVous> rdvsAujourdhui = manager.getRendezVous().stream()
                .filter(rv -> rv.getDate().toLocalDate().equals(aujourdhui.toLocalDate()))
                .toList();

        System.out.println("\n📅 RENDEZ-VOUS AUJOURD'HUI:");
        System.out.println("- Nombre: " + rdvsAujourdhui.size());
        for (RendezVous rv : rdvsAujourdhui) {
            System.out.println("  • " + rv.getDate().toLocalTime() + " - " +
                    rv.getPatient().getNom() + " avec Dr. " + rv.getMedecin().getNom());
        }

        // Urgences du jour
        List<Urgence> urgencesAujourdhui = manager.getUrgences().stream()
                .filter(u -> u.getDateArrivee().toLocalDate().equals(aujourdhui.toLocalDate()))
                .toList();

        System.out.println("\n🚨 URGENCES AUJOURD'HUI:");
        System.out.println("- Nombre: " + urgencesAujourdhui.size());
        int urgencesTraitees = (int) urgencesAujourdhui.stream()
                .filter(Urgence::isTraitee)
                .count();
        System.out.println("- Traitées: " + urgencesTraitees + "/" + urgencesAujourdhui.size());

        // Facturation du jour
        double revenusJour = manager.getFactures().stream()
                .filter(f -> f.getDateCreation().toLocalDate().equals(aujourdhui.toLocalDate()))
                .mapToDouble(Facture::calculerTotal)
                .sum();

        System.out.println("\n💰 REVENUS DU JOUR:");
        System.out.println("- Total: " + revenusJour + " DH");

        // Occupation des lits
        long litsOccupes = manager.getLits().stream()
                .filter(Lit::isOccupe)
                .count();
        long totalLits = manager.getLits().size();
        double tauxOccupation = totalLits > 0 ? (litsOccupes * 100.0 / totalLits) : 0;

        System.out.println("\n🏥 OCCUPATION:");
        System.out.println("- Lits occupés: " + litsOccupes + "/" + totalLits);
        System.out.println("- Taux d'occupation: " + String.format("%.1f", tauxOccupation) + "%");

        System.out.println("\n" + "=" .repeat(50));
    }

    public static void genererRapportMensuel(HopitalManager manager, int mois, int annee) {
        System.out.println("\n📈 RAPPORT MENSUEL - " + mois + "/" + annee);
        System.out.println("=" .repeat(50));

        // Récupérer les statistiques du manager
        Map<String, Object> stats = manager.getStatistiques();

        System.out.println("\n📊 STATISTIQUES GLOBALES:");
        System.out.println("- Patients totaux: " + stats.get("totalPatients"));
        System.out.println("- Personnel total: " + stats.get("totalPersonnel"));
        System.out.println("- Rendez-vous totaux: " + stats.get("totalRendezVous"));
        System.out.println("- Urgences totales: " + stats.get("totalUrgences"));
        System.out.println("- Factures totales: " + stats.get("totalFactures"));

        System.out.println("\n💰 ASPECT FINANCIER:");
        System.out.println("- Revenus totaux: " + stats.get("totalRevenus") + " DH");

        System.out.println("\n👨‍⚕️ RÉPARTITION PERSONNEL:");
        System.out.println("- Médecins: " + stats.get("nbMedecins"));
        System.out.println("- Infirmiers: " + stats.get("nbInfirmiers"));
        System.out.println("- Pharmaciens: " + stats.get("nbPharmaciens"));

        System.out.println("\n🏥 INFRASTRUCTURE:");
        System.out.println("- Chambres: " + stats.get("totalChambres"));
        System.out.println("- Lits: " + stats.get("totalLits"));
        System.out.println("- Taux d'occupation: " +
                String.format("%.1f", (double)stats.get("tauxOccupation")) + "%");

        System.out.println("\n" + "=" .repeat(50));
    }
}