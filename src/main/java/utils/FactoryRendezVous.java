package utils;

import model.*;

import java.time.LocalDateTime;

public class FactoryRendezVous {

    public static RendezVous creerRendezVous(
            String type, String id, Patient patient,
            Medecin medecin, LocalDateTime date) {

        // extensible si tu ajoutes d'autres types
        return new RendezVous(id, patient, medecin, date);
    }
}
