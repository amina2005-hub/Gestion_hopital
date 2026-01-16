package model;

public class Medicament {
    private String code;
    private String nom;
    private int quantite;
    private String laboratoire;
    private double prixUnitaire;
    private String datePeremption;
    private String categorie;
    private int stockMinimum = 10;
    private int stockOptimal = 50;

    public Medicament(String code, String nom, String laboratoire,
                      int quantite, double prixUnitaire) {
        this.code = code;
        this.nom = nom;
        this.laboratoire = laboratoire;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.datePeremption = "";
        this.categorie = "";
    }

    // Constructeur simple pour compatibilité
    public Medicament(String nom, int quantite) {
        this.nom = nom;
        this.quantite = quantite;
        this.code = "MED" + System.currentTimeMillis();
        this.laboratoire = "Inconnu";
        this.prixUnitaire = 0.0;
    }

    public String getNom() { return nom; }
    public int getQuantite() { return quantite; }

    public void diminuerStock(int qte) {
        if (qte <= quantite) {
            quantite -= qte;
        }
    }

    public void augmenterStock(int qte) {
        quantite += qte;
    }

    // Nouveaux getters & setters
    public String getCode() { return code; }
    public String getLaboratoire() { return laboratoire; }
    public double getPrixUnitaire() { return prixUnitaire; }
    public int getStockMinimum() { return stockMinimum; }
    public int getStockOptimal() { return stockOptimal; }
    public String getDatePeremption() { return datePeremption; }
    public void setDatePeremption(String datePeremption) { this.datePeremption = datePeremption; }
    public String getCategorie() { return categorie; }
    public void setCategorie(String categorie) { this.categorie = categorie; }

    @Override
    public String toString() {
        return nom + " (" + code + ") - Stock: " + quantite + " - Prix: " + prixUnitaire + " DH";
    }
}