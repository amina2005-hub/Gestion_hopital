package model;

import java.time.LocalDateTime;

public class CommandePharmacie {
    private String id;
    private Medicament medicament;
    private int quantite;
    private LocalDateTime dateCommande;
    private String statut; // En attente, Livrée, Annulée

    public CommandePharmacie(String id, Medicament medicament, int quantite) {
        this.id = id;
        this.medicament = medicament;
        this.quantite = quantite;
        this.dateCommande = LocalDateTime.now();
        this.statut = "En attente";
    }

    // Getters
    public String getId() { return id; }
    public Medicament getMedicament() { return medicament; }
    public int getQuantite() { return quantite; }
    public LocalDateTime getDateCommande() { return dateCommande; }
    public String getStatut() { return statut; }

    // Setters
    public void setStatut(String statut) { this.statut = statut; }

    @Override
    public String toString() {
        return "Commande " + id + " - " + medicament.getNom() +
                " x" + quantite + " - " + statut + " (" + dateCommande + ")";
    }
}