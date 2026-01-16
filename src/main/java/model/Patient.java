package model;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private String id;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String assurance;
    private List<RendezVous> historiqueRendezVous;

    // Nouveaux attributs
    private String telephone;
    private String adresse;
    private String groupeSanguin;
    private String allergies;
    private String antecedents;
    private String email;

    public Patient(String id, String nom, String prenom, String dateNaissance, String assurance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.assurance = assurance;
        this.historiqueRendezVous = new ArrayList<>();
        this.telephone = "";
        this.adresse = "";
        this.groupeSanguin = "";
        this.allergies = "";
        this.antecedents = "";
        this.email = "";
    }

    public void ajouterRendezVous(RendezVous rv) {
        historiqueRendezVous.add(rv);
    }

    // Getters & Setters existants
    public String getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getDateNaissance() { return dateNaissance; }
    public String getAssurance() { return assurance; }
    public List<RendezVous> getHistoriqueRendezVous() { return historiqueRendezVous; }
    public void setAssurance(String assurance) { this.assurance = assurance; }

    // Nouveaux getters & setters
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getGroupeSanguin() { return groupeSanguin; }
    public void setGroupeSanguin(String groupeSanguin) { this.groupeSanguin = groupeSanguin; }

    public String getAllergies() { return allergies; }
    public void setAllergies(String allergies) { this.allergies = allergies; }

    public String getAntecedents() { return antecedents; }
    public void setAntecedents(String antecedents) { this.antecedents = antecedents; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return nom + " " + prenom + " (" + id + ")";
    }
}