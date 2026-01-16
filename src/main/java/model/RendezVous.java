package model;

import java.time.LocalDateTime;

public class RendezVous {
    private String id;
    private Patient patient;
    private Medecin medecin;
    private LocalDateTime date;
    private EtatRendezVous etat;
    private String motif;
    private int duree; // en minutes

    public RendezVous(String id, Patient patient, Medecin medecin, LocalDateTime date) {
        this.id = id;
        this.patient = patient;
        this.medecin = medecin;
        this.date = date;
        this.etat = EtatRendezVous.PLANIFIE;
        this.motif = "";
        this.duree = 30; // Durée par défaut
    }

    public String getId() { return id; }
    public Patient getPatient() { return patient; }
    public Medecin getMedecin() { return medecin; }
    public LocalDateTime getDate() { return date; }
    public EtatRendezVous getEtat() { return etat; }

    public void annuler() {
        etat = EtatRendezVous.ANNULE;
    }

    public void terminer() {
        etat = EtatRendezVous.TERMINE;
    }

    // Nouveaux getters & setters
    public String getMotif() { return motif; }
    public void setMotif(String motif) { this.motif = motif; }

    public int getDuree() { return duree; }
    public void setDuree(int duree) { this.duree = duree; }

    public void setDate(LocalDateTime date) { this.date = date; }

    @Override
    public String toString() {
        return "RDV " + id + " - " + patient.getNom() + " avec Dr. " +
                medecin.getNom() + " le " + date + " (" + etat + ")";
    }
}