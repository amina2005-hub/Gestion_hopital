package model;

import java.time.LocalDateTime;

public class Lit {
    private int numero;
    private int numeroChambre;
    private boolean occupe;
    private Patient patient;
    private LocalDateTime dateOccupation;
    private LocalDateTime dateLiberation;

    public Lit(int numero, int numeroChambre) {
        this.numero = numero;
        this.numeroChambre = numeroChambre;
        this.occupe = false;
        this.patient = null;
        this.dateOccupation = null;
        this.dateLiberation = null;
    }

    public Lit(int numLit) {
        this.numero= numLit;
    }

    public void occuper(Patient patient) {
        this.occupe = true;
        this.patient = patient;
        this.dateOccupation = LocalDateTime.now();
        this.dateLiberation = null;
    }

    public void liberer() {
        this.occupe = false;
        this.patient = null;
        this.dateLiberation = LocalDateTime.now();
    }

    // Getters
    public int getNumero() { return numero; }
    public int getNumeroChambre() { return numeroChambre; }
    public boolean isOccupe() { return occupe; }
    public Patient getPatient() { return patient; }
    public LocalDateTime getDateOccupation() { return dateOccupation; }
    public LocalDateTime getDateLiberation() { return dateLiberation; }

    // Setters
    public void setNumeroChambre(int numeroChambre) { this.numeroChambre = numeroChambre; }
    public void setPatient(Patient patient) {
        this.patient = patient;
        this.occupe = (patient != null);
        if (patient != null) {
            this.dateOccupation = LocalDateTime.now();
        }
    }

    @Override
    public String toString() {
        return "Lit " + numero + " (Chambre " + numeroChambre + ") - " +
                (occupe ? "⛔ Occupé par " + patient.getNom() : "✅ Disponible");
    }
}