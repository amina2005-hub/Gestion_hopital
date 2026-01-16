package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Facture {
    private String id;
    private Patient patient;
    private List<Facturable> services = new ArrayList<>();
    private LocalDateTime dateCreation;
    private String statut;

    public Facture(String id, Patient patient) {
        this.id = id;
        this.patient = patient;
        this.dateCreation = LocalDateTime.now();
        this.statut = "Non payée";
    }

    public void ajouterService(Facturable f) {
        services.add(f);
    }

    public double calculerTotal() {
        double total = 0;
        for (Facturable f : services) {
            total += f.getPrix();
        }
        return total;
    }

    public String getId() { return this.id; }
    public Patient getPatient() { return this.patient; }

    // Nouveaux getters & setters
    public LocalDateTime getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDateTime dateCreation) { this.dateCreation = dateCreation; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public List<Facturable> getServices() { return services; }

    public String getDateFormatee() {
        return dateCreation.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    @Override
    public String toString() {
        return "Facture " + id + " - " + patient.getNom() +
                " - " + calculerTotal() + " DH - " + statut;
    }
}