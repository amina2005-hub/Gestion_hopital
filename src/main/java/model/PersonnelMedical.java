package model;

public abstract class PersonnelMedical {
    protected String id;
    protected String nom;
    protected String prenom;
    protected String email;

    // Nouveaux attributs
    protected String telephone;
    protected String dateEmbauche;
    protected String specialite;

    public PersonnelMedical(String id, String nom, String prenom, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = "";
        this.dateEmbauche = "";
        this.specialite = "";
    }

    // Getters existants
    public String getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Nouveaux getters & setters
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getDateEmbauche() { return dateEmbauche; }
    public void setDateEmbauche(String dateEmbauche) { this.dateEmbauche = dateEmbauche; }

    public String getSpecialite() { return specialite; }
    public void setSpecialite(String specialite) { this.specialite = specialite; }

    @Override
    public String toString() {
        return nom + " " + prenom + " (" + id + ")";
    }
}