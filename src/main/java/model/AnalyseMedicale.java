package model;

public class AnalyseMedicale implements Facturable {
    private String type;
    private double prix;

    public AnalyseMedicale(String type, double prix) {
        this.type = type;
        this.prix = prix;
    }

    @Override
    public double getPrix() {
        return prix;
    }

    public String getType() {
        return type;
    }
}