package model;

public class ServiceMedicament implements Facturable {
    private Medicament medicament;
    private int quantite;

    public ServiceMedicament(Medicament medicament, int quantite) {
        this.medicament = medicament;
        this.quantite = quantite;
    }

    @Override
    public double getPrix() {
        return medicament.getPrixUnitaire() * quantite;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public int getQuantite() {
        return quantite;
    }
}