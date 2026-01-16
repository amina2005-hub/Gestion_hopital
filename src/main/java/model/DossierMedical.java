package model;

import java.util.ArrayList;
import java.util.List;

public class DossierMedical {
    private Patient patient;
    private List<String> historiques = new ArrayList<>();

    public DossierMedical(Patient patient) {
        this.patient = patient;
    }

    public void ajouterNote(String note) {
        historiques.add(note);
    }

    public List<String> getHistoriques() {
        return historiques;
    }
    public Patient getPatient() {
        return patient;
    }
}
