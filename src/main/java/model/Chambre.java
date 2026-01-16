package model;

import java.util.ArrayList;
import java.util.List;

public class Chambre {
    private int numero;
    private int nbLits;
    private String type; // Standard, VIP, Soins intensifs, Pédiatrie
    private List<Lit> lits;
    private boolean disponible;
    private String etage;

    public Chambre(int numero, int nbLits, String type) {
        this.numero = numero;
        this.nbLits = nbLits;
        this.type = type;
        this.lits = new ArrayList<>();
        this.disponible = true;
        this.etage = String.valueOf(numero / 100); // Premier chiffre = étage

        // Créer les lits
        for (int i = 1; i <= nbLits; i++) {
            lits.add(new Lit(i, this.numero));
        }
    }

    public void ajouterLit(Lit lit) {
        lits.add(lit);
    }

    public int getLitsOccupees() {
        return (int) lits.stream().filter(Lit::isOccupe).count();
    }

    public int getLitsDisponibles() {
        return nbLits - getLitsOccupees();
    }

    // Getters
    public int getNumero() { return numero; }
    public int getNbLits() { return nbLits; }
    public String getType() { return type; }
    public List<Lit> getLits() { return lits; }
    public boolean isDisponible() {
        return disponible && getLitsDisponibles() > 0;
    }
    public String getEtage() { return etage; }

    // Setters
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    public void libererChambre() {
        for (Lit lit : lits) {
            lit.liberer();
        }
        this.disponible = true;
    }

    @Override
    public String toString() {
        return "Chambre " + numero + " (" + type + ") - " +
                getLitsOccupees() + "/" + nbLits + " lits occupés - " +
                (isDisponible() ? "✅ Disponible" : "⛔ Occupée");
    }
}