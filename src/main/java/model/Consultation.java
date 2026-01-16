package model;

public class Consultation implements Facturable {
    private double prix;

    public Consultation(double prix) {
        this.prix = prix;
    }

    @Override
    public double getPrix() {
        return prix;
    }


}
