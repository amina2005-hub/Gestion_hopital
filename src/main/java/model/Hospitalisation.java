package model;

public class Hospitalisation implements Facturable {
    private double prix;
    private int jours;

    public Hospitalisation(int jours) {
        this.jours = jours;
        this.prix = jours * 1000; // 1000 DH par jour
    }

    @Override
    public double getPrix() {
        return prix;
    }

    public int getJours() {
        return jours;
    }
}