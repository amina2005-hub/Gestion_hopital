package model;

import java.util.ArrayList;
import java.util.List;

public class Pharmacie {
    private List<Medicament> stock = new ArrayList<>();

    public void ajouterMedicament(Medicament m) {
        stock.add(m);
    }

    public void verifierStock() {
        for (Medicament m : stock) {
            if (m.getQuantite() < 5) {
                System.out.println("⚠ Stock faible : " + m.getNom());
            }
        }
    }

    public List<Medicament> getStock() {
        return stock;
    }
}
