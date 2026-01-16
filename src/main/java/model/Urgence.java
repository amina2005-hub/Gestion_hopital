package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Urgence implements Facturable {
    private String id;
    private Patient patient;
    private Medecin medecin;
    private int niveau; // 1: Critique, 2: Urgent, 3: Moyen, 4: Faible
    private String symptomes;
    private LocalDateTime dateArrivee;
    private LocalDateTime dateTraitement;
    private boolean traitee;
    private String observations;
    private double prix;

    public Urgence(String id, Patient patient, Medecin medecin,
                   int niveau, String symptomes) {
        this.id = id;
        this.patient = patient;
        this.medecin = medecin;
        this.niveau = niveau;
        this.symptomes = symptomes;
        this.dateArrivee = LocalDateTime.now();
        this.traitee = false;
        this.observations = "";
        setPrixSelonNiveau();
    }

    public Urgence(double prix) {
        this.prix = prix;
    }

    private void setPrixSelonNiveau() {
        switch(niveau) {
            case 1: this.prix = 1000; break;  // Critique
            case 2: this.prix = 700; break;   // Urgent
            case 3: this.prix = 500; break;   // Moyen
            case 4: this.prix = 300; break;   // Faible
            default: this.prix = 500;
        }
    }

    @Override
    public double getPrix() {
        return prix;
    }

    public void traiter(String observations) {
        this.traitee = true;
        this.dateTraitement = LocalDateTime.now();
        this.observations = observations;
    }

    // Getters
    public String getId() { return id; }
    public Patient getPatient() { return patient; }
    public Medecin getMedecin() { return medecin; }
    public int getNiveau() { return niveau; }
    public String getSymptomes() { return symptomes; }
    public LocalDateTime getDateArrivee() { return dateArrivee; }
    public LocalDateTime getDateTraitement() { return dateTraitement; }
    public boolean isTraitee() { return traitee; }
    public String getObservations() { return observations; }

    public String getNiveauString() {
        switch(niveau) {
            case 1: return "CRITIQUE";
            case 2: return "URGENT";
            case 3: return "MOYEN";
            case 4: return "FAIBLE";
            default: return "INCONNU";
        }
    }

    public String getDateArriveeFormatee() {
        return dateArrivee.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    @Override
    public String toString() {
        return "Urgence " + id + " - " + patient.getNom() +
                " - Niveau: " + getNiveauString() +
                " - " + (traitee ? "Traité" : "En attente");
    }
}