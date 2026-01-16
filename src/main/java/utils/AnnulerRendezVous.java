package utils;

import model.RendezVous;

public class AnnulerRendezVous implements Commande {

    private RendezVous rendezVous;

    public AnnulerRendezVous(RendezVous rendezVous) {
        this.rendezVous = rendezVous;
    }

    @Override
    public void executer() {
        rendezVous.annuler();
        System.out.println("Rendez-vous annulé avec succès.");
    }
}
