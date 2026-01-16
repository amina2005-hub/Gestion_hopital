package controller;

import model.*;
import utils.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class HopitalManager {

    private static HopitalManager instance;

    // Collections principales
    private Map<String, Patient> patients = new HashMap<>();
    private Map<String, PersonnelMedical> personnels = new HashMap<>();
    private Map<String, DossierMedical> dossiersMedicaux = new HashMap<>();
    private List<RendezVous> rendezVous = new ArrayList<>();
    private Map<String, Medicament> medicaments = new HashMap<>();
    private List<Facture> factures = new ArrayList<>();
    private List<Urgence> urgences = new ArrayList<>();
    private List<Chambre> chambres = new ArrayList<>();
    private List<Lit> lits = new ArrayList<>();
    private List<Rapport> rapports = new ArrayList<>();
    private List<String> historiqueCommandes = new ArrayList<>();

    private HopitalManager() {}

    public static synchronized HopitalManager getInstance() {
        if (instance == null) {
            instance = new HopitalManager();
        }
        return instance;
    }

    // ================= PATIENTS =================
    public void ajouterPatient(Patient p) {
        patients.put(p.getId(), p);
    }

    public Patient getPatientById(String id) {
        return patients.get(id);
    }

    public List<Patient> getTousPatients() {
        return new ArrayList<>(patients.values());
    }

    public List<Patient> getPatients() {
        return new ArrayList<>(patients.values());
    }

    // ================= DOSSIERS MÉDICAUX =================
    public void ajouterDossierMedical(DossierMedical dossier) {
        dossiersMedicaux.put(dossier.getPatient().getId(), dossier);
    }

    public DossierMedical getDossierMedical(String patientId) {
        return dossiersMedicaux.get(patientId);
    }

    // ================= PERSONNEL =================
    public void ajouterPersonnel(PersonnelMedical p) {
        personnels.put(p.getId(), p);
    }

    public PersonnelMedical getPersonnelById(String id) {
        return personnels.get(id);
    }

    public List<PersonnelMedical> getToutPersonnel() {
        return new ArrayList<>(personnels.values());
    }

    // ================= RENDEZ-VOUS =================
    public synchronized void planifierRendezVous(RendezVous rv) {
        rendezVous.add(rv);
        rv.getPatient().ajouterRendezVous(rv);
    }

    public List<RendezVous> getRendezVous() {
        return rendezVous;
    }

    public List<RendezVous> getRendezVousParPatient(String patientId) {
        return rendezVous.stream()
                .filter(rv -> rv.getPatient().getId().equals(patientId))
                .collect(Collectors.toList());
    }

    public List<RendezVous> getRendezVousParMedecin(String medecinId) {
        return rendezVous.stream()
                .filter(rv -> rv.getMedecin().getId().equals(medecinId))
                .collect(Collectors.toList());
    }

    // ================= MÉDICAMENTS =================
    public void ajouterMedicament(Medicament m) {
        medicaments.put(m.getCode(), m);
    }

    public Medicament getMedicament(String code) {
        return medicaments.get(code);
    }

    public List<Medicament> getMedicaments() {
        return new ArrayList<>(medicaments.values());
    }

    public void verifierStockMedicaments() {
        System.out.println("🔍 Vérification stock médicaments");
        for (Medicament m : medicaments.values()) {
            if (m.getQuantite() < m.getStockMinimum()) {
                System.out.println("⚠ Stock faible : " + m.getNom() +
                        " (Stock: " + m.getQuantite() +
                        ", Seuil: " + m.getStockMinimum() + ")");
            }
        }
    }

    // ================= FACTURATION =================
    public void ajouterFacture(Facture facture) {
        facture.setDateCreation(LocalDateTime.now());
        factures.add(facture);
    }

    public List<Facture> getFactures() {
        return factures;
    }

    public List<Facture> getFacturesParPatient(String patientId) {
        return factures.stream()
                .filter(f -> f.getPatient().getId().equals(patientId))
                .collect(Collectors.toList());
    }

    // ================= URGENCES =================
    public void ajouterUrgence(Urgence urgence) {
        urgences.add(urgence);
    }

    public List<Urgence> getUrgences() {
        return urgences;
    }

    public List<Urgence> getUrgencesNonTraitees() {
        return urgences.stream()
                .filter(u -> !u.isTraitee())
                .collect(Collectors.toList());
    }

    // ================= CHAMBRES ET LITS =================
    public void ajouterChambre(Chambre chambre) {
        chambres.add(chambre);
    }

    public void ajouterLit(int numeroChambre, Lit lit) {
        lit.setNumeroChambre(numeroChambre);
        lits.add(lit);

        // Trouver la chambre et ajouter le lit
        for (Chambre c : chambres) {
            if (c.getNumero() == numeroChambre) {
                c.ajouterLit(lit);
                break;
            }
        }
    }

    public List<Chambre> getChambres() {
        return chambres;
    }

    public List<Lit> getLits() {
        return lits;
    }

    public List<Lit> getLitsDisponibles() {
        return lits.stream()
                .filter(l -> !l.isOccupe())
                .collect(Collectors.toList());
    }

    // ================= RAPPORTS =================
    public void ajouterRapport(Rapport rapport) {
        rapports.add(rapport);
    }

    public List<Rapport> getRapports() {
        return rapports;
    }

    // ================= COMMANDES =================
    public void ajouterCommande(String commande) {
        historiqueCommandes.add(LocalDateTime.now() + " - " + commande);
    }

    public List<String> getHistoriqueCommandes() {
        return historiqueCommandes;
    }

    // ================= STATISTIQUES =================
    public Map<String, Object> getStatistiques() {
        Map<String, Object> stats = new HashMap<>();

        stats.put("totalPatients", patients.size());
        stats.put("totalPersonnel", personnels.size());
        stats.put("totalRendezVous", rendezVous.size());
        stats.put("totalUrgences", urgences.size());
        stats.put("totalFactures", factures.size());
        stats.put("totalChambres", chambres.size());
        stats.put("totalLits", lits.size());

        // Taux d'occupation
        long litsOccupes = lits.stream().filter(Lit::isOccupe).count();
        double tauxOccupation = lits.size() > 0 ? (litsOccupes * 100.0 / lits.size()) : 0;
        stats.put("tauxOccupation", tauxOccupation);

        // Répartition personnel
        long nbMedecins = personnels.values().stream()
                .filter(p -> p instanceof Medecin)
                .count();
        long nbInfirmiers = personnels.values().stream()
                .filter(p -> p instanceof Infirmier)
                .count();
        long nbPharmaciens = personnels.values().stream()
                .filter(p -> p instanceof Pharmacien)
                .count();

        stats.put("nbMedecins", nbMedecins);
        stats.put("nbInfirmiers", nbInfirmiers);
        stats.put("nbPharmaciens", nbPharmaciens);

        // Revenus
        double totalRevenus = factures.stream()
                .mapToDouble(Facture::calculerTotal)
                .sum();
        stats.put("totalRevenus", totalRevenus);

        return stats;
    }

    // ================= SAUVEGARDE =================
    public void sauvegarderDonnees() {
        System.out.println("💾 Sauvegarde des données en cours...");
        // Ici, vous pourriez implémenter la sauvegarde dans une base de données
        // ou dans des fichiers
        System.out.println("✅ Données sauvegardées");
    }

    // ================= CHARGEMENT =================
    public void chargerDonneesTest() {
        System.out.println("📥 Chargement des données de test...");

        // Ajouter des patients de test
        ajouterPatient(new Patient("P001", "Alami", "Karim", "1990-05-15", "premium"));
        ajouterPatient(new Patient("P002", "Benani", "Fatima", "1985-08-22", "standard"));

        // Ajouter du personnel de test
        ajouterPersonnel(FactoryPersonnel.creerPersonnel(
                "medecin", "M001", "Diallo", "Amadou", "d.amadou@hopital.ma",
                "Cardiologie", "INPE12345"
        ));

        ajouterPersonnel(FactoryPersonnel.creerPersonnel(
                "infirmier", "I001", "Martin", "Sophie", "s.martin@hopital.ma",
                "", ""
        ));

        // Ajouter des médicaments de test
        ajouterMedicament(new Medicament("MED001", "Paracétamol", "PharmaLab", 20, 5.50));
        ajouterMedicament(new Medicament("MED002", "Ibuprofène", "MediCorp", 3, 7.80));
        ajouterMedicament(new Medicament("MED003", "Amoxicilline", "BioPharm", 15, 12.30));

        // Ajouter des chambres de test
        ajouterChambre(new Chambre(101, 2, "Standard"));
        ajouterChambre(new Chambre(102, 1, "VIP"));

        System.out.println("✅ Données de test chargées");
    }
}