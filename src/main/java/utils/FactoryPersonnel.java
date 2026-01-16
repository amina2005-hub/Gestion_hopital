package utils;

import model.*;

public class FactoryPersonnel {

    public static PersonnelMedical creerPersonnel(
            String type, String id, String nom, String prenom,
            String email, String specialite, String inpe) {

        switch (type.toLowerCase()) {
            case "medecin":
                return new Medecin(id, nom, prenom, email, specialite, inpe);
            case "infirmier":
                return new Infirmier(id, nom, prenom, email);
            case "pharmacien":
                return new Pharmacien(id, nom, prenom, email);
            default:
                throw new IllegalArgumentException("Type de personnel inconnu");
        }
    }
}
