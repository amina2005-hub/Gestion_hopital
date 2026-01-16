package model;

import java.util.ArrayList;
import java.util.List;

public class Medecin extends PersonnelMedical {
    private String specialite;
    private String numeroINPE;
    private List<RendezVous> consultations;

    public Medecin(String id, String nom, String prenom, String email,
                   String specialite, String numeroINPE) {
        super(id, nom, prenom, email);
        this.specialite = specialite;
        this.numeroINPE = numeroINPE;
        this.consultations = new ArrayList<>();
        super.specialite = specialite; // Mettre à jour l'attribut de la classe mère
    }

    public String getSpecialite() { return specialite; }
    public String getNumeroINPE() { return numeroINPE; }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
        super.specialite = specialite;
    }

    public void ajouterConsultation(RendezVous rv) {
        consultations.add(rv);
    }

    public List<RendezVous> getConsultations() {
        return consultations;
    }

    @Override
    public String toString() {
        return "Dr. " + nom + " " + prenom + " - " + specialite + " (" + id + ")";
    }
}