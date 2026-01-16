package utils;

import model.Medicament;

public class PrescrireMedicament implements Commande {

    private Medicament medicament;
    private int quantite;

    public PrescrireMedicament(Medicament medicament, int quantite) {
        this.medicament = medicament;
        this.quantite = quantite;
    }

    @Override
    public void executer() {
        medicament.diminuerStock(quantite);
        System.out.println("Médicament prescrit : " + medicament.getNom());
    }
}
